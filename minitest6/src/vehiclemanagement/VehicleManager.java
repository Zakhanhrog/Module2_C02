package vehiclemanagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class VehicleManager {
    private final List<Vehicle> vehicles;
    private final List<String> history;

    public VehicleManager() {
        vehicles = new ArrayList<>();
        history = new LinkedList<>();
    }

    private void logAction(String action) {
        history.add("[INFO] " + action);
    }

    private boolean isIdExists(String id) {
        if (id == null || id.trim().isEmpty()) {
            return false;
        }
        String lowerCaseId = id.toLowerCase();
        for (Vehicle existingVehicle : vehicles) {
            if (existingVehicle.getId().toLowerCase().equals(lowerCaseId)) {
                return true;
            }
        }
        return false;
    }

    private int findVehicleIndexById(String id) {
        if (id == null || id.trim().isEmpty()) {
            return -1;
        }
        String lowerCaseId = id.toLowerCase();
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getId().toLowerCase().equals(lowerCaseId)) {
                return i;
            }
        }
        return -1;
    }

    public void addVehicle(Vehicle vehicleToAdd) {
        if (vehicleToAdd == null) {
            System.out.println("Error: Cannot add a null vehicle.");
            logAction("Attempted to add a null vehicle.");
            return;
        }

        String id = vehicleToAdd.getId();
        if (isIdExists(id)) {
            System.out.println("Error: Vehicle with ID '" + id + "' already exists. Cannot add.");
            logAction("Attempted to add duplicate vehicle ID: " + id);
        } else {
            vehicles.add(vehicleToAdd);
            System.out.println("Vehicle added successfully: " + vehicleToAdd.getClass().getSimpleName() + " (ID: " + id + ")");
            logAction("Added vehicle: " + vehicleToAdd.toString());
        }
    }

    public void removeVehicle(String idToRemove) {
        int index = findVehicleIndexById(idToRemove);

        if (index != -1) {
            Vehicle removedVehicle = vehicles.remove(index);
            System.out.println("Vehicle removed successfully: " + removedVehicle.getClass().getSimpleName() + " (ID: " + removedVehicle.getId() + ")");
            logAction("Removed vehicle: " + removedVehicle.toString());
        } else {
            System.out.println("Error: Vehicle with ID '" + idToRemove + "' not found.");
            logAction("Attempted to remove non-existent vehicle ID: " + idToRemove);
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
        if (handleEmptyListForSort("year")) return;
        Collections.sort(vehicles);
        logAction("Sorted vehicles by year (ascending)");
        System.out.println("Vehicles sorted by year.");
    }

    public void sortByBrand() {
        if (handleEmptyListForSort("brand")) return;
        Collections.sort(vehicles, new VehicleBrandComparator());
        logAction("Sorted vehicles by brand (alphabetical)");
        System.out.println("Vehicles sorted by brand.");
    }

    public void sortByTax() {
        if (handleEmptyListForSort("tax")) return;
        Collections.sort(vehicles, new VehicleTaxComparator());
        logAction("Sorted vehicles by tax (ascending)");
        System.out.println("Vehicles sorted by tax amount.");
    }

    private boolean handleEmptyListForSort(String criteria) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles to sort.");
            logAction("Attempted to sort by " + criteria + " (list empty)");
            return true;
        }
        return false;
    }

    public void printHistory() {
        logAction("Viewed action history");
        System.out.println("\n--- Action History ---");
        if (history.isEmpty()) {
            System.out.println("No actions recorded yet.");
        } else {
            for (String logEntry : history) {
                System.out.println(logEntry);
            }
        }
        System.out.println("----------------------");
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public List<String> getHistory() {
        return history;
    }
}