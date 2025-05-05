package Controller;

import Model.Order;
import Storage.OrderStorage;
import java.io.IOException;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Iterator;


public class OrderManager {
    private ArrayList<Order> orders;
    private LinkedList<String> history;
    private OrderStorage storage;
    private static final DateTimeFormatter HISTORY_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public OrderManager() {
        history = new LinkedList<>();
        storage = new OrderStorage();
        loadDataFromFile();
        logHistory("Order Manager Initialized. Data loaded.");
    }

    private void logHistory(String action) {
        String timestamp = LocalDateTime.now().format(HISTORY_FORMATTER);
        history.add(timestamp + " - " + action);
    }


    public void addOrder(Order o) {
        if (o != null) {
            boolean exists = false;
            for (Order existingOrder : orders) {
                if (existingOrder.getOrderId().equalsIgnoreCase(o.getOrderId())) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                orders.add(o);
                logHistory("Added order: ID=" + o.getOrderId() + ", Type=" + o.getClass().getSimpleName());
                System.out.println("Order added successfully.");
                saveDataToFile();
            } else {
                System.out.println("Error: Order with ID '" + o.getOrderId() + "' already exists.");
                logHistory("Attempted to add duplicate order ID: " + o.getOrderId());
            }
        } else {
            System.out.println("Error: Cannot add a null order.");
            logHistory("Attempted to add a null order.");
        }
    }

    public void removeOrder(String orderId) {
        boolean removed = false;
        if (orderId == null || orderId.trim().isEmpty()) {
            System.out.println("Error: Order ID cannot be empty.");
            logHistory("Attempted to remove order with empty ID.");
            return;
        }

        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            if (order.getOrderId().equalsIgnoreCase(orderId)) {
                iterator.remove();
                removed = true;
                logHistory("Removed order: ID=" + orderId);
                System.out.println("Order with ID '" + orderId + "' removed successfully.");
                saveDataToFile();
                break;
            }
        }

        if (!removed) {
            System.out.println("Order with ID '" + orderId + "' not found.");
            logHistory("Attempted to remove non-existent order: ID=" + orderId);
        }
    }

    public void displayAllOrders() {
        if (orders == null || orders.isEmpty()) {
            System.out.println("No orders to display.");
            return;
        }
        System.out.println("\n===== All Orders (" + orders.size() + ") =====");
        for (Order order : orders) {
            order.displayInfo();
        }
        System.out.println("==========================");
        logHistory("Displayed all orders.");
    }

    public void displayRevenueReport() {
        if (orders == null || orders.isEmpty()) {
            System.out.println("No orders available for revenue report.");
            return;
        }
        System.out.println("\n===== Revenue Report =====");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        double totalRevenue = 0;
        for (Order order : orders) {
            double orderTotal = order.calculateTotalPrice();
            System.out.println("Order ID: " + order.getOrderId() + " - Total Price: " + currencyFormatter.format(orderTotal));
            totalRevenue += orderTotal;
        }
        System.out.println("--------------------------");
        System.out.println("Total Revenue from all orders: " + currencyFormatter.format(totalRevenue));
        System.out.println("==========================");
        logHistory("Displayed revenue report.");
    }

    public void sortByOrderDate() {
        if (orders != null && orders.size() > 1) {
            Collections.sort(orders); // Sử dụng compareTo của Order
            logHistory("Sorted orders by Order Date (Ascending).");
            System.out.println("Orders sorted by date.");
        } else {
            System.out.println("Not enough orders to sort or list is empty.");
        }
    }

    public void sortByCustomerName() {
        if (orders != null && orders.size() > 1) {
            orders.sort(new CustomerNameComparator());
            logHistory("Sorted orders by Customer Name (Alphabetical).");
            System.out.println("Orders sorted by customer name.");
        } else {
            System.out.println("Not enough orders to sort or list is empty.");
        }
    }

    public void sortByTotalPrice() {
        if (orders != null && orders.size() > 1) {
            orders.sort(new TotalPriceComparator());
            logHistory("Sorted orders by Total Price (Ascending).");
            System.out.println("Orders sorted by total price.");
        } else {
            System.out.println("Not enough orders to sort or list is empty.");
        }
    }

    public void printHistory() {
        System.out.println("\n===== Operation History =====");
        if (history.isEmpty()) {
            System.out.println("No history recorded yet.");
        } else {
            for (String entry : history) {
                System.out.println(entry);
            }
        }
        System.out.println("===========================");
    }

    public void loadDataFromFile() {
        try {
            this.orders = storage.loadOrders();
            logHistory("Attempted to load data from file.");
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            System.err.println("Error loading data from file: " + e.getMessage());
            logHistory("Failed to load data from file. Error: " + e.getMessage());
            if (this.orders == null) {
                this.orders = new ArrayList<>();
                System.out.println("Initialized with an empty order list due to loading error.");
            }
        }
    }

    public void saveDataToFile() {
        storage.saveOrders(this.orders);
        logHistory("Attempted to save data to file.");

    }
}