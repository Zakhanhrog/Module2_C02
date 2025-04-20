package vehiclemanagement;

public abstract class Vehicle implements Taxable, Comparable<Vehicle> {
    private String id;
    private String brand;
    private int year;

    public Vehicle(String id, String brand, int year) {
        this.id = id;
        this.brand = brand;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public abstract void displayInfo();

    @Override
    public int compareTo(Vehicle other) {
        return Integer.compare(this.year, other.year);
    }

    @Override
    public String toString() {
        return String.format("ID=%s, Brand=%s, Year=%d", getId(), getBrand(), getYear());
    }
}