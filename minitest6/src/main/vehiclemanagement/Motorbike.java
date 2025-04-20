package main.vehiclemanagement;
public class Motorbike extends Vehicle {
    private int enginePower;

    public Motorbike(String id, String brand, int year, int enginePower) {
        super(id, brand, year);
        this.enginePower = enginePower;
    }

    public int getEnginePower() {
        return enginePower;
    }
    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    @Override
    public double calculateTax() {
        if (this.enginePower < 100) {
            return 500.0;
        } else {
            return 1000.0;
        }
    }


    @Override
    public void displayInfo() {
        System.out.println("Motorbike [ID=" + getId() + ", Brand=" + getBrand() + ", Year=" + getYear() +
                ", Engine Power=" + enginePower + " CC, Tax=" + String.format("%.2f", calculateTax()) + "]");
    }

    @Override
    public String toString() {
        return "Motorbike [" + super.toString() + ", Engine Power=" + enginePower + "]";
    }
}