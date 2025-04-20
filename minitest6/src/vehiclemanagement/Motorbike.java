package vehiclemanagement;

public class Motorbike extends Vehicle {

    private static final int ENGINE_POWER_THRESHOLD = 100;
    private static final double TAX_BELOW_THRESHOLD = 500.0;
    private static final double TAX_ABOVE_THRESHOLD = 1000.0;

    private int enginePower;

    public Motorbike(String id, String brand, int year, int enginePower) {
        super(id, brand, year);
        this.enginePower = enginePower;
    }

    public int getEnginePower() {
        return enginePower;
    }

    @Override
    public double calculateTax() {
        if (this.enginePower < ENGINE_POWER_THRESHOLD) {
            return TAX_BELOW_THRESHOLD;
        } else {
            return TAX_ABOVE_THRESHOLD;
        }
    }

    @Override
    public void displayInfo() {
        System.out.printf("Motorbike [ID=%s, Brand=%s, Year=%d, Engine Power=%d CC, Tax=%.2f]%n",
                getId(), getBrand(), getYear(), getEnginePower(), calculateTax());
    }

    @Override
    public String toString() {
        return String.format("Motorbike [%s, Engine Power=%d]", super.toString(), getEnginePower());
    }
}