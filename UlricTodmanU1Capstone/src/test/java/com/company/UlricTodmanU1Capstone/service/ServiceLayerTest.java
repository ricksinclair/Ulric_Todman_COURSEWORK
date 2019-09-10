package com.company.UlricTodmanU1Capstone.service;

import com.company.UlricTodmanU1Capstone.dao.*;
import com.company.UlricTodmanU1Capstone.model.*;
import com.company.UlricTodmanU1Capstone.viewmodel.CustomerOrder;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

public class ServiceLayerTest {


    ServiceLayer serviceLayer;
    ConsoleDao consoleDao;
    TShirtDao tShirtDao;
    GameDao gameDao;
    InvoiceDao invoiceDao;
    ProcessingFeeDao processingFeeDao;
    SalesTaxRateDao salesTaxRateDao;


@Before
public void setUp() throws Exception{
    setUpConsoleDaoMock();
    setUpGameDaoMock();
    setUpInvoiceDaoMock();
    setUpProcessingFeeDaoMock();
    setUpTaxRateDaoMock();
    setUpTShirtDaoMock();
    serviceLayer = new ServiceLayer(consoleDao, gameDao, invoiceDao, processingFeeDao, salesTaxRateDao,  tShirtDao);
}


    private void setUpInvoiceDaoMock(){
        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);



        Invoice invoice = new Invoice();
        invoice.setInvoiceId(1);
        invoice.setName("John Doe");
        invoice.setStreet("1155 Broadway");
        invoice.setCity("New York");
        invoice.setState("NY");
        invoice.setZipCode("10012");
        invoice.setItemId(1);
        invoice.setItemType("Consoles");
        invoice.setSubTotal(new BigDecimal("299.99"));
        invoice.setTax(new BigDecimal("17.99"));
        invoice.setProcessingFee(new BigDecimal("14.99"));
        invoice.setUnitPrice(new BigDecimal("299.99"));
        invoice.setTotal(new BigDecimal("332.97"));
        invoice.setQuantity(1);

        Invoice invoice2 = new Invoice();
        invoice2.setName("John Doe");
        invoice2.setStreet("1155 Broadway");
        invoice2.setCity("New York");
        invoice2.setState("NY");
        invoice2.setZipCode("10012");
        invoice2.setItemId(1);
        invoice2.setItemType("Consoles");
        invoice2.setSubTotal(new BigDecimal("299.99"));
        invoice2.setTax(new BigDecimal("17.99"));
        invoice2.setProcessingFee(new BigDecimal("14.99"));
        invoice2.setUnitPrice(new BigDecimal("299.99"));
        invoice2.setTotal(new BigDecimal("332.97"));
        invoice2.setQuantity(1);


        doReturn(invoice).when(invoiceDao).addInvoice(invoice2);
        doReturn(invoice).when(invoiceDao).getInvoice(invoice.getInvoiceId());
        doNothing().when(invoiceDao).deleteInvoice(invoice2.getInvoiceId());

    }

    @Test
    public void addGetInvoice(){
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setName("John Doe");
        customerOrder.setStreet("1155 Broadway");
        customerOrder.setCity("New York");
        customerOrder.setState("NY");
        customerOrder.setZipCode("10012");
        customerOrder.setItemId(1);
        customerOrder.setItemType("Consoles");
        customerOrder.setQuantity(1);

        Invoice invoice = serviceLayer.processInvoiceReq(customerOrder);
        Invoice invoice1 = serviceLayer.getInvoice(invoice.getInvoiceId());

        assertEquals(invoice, invoice1);
    }

    private void setUpProcessingFeeDaoMock(){
        processingFeeDao = mock(ProcessingFeeDaoJdbcTemplateImpl.class);
        ProcessingFee processingFee = new ProcessingFee();

        processingFee.setProductType("Consoles");
        processingFee.setFee(new BigDecimal("14.99"));
        doReturn(processingFee).when(processingFeeDao).getProcessingFee("Consoles");
    }



    private void setUpTaxRateDaoMock(){
        salesTaxRateDao = mock(SalesTaxRateDaoJdbcTemplateImpl.class);
        SalesTaxRate nyTax = new SalesTaxRate();
        nyTax.setState("NY");
        nyTax.setRate(new BigDecimal(".06"));
        doReturn(nyTax).when(salesTaxRateDao).getTaxRate("NY");


    }

    private void setUpGameDaoMock(){
        gameDao = mock(GameDaoJdbcTemplateImpl.class);
        Game game = new Game();
        game.setGameId(1);
        game.setTitle("Call of Duty");
        game.setStudio("Activision");
        game.setDescription("The highly acclaimed FPS is back for a reboot");
        game.setEsrbRating("M");
        game.setQuantity(10);
        game.setPrice(new BigDecimal("59.99"));

        Game game2 = new Game();
        game2.setTitle("Call of Duty");
        game2.setStudio("Activision");
        game2.setDescription("The highly acclaimed FPS is back for a reboot");
        game2.setEsrbRating("M");
        game2.setQuantity(10);
        game2.setPrice(new BigDecimal("59.99"));

        Game game3 = new Game();
        game3.setGameId(2);
        game3.setTitle("Battlefield");
        game3.setStudio("Electronic Arts");
        game3.setDescription("The highly acclaimed war game");
        game3.setEsrbRating("M");
        game3.setQuantity(10);
        game3.setPrice(new BigDecimal("59.99"));

        Game game4 = new Game();
        game4.setTitle("Battlefield");
        game4.setStudio("Electronic Arts");
        game4.setDescription("The highly acclaimed war game");
        game4.setEsrbRating("M");
        game4.setQuantity(10);
        game4.setPrice(new BigDecimal("59.99"));

        Game updatedGame = new Game();
        updatedGame.setTitle("World of Warcraft");
        updatedGame.setQuantity(10);
        updatedGame.setDescription("Orcs Vs Humans...Who will YOU be?");
        updatedGame.setEsrbRating("T");
        updatedGame.setStudio("Blizzard");
        updatedGame.setGameId(5);
        updatedGame.setPrice(new BigDecimal("29.99"));
        Game notUpdatedGame = new Game();
        notUpdatedGame.setTitle("World of Warcraft");
        notUpdatedGame.setQuantity(10);
        notUpdatedGame.setDescription("Orcs Vs Humans...Who will YOU be?");
        notUpdatedGame.setEsrbRating("T");
        notUpdatedGame.setStudio("Blizzard");
        notUpdatedGame.setGameId(5);
        notUpdatedGame.setPrice(new BigDecimal("19.99"));


        List<Game> gameList = new ArrayList<>();
        gameList.add(game);
        gameList.add(game3);
        List<Game> activisionGames = new ArrayList<>();
        activisionGames.add(game);


        doReturn(notUpdatedGame).when(gameDao).addGame(notUpdatedGame);
        doReturn(game).when(gameDao).addGame(game2);
        doReturn(game3).when(gameDao).addGame(game4);
        doReturn(game).when(gameDao).getGame(game.getGameId());
        doReturn(updatedGame).when(gameDao).getGame(updatedGame.getGameId());
        doReturn(gameList).when(gameDao).getAllGames();
        doReturn(activisionGames).when(gameDao).getGamesByStudio("Activision");
        doReturn(gameList).when(gameDao).getGamesByRating("M");
        doReturn(activisionGames).when(gameDao).getGamesByTitle("Call of Duty");
        doNothing().when(gameDao).deleteGame(game3.getGameId());
        doNothing().when(gameDao).updateGame(updatedGame);
        doReturn(null).when(gameDao).getGame(game3.getGameId());

    }

    @Test
    public void updateGame(){
        Game game = new Game();
        game.setTitle("World of Warcraft");
        game.setQuantity(10);
        game.setDescription("Orcs Vs Humans...Who will YOU be?");
        game.setEsrbRating("T");
        game.setStudio("Blizzard");
        game.setGameId(5);
        game.setPrice(new BigDecimal("19.99"));

        game  = serviceLayer.addGame(game);
        game.setPrice(new BigDecimal("29.99"));
        serviceLayer.updateGame(game);
        Game updatedGame = serviceLayer.getGame(game.getGameId());
        assertEquals(game, updatedGame);
    }

    @Test
    public void getGameLists(){
        Game game = new Game();
        game.setTitle("Call of Duty");
        game.setStudio("Activision");
        game.setDescription("The highly acclaimed FPS is back for a reboot");
        game.setEsrbRating("M");
        game.setQuantity(10);
        game.setPrice(new BigDecimal("59.99"));
        game = serviceLayer.addGame(game);
        Game game3 = new Game();
        game3.setTitle("Battlefield");
        game3.setStudio("Electronic Arts");
        game3.setDescription("The highly acclaimed war game");
        game3.setEsrbRating("M");
        game3.setQuantity(10);
        game3.setPrice(new BigDecimal("59.99"));
        game3 = serviceLayer.addGame(game3);
        List<Game> gameList = serviceLayer.getAllGames();
        assertEquals(gameList.size(), 2);

        List<Game> activision = serviceLayer.getGamesByStudio("Activision");
        assertEquals(activision.size(), 1);

        List<Game> codGames = serviceLayer.getGamesByTitle("Call of Duty");
        assertEquals(activision.size(), 1);

    }


    @Test
    public void addGetDeleteGame(){

         Game game = new Game();
        game.setTitle("Call of Duty");
        game.setStudio("Activision");
        game.setDescription("The highly acclaimed FPS is back for a reboot");
        game.setEsrbRating("M");
        game.setQuantity(10);
        game.setPrice(new BigDecimal("59.99"));
        game = serviceLayer.addGame(game);

        Game game2 = serviceLayer.getGame(game.getGameId());
        assertEquals(game, game2);

        Game game3 = new Game();
        game3.setTitle("Battlefield");
        game3.setStudio("Electronic Arts");
        game3.setDescription("The highly acclaimed war game");
        game3.setEsrbRating("M");
        game3.setQuantity(10);
        game3.setPrice(new BigDecimal("59.99"));
        game3 = serviceLayer.addGame(game3);

        serviceLayer.deleteGame(game3.getGameId());
        Game game4 = serviceLayer.getGame(game3.getGameId());
        assertNull(game4);


    }



    private void setUpTShirtDaoMock(){
        tShirtDao = mock(TShirtDaoJdbcTemplateImpl.class);
        TShirt tShirt = new TShirt();
        tShirt.setTShirtId(1);
        tShirt.setSize("XL");
        tShirt.setColor("Blue");
        tShirt.setPrice(new BigDecimal("29.99"));
        tShirt.setDescription("Big Blue Shirt");
        tShirt.setQuantity(10);

        TShirt tShirt2 = new TShirt();
        tShirt2.setSize("XL");
        tShirt2.setColor("Blue");
        tShirt2.setPrice(new BigDecimal("29.99"));
        tShirt2.setDescription("Big Blue Shirt");
        tShirt2.setQuantity(10);


        TShirt tShirt3 = new TShirt();
        tShirt3.setTShirtId(2);
        tShirt3.setSize("XL");
        tShirt3.setColor("Red");
        tShirt3.setPrice(new BigDecimal("29.99"));
        tShirt3.setDescription("Big Red Shirt");
        tShirt3.setQuantity(10);

        TShirt tShirt4 = new TShirt();
        tShirt4.setSize("XL");
        tShirt4.setColor("Red");
        tShirt4.setPrice(new BigDecimal("29.99"));
        tShirt4.setDescription("Big Red Shirt");
        tShirt4.setQuantity(10);

        TShirt updatedShirt = new TShirt();
        updatedShirt.setTShirtId(5);
        updatedShirt.setSize("L");
        updatedShirt.setColor("Black");
        updatedShirt.setDescription("Large Black Shirt");
        updatedShirt.setQuantity(10);
        updatedShirt.setPrice(new BigDecimal("19.99"));

        TShirt notUpdatedShirt = new TShirt();
        notUpdatedShirt.setTShirtId(5);
        notUpdatedShirt.setSize("L");
        notUpdatedShirt.setColor("Black");
        notUpdatedShirt.setDescription("Large Black Shirt");
        notUpdatedShirt.setQuantity(10);
        notUpdatedShirt.setPrice(new BigDecimal("14.99"));

        List<TShirt> redList = new ArrayList<>();
        redList.add(tShirt3);

        List<TShirt> xlShirts = new ArrayList<>();
        xlShirts.add(tShirt);
        xlShirts.add(tShirt3);

        List<TShirt> tShirtList = new ArrayList<>();
        tShirtList.add(tShirt);
        tShirtList.add(tShirt3);
//        List<TShirt> emptyList = new ArrayList<>();

        doReturn(notUpdatedShirt).when(tShirtDao).addTShirt(notUpdatedShirt);
        doNothing().when(tShirtDao).deleteTShirt(tShirt3.getTShirtId());
        doReturn(tShirt).when(tShirtDao).getTShirt(1);
        doReturn(tShirt).when(tShirtDao).addTShirt(tShirt2);
        doReturn(tShirt3).when(tShirtDao).addTShirt(tShirt4);
        doNothing().when(tShirtDao).deleteTShirt(tShirt4.getTShirtId());
        doReturn(null).when(tShirtDao).getTShirt(tShirt3.getTShirtId());
        doNothing().when(tShirtDao).updateTShirt(updatedShirt);
        doReturn(updatedShirt).when(tShirtDao).getTShirt(updatedShirt.getTShirtId());
        doReturn(xlShirts).when(tShirtDao).getTShirtsBySize("XL");
        doReturn(redList).when(tShirtDao).getTShirtsByColor("Red");
        doReturn(tShirtList).when(tShirtDao).getAllTShirts();
    }

    @Test
    public void getTShirtLists(){
        TShirt tShirt = new TShirt();
        tShirt.setSize("XL");
        tShirt.setColor("Blue");
        tShirt.setPrice(new BigDecimal("29.99"));
        tShirt.setDescription("Big Blue Shirt");
        tShirt.setQuantity(10);
        tShirt = serviceLayer.addTShirt(tShirt);

        TShirt tShirt2 = new TShirt();
        tShirt2.setSize("XL");
        tShirt2.setColor("Red");
        tShirt2.setPrice(new BigDecimal("29.99"));
        tShirt2.setDescription("Big Red Shirt");
        tShirt2.setQuantity(10);
        tShirt2 = serviceLayer.addTShirt(tShirt2);

        List<TShirt> allShirts = serviceLayer.getAllTShirts();
        assertEquals(allShirts.size(), 2);

        List<TShirt> redShirts = serviceLayer.getTShirtsByColor("Red");
        assertEquals(redShirts.size(), 1);
        List<TShirt> xlShirts = serviceLayer.getTShirtsBySize("XL");
        assertEquals(xlShirts.size(), 2);


    }


    @Test
    public void updateTShirt(){
        TShirt tshirt = new TShirt();
        tshirt.setTShirtId(5);
        tshirt.setSize("L");
        tshirt.setColor("Black");
        tshirt.setDescription("Large Black Shirt");
        tshirt.setQuantity(10);
        tshirt.setPrice(new BigDecimal("14.99"));

        tshirt = serviceLayer.addTShirt(tshirt);
        tshirt.setPrice(new BigDecimal("19.99"));
        serviceLayer.updateTShirt(tshirt);

        TShirt tShirt2 = serviceLayer.getTShirt(tshirt.getTShirtId());
        assertEquals(tshirt, tShirt2);



    }

    @Test
    public void addGetDeleteTShirt(){
        TShirt tShirt = new TShirt();
        tShirt.setSize("XL");
        tShirt.setColor("Blue");
        tShirt.setPrice(new BigDecimal("29.99"));
        tShirt.setDescription("Big Blue Shirt");
        tShirt.setQuantity(10);

        tShirt = serviceLayer.addTShirt(tShirt);
        TShirt tShirt1 = serviceLayer.getTShirt(tShirt.getTShirtId());
        assertEquals(tShirt, tShirt1);

        TShirt tShirt2 = new TShirt();
        tShirt2.setSize("XL");
        tShirt2.setColor("Red");
        tShirt2.setPrice(new BigDecimal("29.99"));
        tShirt2.setDescription("Big Red Shirt");
        tShirt2.setQuantity(10);

        tShirt2 = serviceLayer.addTShirt(tShirt2);

        serviceLayer.deleteTShirt(tShirt2.getTShirtId());

        TShirt tShirt3 = serviceLayer.getTShirt(tShirt2.getTShirtId());
        assertNull(tShirt3);




    }

    private void setUpConsoleDaoMock() {
        consoleDao = mock(ConsoleDaoJdbcTemplateImpl.class);
        Console console = new Console();
        console.setConsoleId(1);
        console.setModel("Xbox One");
        console.setManufacturer("Microsoft");
        console.setMemoryAmount("8GB");
        console.setProcessor("10");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(5);

        Console console2 = new Console();
        console2.setModel("Xbox One");
        console2.setManufacturer("Microsoft");
        console2.setMemoryAmount("8GB");
        console2.setProcessor("10");
        console2.setPrice(new BigDecimal("299.99"));
        console2.setQuantity(5);

        Console console3 = new Console();
        console3.setConsoleId(2);
        console3.setModel("PS4 Pro");
        console3.setManufacturer("Sony");
        console3.setMemoryAmount("8GB");
        console3.setProcessor("10");
        console3.setPrice(new BigDecimal("299.99"));
        console3.setQuantity(5);

        Console console4 = new Console();
        console4.setModel("PS4 Pro");
        console4.setManufacturer("Sony");
        console4.setMemoryAmount("8GB");
        console4.setProcessor("10");
        console4.setPrice(new BigDecimal("299.99"));
        console4.setQuantity(5);



        Console notUpdatedConsole = new Console();
        notUpdatedConsole.setConsoleId(5);
        notUpdatedConsole.setModel("PS4 Pro");
        notUpdatedConsole.setManufacturer("Sony");
        notUpdatedConsole.setMemoryAmount("8GB");
        notUpdatedConsole.setProcessor("10");
        notUpdatedConsole.setPrice(new BigDecimal("199.99"));
        notUpdatedConsole.setQuantity(5);

        Console updatedConsole = new Console();
        updatedConsole.setConsoleId(5);
        updatedConsole.setModel("PS4");
        updatedConsole.setManufacturer("Sony");
        updatedConsole.setMemoryAmount("8GB");
        updatedConsole.setProcessor("10");
        updatedConsole.setPrice(new BigDecimal("199.99"));
        updatedConsole.setQuantity(5);

        List<Console> cList = new ArrayList<>();
        cList.add(console);
        cList.add(console3);

        List<Console> sonyConsoles = new ArrayList<>();
        sonyConsoles.add(console3);

        doReturn(console).when(consoleDao).addConsole(console2);
        doReturn(console3).when(consoleDao).addConsole(console4);
        doReturn(console).when(consoleDao).getConsole(console.getConsoleId());
        doReturn(console).when(consoleDao).getConsole(1);
        doNothing().when(consoleDao).deleteConsole(console3.getConsoleId());
        doReturn(null).when(consoleDao).getConsole(console3.getConsoleId());
        doReturn(notUpdatedConsole).when(consoleDao).addConsole(notUpdatedConsole);
        doReturn(updatedConsole).when(consoleDao).getConsole(updatedConsole.getConsoleId());
        doReturn(cList).when(consoleDao).getAllConsoles();
        doReturn(sonyConsoles).when(consoleDao).getConsolesByManufacturer("Sony");
        doNothing().when(consoleDao).updateConsole(updatedConsole);
    }

    @Test
    public void addGetDeleteConsole(){

        Console console = new Console();
        console.setModel("Xbox One");
        console.setManufacturer("Microsoft");
        console.setMemoryAmount("8GB");
        console.setProcessor("10");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(5);

        console =  serviceLayer.addConsole(console);
        Console fromService = serviceLayer.getConsole(console.getConsoleId());
        assertEquals(console, fromService);

        Console console4 = new Console();
        console4.setModel("PS4 Pro");
        console4.setManufacturer("Sony");
        console4.setMemoryAmount("8GB");
        console4.setProcessor("10");
        console4.setPrice(new BigDecimal("299.99"));
        console4.setQuantity(5);
        console4 = serviceLayer.addConsole(console4);
        serviceLayer.deleteConsole(console4.getConsoleId());
        Console deletedConsole = serviceLayer.getConsole(console4.getConsoleId());
        assertNull(deletedConsole);
    }

    @Test
    public void updateConsole(){

        Console console = new Console();
        console.setConsoleId(5);
        console.setModel("PS4 Pro");
        console.setManufacturer("Sony");
        console.setMemoryAmount("8GB");
        console.setProcessor("10");
        console.setPrice(new BigDecimal("199.99"));
        console.setQuantity(5);
        console = serviceLayer.addConsole(console);
        console.setModel("PS4");
        serviceLayer.updateConsole(console);
        Console console2 = serviceLayer.getConsole(console.getConsoleId());
        assertEquals(console2, console);
}

    @Test
    public void getConsoleLists(){
        Console console2 = new Console();
        console2.setModel("Xbox One");
        console2.setManufacturer("Microsoft");
        console2.setMemoryAmount("8GB");
        console2.setProcessor("10");
        console2.setPrice(new BigDecimal("299.99"));
        console2.setQuantity(5);
        console2 = serviceLayer.addConsole(console2);

        Console console4 = new Console();
        console4.setModel("PS4 Pro");
        console4.setManufacturer("Sony");
        console4.setMemoryAmount("8GB");
        console4.setProcessor("10");
        console4.setPrice(new BigDecimal("299.99"));
        console4.setQuantity(5);
        console4 = serviceLayer.addConsole(console4);

        List<Console> cList = serviceLayer.getAllConsoles();
        assertEquals(cList.size(), 2);

        List<Console> sonyList = serviceLayer.getConsolesByManufacturer("Sony");
        assertEquals(sonyList.size(), 1);

    }

}
