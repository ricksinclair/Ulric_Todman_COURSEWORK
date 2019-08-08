package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private static String stringChoice;
    private static List<Car> carList = new ArrayList<Car>();
    private static String inputtedMake;
    private static String inputtedModel;
    private static int inputtedYear;
    private static String inputtedColor;
    private static int inputtedMileage;
    private static Car currentVehicle;
    private static List<Car> filteredCars = new ArrayList<Car>();
    private static int numberChoice;
    private static String menuGraphic = "                                 _________\n" +
            "                          _.--\"\"'-----,   `\"--.._\n" +
            "                       .-''   _/_      ; .'\"----,`-,\n" +
            "                     .'      :___:     ; :      ;;`.`.\n" +
            "                    .      _.- _.-    .' :      ::  `..\n" +
            "                 __;..----------------' :: ___  ::   ;;\n" +
            "            .--\"\". '           ___.....`:=(___)-' :--'`.\n" +
            "          .'   .'         .--''__       :       ==:    ;\n" +
            "      .--/    /        .'.''     ``-,   :         :   '`-.\n" +
            "   .\"', :    /       .'-`\\\\       .--.\\ :         :  ,   _\\\n" +
            "  ;   ; |   ;       /:'  ;;      /__  \\\\:         :  :  /_\\\\\n" +
            "  |\\_/  |   |      / \\__//      /\"--\\\\ \\:         :  : ;|`\\|    \n" +
            "  : \"  /\\__/\\____//   \"\"\"      /     \\\\ :         :  : :|'||\n" +
            "[\"\"\"\"\"\"\"\"\"--------........._  /      || ;      __.:--' :|//|\n" +
            " \"------....______         ].'|      // |--\"\"\"'__...-'`\\ \\//\n" +
            "   `| WVE230L |__;_...--'\": :  \\    //  |---\"\"\"      \\__\\_/\n" +
            "     \"\"\"\"\"\"\"\"\"'            \\ \\  \\_.//  /\n" +
            "       `---'                \\ \\_     _'\n" +
            "                             `--`---'  \n" +
            " ©PSR Industries\n\n";

    public static void confirmAddValues(String stringChoice) {
        switch (stringChoice) {
            case "yes":
                currentVehicle = new Car(inputtedMake, inputtedModel, inputtedYear, inputtedColor, inputtedMileage);
                carList.add(currentVehicle);
                System.out.println("Car has been added!");
                listCars();

            case "no":
                addCar();
        }
    }


    public static void printCar(Car car) {
        System.out.println(car.getMake());
        System.out.println(car.getModel());
        System.out.println(car.getColor());
        System.out.println(car.getMileage());
        System.out.println(car.getYear());
        System.out.println("index is: " + carList.indexOf(car));


    }

    public static void deleteCar() {

        if (carList.size() == 0) {
            System.out.println("==========ERROR====================================================================");
            System.out.println("There are no cars to delete. Please add cars if you want to perform this operation.");
            System.out.println("===================================================================================");
            userMenu();
        }

        Scanner scanner = new Scanner(System.in);
        carList.stream().forEach(car ->
                printCar(car));
        System.out.println("Please select the car that you would like to delete. (enter its associated index number):");
        numberChoice = Integer.parseInt(scanner.nextLine());
        System.out.println("Are you sure you want to delete the below car?(Yes or no)");
        stringChoice = scanner.nextLine().toLowerCase();
        switch (stringChoice) {
            case "yes":
                carList.remove(numberChoice);
                if (carList.size() > 0) {
                    listCars();
                } else {
                    System.out.println("Last car successfully removed!");
                    userMenu();
                }
                break;

            case "no":
                System.out.println("The delete operation has been cancelled.");
                userMenu();
                break;

            default:
                System.out.println("Invalid input. Please try this operation again.");
                deleteCar();
                break;
        }

    }


    public static void addCar() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Please enter the make: ");
        inputtedMake = scanner.nextLine();
        System.out.printf("Please enter the model: ");
        inputtedModel = scanner.nextLine();
        System.out.printf("Please enter the year: ");
        try {
            inputtedYear = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Input must be an integer.");
            addCar();
        }

        System.out.printf("Please enter the color: ");
        inputtedColor = scanner.nextLine();
        System.out.printf("Please enter the mileage: ");
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
        confirmAddValues(stringChoice);
    }

    public static void listCars() {
        Scanner scanner = new Scanner(System.in);
        if (carList.size() == 0 | carList == null) {
            System.out.println("==ERROR=======================================");
            System.out.println("The list is empty. Please add cars to proceed.");
            System.out.println("==============================================");
            userMenu();
        } else {
            carList.stream().forEach(car -> {
                printCar(car);
                System.out.println("Index of car is: " + carList.indexOf(car));
            });
            stringChoice = "";
            System.out.println("Press any enter to proceed.");
            stringChoice = scanner.nextLine();
            if (stringChoice != "") {
                userMenu();
            } else {
                listCars();
            }

        }
    }

    public static void userMenu() {

        Scanner scanner = new Scanner(System.in);


        String mainMenuItems = "WELCOME TO THE PSR AUTO INVENTORY SYSTEM\n" +
                "Please choose an option below:\n" +
                "1 - List all vehicles\n" +
                "2 - Add a vehicle\n" +
                "3 - Delete a vehicle\n" +
                "4 - Search for a vehicle\n" +
                "5 - Exit Application\n\n";


        System.out.println(mainMenuItems + menuGraphic);

        try {
            numberChoice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid menu option (A NUMBER).");
        }
        switch (numberChoice) {
            case 1:
                listCars();
                System.out.println(mainMenuItems);
                userMenu();
                break;

            case 2:
                addCar();
                break;

            case 3:
                deleteCar();
                break;

            default:
                System.out.println("======Error=================================");
                System.out.println("Invalid input at user menu. Please try again");
                System.out.println("=============================================");
                userMenu();
                break;
        }


    }


    public static void main(String[] args) {
        userMenu();
    }
}
