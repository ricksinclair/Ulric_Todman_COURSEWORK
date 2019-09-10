package com.company.UlricTodmanU1Capstone.service;

import com.company.UlricTodmanU1Capstone.dao.*;
import com.company.UlricTodmanU1Capstone.model.*;
import com.company.UlricTodmanU1Capstone.model.interfaces.Product;
import com.company.UlricTodmanU1Capstone.viewmodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Component
public class ServiceLayer {
    private ConsoleDao consoleDao;
    private GameDao gameDao;
    private InvoiceDao invoiceDao;
    private ProcessingFeeDao processingFeeDao;
    private SalesTaxRateDao salesTaxRateDao;
    private TShirtDao tShirtDao;
    private String[] stateAbbrevArr = {
            "AK",
            "AL",
            "AZ",
            "AR",
            "CA",
            "CO",
            "CT",
            "DE",
            "FL",
            "GA",
            "HI",
            "ID",
            "IL",
            "IN",
            "IA",
            "KS",
            "KY",
            "LA",
            "ME",
            "MD",
            "MA",
            "MI",
            "MN",
            "MS",
            "MO",
            "MT",
            "NE",
            "NV",
            "NH",
            "NJ",
            "NM",
            "NY",
            "NC",
            "ND",
            "OH",
            "OK",
            "OR",
            "PA",
            "RI",
            "SC",
            "SD",
            "TN",
            "TX",
            "UT",
            "VT",
            "VA",
            "WA",
            "WV",
            "WI",
            "WY"};

    private String[] ratingsArray = {"RP", "E", "E10+", "T", "M", "AO"};
    private Set<String> ratingsSet = new HashSet<>(Arrays.asList(ratingsArray));
    private Set<String> stateSet = new HashSet<>(Arrays.asList(stateAbbrevArr));

    @Autowired
    public ServiceLayer(ConsoleDao consoleDao, GameDao gameDao, InvoiceDao invoiceDao, ProcessingFeeDao processingFeeDao, SalesTaxRateDao salesTaxRateDao, TShirtDao tShirtDao) {
        this.consoleDao = consoleDao;
        this.gameDao = gameDao;
        this.invoiceDao = invoiceDao;
        this.processingFeeDao = processingFeeDao;
        this.salesTaxRateDao = salesTaxRateDao;
        this.tShirtDao = tShirtDao;
    }



    //The next two methods could have been squished together for 1/2 the dB calls, but I wanted to separate concerns.
    private boolean validateOrderQuantity(int quantity, String productType, int productId) {

        if (quantity <= 0) {
            throw new IllegalArgumentException("Item quantity must be greater than zero");
        } else {

            switch (productType) {

                case "Consoles":
                    Console console = consoleDao.getConsole(productId);
                    if (console.getQuantity() <= 0 || console.getQuantity() - quantity <= 0) {
                        throw new IllegalArgumentException("Not enough of this console in stock to satisfy order");
                    } else {
                        return true;
                    }
                case "T-Shirts":
                    TShirt tShirt = tShirtDao.getTShirt(productId);
                    if (tShirt.getQuantity() <= 0 || tShirt.getQuantity() - quantity <= 0) {
                        throw new IllegalArgumentException("Not enough of this t-shirt in stock to satisfy order");
                     } else {
                        return true;
                    }
                case "Games":
                    Game game = gameDao.getGame(productId);
                    if (game.getQuantity() <= 0 || game.getQuantity() - quantity <= 0) {
                        throw new IllegalArgumentException("Not enough of this game in stock to satisfy order");
                    } else {

                        return true;
                    }

                default:
                    throw new IllegalArgumentException("Valid product types are \"Consoles\",\"T-Shirts\", and \"Games\" (excluding quotes). Please provide valid value and try again.");


            }
        }
    }


    @Transactional
    private void updateDatabaseQuantities(int quantity, String productType, int productId) {

        int currentQuantity;
        int newQuantity;
        switch (productType) {
            case "Consoles":
                Console console = consoleDao.getConsole(productId);
                currentQuantity = console.getQuantity();
                newQuantity = currentQuantity - quantity;
                console.setQuantity(newQuantity);
                consoleDao.updateConsole(console);
                break;
            case "T-Shirts":
                TShirt tShirt = tShirtDao.getTShirt(productId);
                currentQuantity = tShirt.getQuantity();
                newQuantity = currentQuantity - quantity;
                tShirt.setQuantity(newQuantity);
                tShirtDao.updateTShirt(tShirt);
                break;
            case "Games":
                Game game = gameDao.getGame(productId);
                currentQuantity = game.getQuantity();
                newQuantity = currentQuantity - quantity;
                game.setQuantity(newQuantity);
                gameDao.updateGame(game);
                break;
            //maybe the default for the next few are not needed due to the order things are called, but I wanted to be sure the exception would be thrown in a wacky scenario where they made
            //it past the methods above.
            default:
                throw new IllegalArgumentException("Valid options for product type are \"Consoles\",\"T-Shirts\", and \"Games\" (excluding quotes). Please provide valid value and try again.");

        }


    }

    private BigDecimal setProcessingFee(String productType, int quantity) {
        BigDecimal processingFee;
        switch (productType) {
            case "Consoles":
                processingFee = processingFeeDao.getProcessingFee("Consoles").getFee();
                break;
            case "T-Shirts":
                processingFee = processingFeeDao.getProcessingFee("T-Shirts").getFee();
                break;
            case "Games":
                processingFee = processingFeeDao.getProcessingFee("Games").getFee();
                break;
            default:
                throw new IllegalArgumentException("Valid options for product type are \"Consoles\",\"T-Shirts\", and \"Games\" (excluding quotes). Please provide valid value and try again.");
        }

        if (quantity >= 10) {
            processingFee = processingFee.add(new BigDecimal("15.49"));
        }

        return processingFee;
    }

private boolean validateRating(Game game){
        if(ratingsSet.contains(game.getEsrbRating())){
            return true;
        }else{
            throw new IllegalArgumentException(" MUST PROVIDE VALID ESRB RATING. \"RP\", \"E\", \"E10+\", \"T\", \"M\", \"AO\" (without quotes) are all valid options.");
        }
}


        //Get product method
//        make each product implement the product interface.

    @Transactional
    public Invoice processInvoiceReq(CustomerOrder customerOrder) {
         int quantity = customerOrder.getQuantity();
        int itemId = customerOrder.getItemId();
        String itemType = customerOrder.getItemType();
        String state = customerOrder.getState();
        Invoice invoice = new Invoice();
        Product product ;



            if (validateOrderQuantity(quantity, itemType, itemId)) {
                switch(itemType){
                    case "Consoles":
                        product =  consoleDao.getConsole(itemId);
                        break;

                    case"T-Shirts":
                        product = tShirtDao.getTShirt(itemId);
                        break;
                    case "Games":
                        product =  gameDao.getGame(itemId);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + itemType);
                }

                invoice.setUnitPrice(product.getPrice());
                invoice.setSubTotal( invoice.getUnitPrice().multiply(new BigDecimal(quantity)));
                if (stateSet.contains(state)) {
                    invoice.setTax( salesTaxRateDao.getTaxRate(state).getRate().multiply(invoice.getSubTotal()).setScale(2, RoundingMode.DOWN));
                } else {
                    throw new IllegalArgumentException("STATE MUST BE IN TWO-CHARACTER ABBREVIATED FORMAT");

                }
                updateDatabaseQuantities(quantity, itemType, itemId);
                invoice.setName(customerOrder.getName());
                invoice.setStreet(customerOrder.getStreet());
                invoice.setCity(customerOrder.getCity());
                invoice.setItemId(itemId);
                invoice.setItemType(itemType);
                invoice.setState(customerOrder.getState());
                invoice.setZipCode(customerOrder.getZipCode());
                invoice.setProcessingFee(setProcessingFee(itemType, quantity));
                invoice.setQuantity(customerOrder.getQuantity());
                invoice.setTotal(invoice.getSubTotal().add(invoice.getProcessingFee().add(invoice.getTax())).setScale(2, RoundingMode.DOWN));

                invoice = invoiceDao.addInvoice(invoice);
            }




            return invoice;
    }




    public ViewModel buildViewModel(Invoice invoice){
        switch (invoice.getItemType()){
            case "T-Shirts":
                TShirtViewModel tShirtViewModel = new TShirtViewModel();
                TShirt tShirt = tShirtDao.getTShirt(invoice.getItemId());
                tShirtViewModel.setInvoice(invoice);
                tShirtViewModel.setColor(tShirt.getColor());
                tShirtViewModel.setDescription(tShirt.getDescription());
                tShirtViewModel.setSize(tShirt.getSize());
                return tShirtViewModel;
            case "Consoles":
                ConsoleViewModel consoleViewModel = new ConsoleViewModel();
                Console console = consoleDao.getConsole(invoice.getItemId());
                consoleViewModel.setManufacturer(console.getManufacturer());
                consoleViewModel.setMemoryAmount(console.getMemoryAmount());
                consoleViewModel.setProcessor(console.getProcessor());
                consoleViewModel.setModel(console.getModel());
                return consoleViewModel;

            case "Games":
                GameViewModel gameViewModel = new GameViewModel();
                Game game = gameDao.getGame(invoice.getItemId());
                gameViewModel.setDescription(game.getDescription());
                gameViewModel.setEsrbRating(game.getEsrbRating());
                gameViewModel.setStudio(game.getStudio());
                gameViewModel.setTitle(game.getTitle());
                return gameViewModel;

            default:
                throw new IllegalStateException("Unexpected value: " + invoice.getItemType());

        }
    }
    //CRUD REQUEST METHODS FOR TSHIRT, CONSOLE, GAME



    //Game Methods
    public Game addGame(Game game) {
        if (validateRating(game)) {
            return gameDao.addGame(game);
        } else {
            return null;
        }


    }

    public Game getGame(int gameId) {
        return gameDao.getGame(gameId);
    }

    public List<Game> getAllGames() {
        return gameDao.getAllGames();
    }

    public List<Game> getGamesByStudio(String studio) {
        return gameDao.getGamesByStudio(studio);
    }

    public List<Game> getGamesByRating(String rating) {
        return gameDao.getGamesByRating(rating);
    }

    public List<Game> getGamesByTitle(String title) {
        return gameDao.getGamesByTitle(title);
    }

    public void updateGame(Game game) {
        gameDao.updateGame(game);
    }

    public void deleteGame(int gameId) {
        gameDao.deleteGame(gameId);
    }

    //Console Methods

    public Console addConsole(Console console) {
        return consoleDao.addConsole(console);
    }

    public Console getConsole(int consoleId) {
        return consoleDao.getConsole(consoleId);
    }

    public List<Console> getAllConsoles() {
        return consoleDao.getAllConsoles();
    }

    public List<Console> getConsolesByManufacturer(String manufacturer) {
        return consoleDao.getConsolesByManufacturer(manufacturer);
    }

    public void updateConsole(Console console) {
        consoleDao.updateConsole(console);
    }

    public void deleteConsole(int consoleId) {
        consoleDao.deleteConsole(consoleId);
    }

    //T-Shirt Methods

    public TShirt addTShirt(TShirt tShirt) {
        return tShirtDao.addTShirt(tShirt);
    }

    public TShirt getTShirt(int tShirtId) {
        return tShirtDao.getTShirt(tShirtId);
    }

    public List<TShirt> getAllTShirts() {
        return tShirtDao.getAllTShirts();
    }

    public List<TShirt> getTShirtsBySize(String size) {
        return tShirtDao.getTShirtsBySize(size);
    }

    public List<TShirt> getTShirtsByColor(String color) {
        return tShirtDao.getTShirtsByColor(color);
    }

    public void updateTShirt(TShirt tShirt) {
        tShirtDao.updateTShirt(tShirt);
    }

    public void deleteTShirt(int tShirtId) {
        tShirtDao.deleteTShirt(tShirtId);
    }

    public Invoice getInvoice(int invoiceId){ return invoiceDao.getInvoice(invoiceId);}
    public void deleteInvoice(int invoiceId){ invoiceDao.deleteInvoice(invoiceId);}
    public List<Invoice> getAllInvoices(){ return invoiceDao.getAllInvoices();}


}
