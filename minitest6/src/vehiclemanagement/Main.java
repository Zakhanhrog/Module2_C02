package vehiclemanagement;

import java.util.*;

public class Main {

    private static final VehicleManager manager = new VehicleManager();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            choice = getUserChoice();
            handleChoice(choice);
        } while (choice != 0);

        scanner.close();
        System.out.println("\nExiting application. Goodbye!");
    }

    private static void displayMenu() {
        System.out.println("\n--- VEHICLE MANAGEMENT MENU ---");
        System.out.println("1. Add Vehicle");
        System.out.println("2. Remove Vehicle by ID");
        System.out.println("3. Display All Vehicles");
        System.out.println("4. Display Tax Report");
        System.out.println("5. Sort Vehicles by Year");
        System.out.println("6. Sort Vehicles by Brand");
        System.out.println("7. Sort Vehicles by Tax Amount");
        System.out.println("8. View Action History");
        System.out.println("0. Exit");
        System.out.println("-------------------------------");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        int choice = -1;
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
        } else {
            System.out.println("(!) Invalid input. Please enter a number.");
            scanner.next();
        }
        scanner.nextLine();
        return choice;
    }

    private static int getPositiveIntInput(String prompt) {
        int value = -1;
        while (value < 0) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value < 0) {
                    System.out.println("(!) Value cannot be negative. Please try again.");
                }
            } else {
                System.out.println("(!) Invalid input. Please enter a whole number.");
                value = -1;
                scanner.next();
            }
            scanner.nextLine();
        }
        return value;
    }

    private static String getNonEmptyStringInput(String prompt) {
        String input = "";
        while (input.trim().isEmpty()) {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("(!) Input cannot be empty. Please try again.");
            }
        }
        return input.trim();
    }

    private static void handleChoice(int choice) {
        switch (choice) {
            case 1:
                addVehicle();
                break;
            case 2:
                removeVehicle();
                break;
            case 3:
                manager.displayAllVehicles();
                break;
            case 4:
                manager.displayTaxReport();
                break;
            case 5:
                manager.sortByYear();
                break;
            case 6:
                manager.sortByBrand();
                break;
            case 7:
                manager.sortByTax();
                break;
            case 8:
                manager.printHistory();
                break;
            case 0:
                break;
            default:
                if (choice != -1) {
                    System.out.println("(!) Invalid choice. Please enter a number between 0 and 8.");
                }
                break;
        }
        if (choice != 0) {
            System.out.print("\n-- Press Enter to continue... --");
            scanner.nextLine();
        }
    }

    private static void addVehicle() {
        System.out.println("\n---> Add New Vehicle <---");
        int typeChoice = -1;
        while(typeChoice != 1 && typeChoice != 2) {
            System.out.print("Select vehicle type (1: Car, 2: Motorbike): ");
            if (scanner.hasNextInt()) {
                typeChoice = scanner.nextInt();
                if (typeChoice != 1 && typeChoice != 2) {
                    System.out.println("(!) Invalid type. Please enter 1 or 2.");
                }
            } else {
                System.out.println("(!) Invalid input. Please enter 1 or 2.");
                typeChoice = -1;
                scanner.next();
            }
            scanner.nextLine();
        }

        String id = getNonEmptyStringInput("Enter ID: ");
        String brand = getNonEmptyStringInput("Enter Brand: ");
        int year = getPositiveIntInput("Enter Year of Manufacture: ");

        Vehicle newVehicle = null;
        if (typeChoice == 1) {
            int seats = getPositiveIntInput("Enter Number of Seats: ");
            newVehicle = new Car(id, brand, year, seats);
        } else {
            int power = getPositiveIntInput("Enter Engine Power (CC): ");
            newVehicle = new Motorbike(id, brand, year, power);
        }
        manager.addVehicle(newVehicle);
    }

    private static void removeVehicle() {
        System.out.println("\n---> Remove Vehicle <---");
        String idToRemove = getNonEmptyStringInput("Enter the ID of the vehicle to remove: ");
        manager.removeVehicle(idToRemove);
    }
}