package main.vehiclemanagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class VehicleManager {
    private List<Vehicle> vehicles;
    private List<String> history;

    public VehicleManager() {
        vehicles = new ArrayList<>();
        history = new LinkedList<>();
    }

    private void logAction(String action) {
        history.add(action);
    }

    public void addVehicle(Vehicle v) {
        for (Vehicle existingVehicle : vehicles) {
            if (existingVehicle.getId().equalsIgnoreCase(v.getId())) {
                System.out.println("Error: Vehicle with ID '" + v.getId() + "' already exists. Cannot add.");
                logAction("Attempted to add duplicate vehicle ID: " + v.getId());
                return;
            }
        }
        vehicles.add(v);
        System.out.println("Vehicle added successfully: " + v.getClass().getSimpleName() + " (ID: " + v.getId() + ")");
        logAction("Added vehicle: " + v.toString());
    }

    public void removeVehicle(String id) {
        int indexToRemove = -1;
        for (int i = 0; i < vehicles.size(); i++) {
            // Sử dụng getter getId()
            if (vehicles.get(i).getId().equalsIgnoreCase(id)) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            Vehicle removedVehicle = vehicles.remove(indexToRemove);
            System.out.println("Vehicle removed successfully: " + removedVehicle.getClass().getSimpleName() + " (ID: " + removedVehicle.getId() + ")");
            logAction("Removed vehicle: " + removedVehicle.toString());
        } else {
            System.out.println("Error: Vehicle with ID '" + id + "' not found.");
            logAction("Attempted to remove non-existent vehicle ID: " + id);
        }
    }

    public void displayAllVehicles() {
        logAction("Displayed all vehicles");
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the list.");
            return;
        }
        System.out.println("\n--- List of Vehicles ---");
        for (Vehicle v : vehicles) {
            v.displayInfo();
        }
        System.out.println("------------------------");
    }

    public void displayTaxReport() {
        logAction("Displayed tax report");
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles to report tax for.");
            return;
        }
        System.out.println("\n--- Tax Report ---");
        System.out.printf("%-15s | %-15s%n", "Vehicle ID", "Tax Amount");
        System.out.println("---------------------------------");
        for (Vehicle v : vehicles) {
            System.out.printf("%-15s | %-15.2f%n", v.getId(), v.calculateTax());
        }
        System.out.println("---------------------------------");
    }

    public void sortByYear() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles to sort.");
            logAction("Attempted to sort by year (list empty)");
            return;
        }
        Collections.sort(vehicles); // Sử dụng compareTo() (đã được cập nhật để dùng getter nếu cần)
        logAction("Sorted vehicles by year (ascending)");
        System.out.println("Vehicles sorted by year.");
    }

    public void sortByBrand() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles to sort.");
            logAction("Attempted to sort by brand (list empty)");
            return;
        }
        Collections.sort(vehicles, new VehicleBrandComparator()); // Comparator dùng getter
        logAction("Sorted vehicles by brand (alphabetical)");
        System.out.println("Vehicles sorted by brand.");
    }

    public void sortByTax() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles to sort.");
            logAction("Attempted to sort by tax (list empty)");
            return;
        }
        Collections.sort(vehicles, new VehicleTaxComparator()); // Comparator dùng calculateTax()
        logAction("Sorted vehicles by tax (ascending)");
        System.out.println("Vehicles sorted by tax amount.");
    }

    public void printHistory() {
        logAction("Viewed action history");
        if (history.isEmpty()) {
            System.out.println("\n--- Action History ---");
            System.out.println("No actions recorded yet.");
            System.out.println("----------------------");
            return;
        }
        System.out.println("\n--- Action History ---");
        for (String logEntry : history) {
            System.out.println(logEntry);
        }
        System.out.println("----------------------");
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
    // cai nay de lam test

    public List<String> getHistory() {
        return history;
    }
}