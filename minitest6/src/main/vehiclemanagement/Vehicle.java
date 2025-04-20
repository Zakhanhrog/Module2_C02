package main.vehiclemanagement;

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

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    abstract void displayInfo();

    @Override
    public int compareTo(Vehicle o) {
        return Integer.compare(this.year, o.year);
    }

    @Override
    public String toString() {
        return "Vehicle: " +
                "id=" + id +
                ", name= '" + brand + '\'' +
                ", year= " + year;
    }
}
