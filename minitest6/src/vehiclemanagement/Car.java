package vehiclemanagement;

public class Car extends Vehicle {

    private static final double TAX_PER_SEAT = 300.0;

    private int numberOfSeats;

    public Car(String id, String brand, int year, int numberOfSeats) {
        super(id, brand, year);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    @Override
    public double calculateTax() {
        return this.numberOfSeats * TAX_PER_SEAT;
    }

    @Override
    public void displayInfo() {
        System.out.printf("Car       [ID=%s, Brand=%s, Year=%d, Seats=%d, Tax=%.2f]%n",
                getId(), getBrand(), getYear(), getNumberOfSeats(), calculateTax());
    }

    @Override
    public String toString() {
        return String.format("Car [%s, Seats=%d]", super.toString(), getNumberOfSeats());
    }
}