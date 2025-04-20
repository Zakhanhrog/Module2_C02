package main.vehiclemanagement;

public class Car extends Vehicle {
    private int numberOfSeats;

    public Car(String id, String brand, int year, int numberOfSeats) {
        super(id, brand, year);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public double calculateTax() {
        return this.numberOfSeats * 300.0;
    }

    @Override
    public void displayInfo() {
        System.out.println("Car [ID=" + getId() + ", Brand=" + getBrand() + ", Year=" + getYear() +
                ", Seats=" + numberOfSeats + ", Tax=" + String.format("%.2f", calculateTax()) + "]");
    }

    @Override
    public String toString() {
        return "Car [" + super.toString() + ", Seats=" + numberOfSeats + "]";
    }

}
