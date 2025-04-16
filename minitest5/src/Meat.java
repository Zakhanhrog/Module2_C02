import java.time.LocalDate;


class Meat extends Material implements Discount {
    private double weight;

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        return weight * getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusDays(7);
    }

    @Override
    public double getRealMoney() {
        LocalDate today = LocalDate.now();
        LocalDate expiryDate = getExpiryDate();
        double originalAmount = getAmount();
        double discountRate = 0.10;


        long daysToExpiry = expiryDate.toEpochDay() - today.toEpochDay();


        if (daysToExpiry <= 5) {
            discountRate = 0.30;
        }

        double discountedAmount = originalAmount * (1 - discountRate);
        return discountedAmount;
    }

    @Override
    public String toString() {
        return "Meat{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", manufacturingDate=" + getManufacturingDate() +
                ", cost=" + getCost() +
                ", weight=" + weight +
                ", expiryDate=" + getExpiryDate() +
                '}';
    }
}