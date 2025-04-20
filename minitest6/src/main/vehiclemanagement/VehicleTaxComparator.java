package main.vehiclemanagement;

import java.util.Comparator;

public class VehicleTaxComparator implements Comparator<Vehicle> {
    @Override
    public int compare(Vehicle v1, Vehicle v2) {
        double tax1 = v1.calculateTax();
        double tax2 = v2.calculateTax();
        return Double.compare(tax1, tax2);
    }
}