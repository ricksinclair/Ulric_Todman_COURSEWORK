package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InventoryHandler {

    private static String stringChoice;
    private static List<Car> carList = new ArrayList<Car>();
    private static Car currentVehicle;
    private static List<Car> filteredCars = new ArrayList<Car>();
    private static List<String> currentFilters = new ArrayList<String>(5);


    public static void displayCar(Car car) {

        System.out.println("||===========================");
        System.out.println("|| Make: " + car.getMake());
        System.out.println("|| Model: " + car.getModel());
        System.out.println("|| Color: " + car.getColor());
        System.out.println("|| Mileage: " + car.getMileage());
        System.out.println("|| Year: " + car.getYear());
        System.out.println("|| Index number of this car is: " + carList.indexOf(car));
        System.out.println("||===========================");


    }

    public static void listCars(List<Car> list) {
        Scanner scanner = new Scanner(System.in);
        if (list.size() == 0) {
            System.out.println("||===ERROR========================================||");
            System.out.println("|| The list is empty. Please add cars to proceed. ||");
            System.out.println("||================================================||");
            mainMenu();
        } else {
            list.forEach(InventoryHandler::displayCar);//Intellij told me this is a method reference and I could shorten lambdas with it
            stringChoice = "";              //It worked so I'll keep it and look it up!
            System.out.println("Press the enter/return key to proceed.");
            stringChoice = scanner.nextLine();
            stringChoice = "";
            mainMenu();


        }
    }


    public static void clearFilters() {
        filteredCars.clear();
        filteredCars.addAll(carList);
        currentFilters.clear();
    }

    public static List<Car> filterByMake(String make, List<Car> list) {
        return list.stream().filter(car -> car.getMake()
                .toLowerCase().equals(make.toLowerCase())).collect(Collectors.toList());
    }

    public static List<Car> filterByModel(String model, List<Car> list) {
        return list.stream().filter(car -> car.getModel()
                .toLowerCase().equals(model.toLowerCase())).collect(Collectors.toList());
    }

    public static List<Car> filterByYear(int year, List<Car> list) {
        return list.stream().filter(car -> car.getYear() == year).collect(Collectors.toList());
    }


    public static List<Car> filterByColor(String color, List<Car> list) {
        return list.stream().filter(car -> car.getColor().
                toLowerCase().equals(color.toLowerCase())).collect(Collectors.toList());
    }


    public static List<Car> filterByMileage(int mileage, List<Car> list) {
        return list.stream().filter(car -> car.getMileage() < mileage).collect(Collectors.toList());
    }

    public static void filterMenu() {
        Scanner scanner = new Scanner(System.in);
        String menu = "Please choose from the below options:\n" +
                "1 - Filter by make\n" +
                "2 - Filter by model\n" +
                "3 - Filter by color\n" +
                "4 - Filter by year\n" +
                "5 - Filter by mileage\n" +
                "6 - Clear all filters";
        int userChoice = 0;
        String userQuery = new String();

        System.out.println("Press enter with no input to go back to main menu");
        System.out.println("\n\n\n\n NOTE: Adding a car will automatically clear filters!\n\n\n");

        System.out.println(menu);
        System.out.println("Current Filters: " + currentFilters);
        try {
            userChoice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number and try again.");
        }
        switch (userChoice) {
            case 1:
                System.out.print("Please enter the make: ");
                userQuery = scanner.nextLine();
                currentFilters.add("Make - " + userQuery);
                filteredCars = filterByMake(userQuery, filteredCars);
                listCars(filteredCars);

                filterMenu();
                break;
            case 2:
                System.out.print("Please enter the model: ");
                userQuery = scanner.nextLine();
                currentFilters.add("Model - " + userQuery);
                filteredCars = filterByModel(userQuery, filteredCars);
                listCars(filteredCars);
                filterMenu();
                break;
            case 3:
                System.out.print("Please enter the color: ");
                userQuery = scanner.nextLine();
                currentFilters.add("Color - " + userQuery);
                filteredCars = filterByColor(userQuery, filteredCars);
                listCars(filteredCars);
                filterMenu();
                break;
            case 4:
                System.out.print("Please enter the year: ");
                try {
                    userChoice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Valid number not entered. Going back to filter menu.");
                    filterMenu();
                }
                currentFilters.add("year - " + userChoice);
                filterByYear(userChoice, filteredCars);
                listCars(filteredCars);
                filterMenu();
                break;
            case 5:
                System.out.print("Please enter the mileage: ");
                try {
                    userChoice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Valid number not entered. Going back to filter menu.");
                    filterMenu();
                }
                currentFilters.add("Mileage - " + userChoice);
                filterByMileage(userChoice, filteredCars);
                listCars(filteredCars);
                filterMenu();
                break;

            case 6:
                clearFilters();
                filterMenu();
                break;
            default:
                System.out.println("No valid choice made. Heading to main menu.");
                mainMenu();
        }

    }


    public static void deleteCar() {
        int numberChoice = 0;
        if (carList.size() == 0) {
            System.out.println("||===========ERROR=====================================================================||");
            System.out.println("|| There are no cars to delete. Please add cars if you want to perform this operation. ||");
            System.out.println("||=====================================================================================||");
            mainMenu();
        }

        Scanner scanner = new Scanner(System.in);
        carList.stream().forEach(car ->
                displayCar(car));
        System.out.println("Please select the car that you would like to delete. (enter its associated index number):");
        numberChoice = Integer.parseInt(scanner.nextLine());
        System.out.println("Are you sure you want to delete the below car?(Yes or no)");
        try {
            stringChoice = scanner.nextLine().toLowerCase();
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number. Going back to main menu.");
            mainMenu();
        }
        switch (stringChoice) {

            case "yes":
                carList.remove(numberChoice);
                if (carList.size() > 0) {
                    listCars(filteredCars);
                } else {
                    System.out.println("Last car successfully removed!");
                    mainMenu();
                }
                break;

            case "no":
                System.out.println("The delete operation has been cancelled.");
                mainMenu();
                break;

            default:
                System.out.println("Invalid input. Please try this operation again.");
                deleteCar();
                break;
        }


    }


    public static void addCar() {
        int inputtedMileage = 0;
        int inputtedYear = 0;
        System.out.println("\n\n\n\n\n\n\n\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the make: ");
        String inputtedMake = scanner.nextLine();
        System.out.print("Please enter the model: ");
        String inputtedModel = scanner.nextLine();
        System.out.print("Please enter the year: ");

        try {
            inputtedYear = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Input must be an integer.");
            addCar();
        }

        System.out.print("Please enter the color: ");
        String inputtedColor = scanner.nextLine();
        System.out.print("Please enter the mileage: ");
        try {
            inputtedMileage = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Input must be an integer.");
            addCar();
        }

        System.out.println("Are these values correct?");
        System.out.println("Make: " + inputtedMake);
        System.out.println("Model: " + inputtedModel);
        System.out.println("Year: " + inputtedYear);
        System.out.println("Color: " + inputtedColor);
        System.out.println("Mileage: " + inputtedMileage);
        System.out.println("Are these values correct? Please enter yes or no (case insensitive)");
        stringChoice = scanner.nextLine().toLowerCase();
        switch (stringChoice) {
            case "yes":
                carList.add(new Car(inputtedMake, inputtedModel, inputtedYear, inputtedColor, inputtedMileage));
                System.out.println("Car successfully added!");
                clearFilters();
                listCars(filteredCars);
                mainMenu();
                break;

            case "no":
                System.out.println("The add operation has been cancelled.");
                mainMenu();
                break;

            default:
                System.out.println("Invalid input. Please try this operation again.");
                mainMenu();
                break;
        }
    }


    public static void mainMenu() {
        int numberChoice = 0;
        Scanner scanner = new Scanner(System.in);


        String menuHeading = "================================================\n" +
                "||  WELCOME TO THE PSR AUTO INVENTORY SYSTEM  ||\n" +
                "================================================\n\n";


        String menuItems = "1 - List all vehicles                                               _________\n" +
                "2 - Add a vehicle                                         _.--\"\"'-----,   `\"--.._\n" +
                "3 - Delete a vehicle                                   .-''   _/_      ; .'\"----,`-,\n" +
                "4 - Search for a vehicle                             .'      :___:     ; :      ;;`.`.\n" +
                "5 - Exit Application                                .      _.- _.-    .' :      ::  `..\n" +
                "                                                 __;..----------------' :: ___  ::   ;;\n" +
                "                                            .--\"\". '           ___.....`:=(___)-' :--'`.\n" +
                "                                          .'   .'         .--''__       :       ==:    ;\n" +
                "                                      .--/    /        .'.''     ``-,   :         :   '`-.\n" +
                "                                   .\"', :    /       .'-`\\\\       .--.\\ :         :  ,   _\\\n" +
                "                                  ;   ; |   ;       /:'  ;;      /__  \\\\:         :  :  /_\\\\\n" +
                "                                  |\\_/  |   |      / \\__//      /\"--\\\\ \\:         :  : ;|`\\|    \n" +
                "                                  : \"  /\\__/\\____//   \"\"\"      /     \\\\ :         :  : :|'||\n" +
                "                                [\"\"\"\"\"\"\"\"\"--------........._  /      || ;      __.:--' :|//|\n" +
                "                                 \"------....______         ].'|      // |--\"\"\"'__...-'`\\ \\//\n" +
                "                                   `| ILUVJAVA|__;_...--'\": :  \\    //  |---\"\"\"      \\__\\_/\n" +
                "                                     \"\"\"\"\"\"\"\"\"'            \\ \\  \\_.//  /\n" +
                "                                       `---'                \\ \\_     _'\n" +
                "                                                             `--`---'  \n" +
                "                                 ©PSR Industries\n\n"
                + "                                This app is designed for terminal  heights of 30 lines or more ";
        System.out.println(menuHeading + menuItems);

        try {
            numberChoice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid menu option (A NUMBER).");
        }
        switch (numberChoice) {
            case 1:
                listCars(filteredCars);
                mainMenu();
                break;
            case 2:
                addCar();
                break;
            case 3:
                deleteCar();
                break;
            case 4:
                filterMenu();
                break;
            case 5:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("======Error=================================");
                System.out.println("Invalid input at user menu. Please try again");
                System.out.println("=============================================");
                mainMenu();
                break;
        }


    }


}