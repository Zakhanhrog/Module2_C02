package View;

import Controller.OrderManager;
import Model.ClothingOrder;
import Model.ElectronicsOrder;
import Model.Order;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    private static OrderManager orderManager = new OrderManager();
    private static Scanner scanner = new Scanner(System.in);
    private static final String DATA_FILENAME = "/Users/ngogiakhanh/Documents/Module 2/Minitest 7/src/Storage/order.dat";

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            choice = getUserChoice();

            switch (choice) {
                case 1:
                    addNewOrder();
                    break;
                case 2:
                    removeOrderById();
                    break;
                case 3:
                    orderManager.displayAllOrders();
                    break;
                case 4:
                    orderManager.displayRevenueReport();
                    break;
                case 5:
                    orderManager.sortByOrderDate();
                    orderManager.displayAllOrders();
                    break;
                case 6:
                    orderManager.sortByCustomerName();
                    orderManager.displayAllOrders();
                    break;
                case 7:
                    orderManager.sortByTotalPrice();
                    orderManager.displayAllOrders();
                    break;
                case 8:
                    orderManager.printHistory();
                    break;
                case 9:
                    orderManager.saveDataToFile();
                    break;
                case 10:
                    orderManager.loadDataFromFile();
                    System.out.println("Data reloaded from file. Current orders:");
                    orderManager.displayAllOrders();
                    break;
                case 0:
                    orderManager.saveDataToFile(); //luu lan nua cho chac
                    System.out.println("Exiting program");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (choice != 0) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }

        } while (choice != 0);

        scanner.close();
    }


    private static void displayMenu() {
        System.out.println("\n===== Order Management System =====");
        System.out.println("1. Add New Order (Electronics / Clothing)");
        System.out.println("2. Remove Order by ID");
        System.out.println("3. Display All Orders");
        System.out.println("4. Display Revenue Report");
        System.out.println("5. Sort Orders by Order Date");
        System.out.println("6. Sort Orders by Customer Name");
        System.out.println("7. Sort Orders by Total Price");
        System.out.println("8. View Operation History");
        System.out.println("9. Save Orders to File (" + DATA_FILENAME + ")");
        System.out.println("10. Load Orders from File (" + DATA_FILENAME + ")");
        System.out.println("0. Exit");
        System.out.println("=================================");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        int choice = -1;
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
        } finally {
            scanner.nextLine();
        }
        return choice;
    }

    private static void addNewOrder() {
        System.out.println("\n--- Add New Order ---");
        System.out.println("Select order type:");
        System.out.println("  1. Electronics");
        System.out.println("  2. Clothing");
        System.out.print("Enter type (1 or 2): ");
        int typeChoice = -1;
        try {
            typeChoice = scanner.nextInt();
        } catch (InputMismatchException e) {
        } finally {
            System.out.println("Add succesful. Returning to menu.");
        }

        if (typeChoice != 1 && typeChoice != 2) {
            System.out.println("Invalid order type selected. Returning to menu.");
            return;
        }

        // --- Nhập thông tin chung ---
        String orderId = readNonEmptyString("Enter Order ID: ");
        String customerName = readNonEmptyString("Enter Customer Name: ");
        int orderDate = readOrderDate("Enter Order Date (yyyyMMdd format): ");

        // --- Nhập thông tin riêng và tạo đối tượng ---
        Order newOrder = null;
        try {
            if (typeChoice == 1) {
                double itemPrice = readDouble("Enter Item Price: ");
                int warrantyMonths = readInt("Enter Warranty Months: ");
                newOrder = new ElectronicsOrder(orderId, customerName, orderDate, itemPrice, warrantyMonths);
            } else { // Clothing
                double basePrice = readDouble("Enter Base Price: ");
                String size = readNonEmptyString("Enter Size (e.g., S, M, L, XL): ").toUpperCase();
                newOrder = new ClothingOrder(orderId, customerName, orderDate, basePrice, size);
            }
            orderManager.addOrder(newOrder);

        } catch (InputMismatchException e) {
            System.out.println("Invalid numeric input. Order creation failed.");
        } catch (Exception e) {
            System.out.println("An error occurred during order creation: " + e.getMessage());
        }
    }

    // Xóa đơn hàng theo ID
    private static void removeOrderById() {
        System.out.println("\n--- Remove Order ---");
        String orderIdToRemove = readNonEmptyString("Enter the Order ID to remove: ");
        orderManager.removeOrder(orderIdToRemove);
    }

    // --- Helper methods for input ---

    // Đọc một chuỗi không rỗng từ người dùng
    private static String readNonEmptyString(String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
            }
        } while (input.isEmpty());
        return input;
    }

    // Đọc một số nguyên dương cho ngày (định dạng yyyyMMdd)
    private static int readOrderDate(String prompt) {
        int date = 0;
        boolean valid = false;
        while (!valid) {
            System.out.print(prompt);
            try {
                date = scanner.nextInt();
                // Kiểm tra định dạng cơ bản 8 chữ số và > 0
                if (String.valueOf(date).length() == 8 && date > 0) {
                    // Có thể thêm kiểm tra ngày tháng hợp lệ phức tạp hơn nếu cần
                    valid = true;
                } else {
                    System.out.println("Invalid format. Please use yyyyMMdd (e.g., 20231027) and must be positive.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
            } finally {
                scanner.nextLine(); // Tiêu thụ newline sau nextInt() hoặc lỗi
            }
        }
        return date;
    }

    // Đọc một số double dương từ người dùng
    private static double readDouble(String prompt) {
        double value = -1;
        boolean valid = false;
        while(!valid) {
            System.out.print(prompt);
            try {
                value = scanner.nextDouble();
                if (value >= 0) {
                    valid = true;
                } else {
                    System.out.println("Value cannot be negative.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
            }finally {
                System.out.println("Done");
            }
        }
        return value;
    }

    // Đọc một số nguyên dương từ người dùng
    private static int readInt(String prompt) {
        int value = -1;
        boolean valid = false;
        while(!valid) {
            System.out.print(prompt);
            try {
                value = scanner.nextInt();
                if (value >= 0) {
                    valid = true;
                } else {
                    System.out.println("Value cannot be negative.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
            } finally {
                System.out.println("Done");
            }
        }
        return value;
    }
}