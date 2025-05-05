package model;

public class TwoLegAnimal extends Animal {
    private int numberOfEgg;

    public TwoLegAnimal() {
    }

    public TwoLegAnimal(String name, int longevity, int numberOfEgg) {
        super(name, longevity);
        this.numberOfEgg = numberOfEgg;
    }

    public int getNumberOfEgg() {
        return numberOfEgg;
    }

    public void setNumberOfEgg(int numberOfEgg) {
        this.numberOfEgg = numberOfEgg;
    }

    @Override
    void displayInfo() {
        System.out.println("Name: " + getName() + "\nLongevity: " + getLongevity() + "\nNumber of eggs: " + getNumberOfEgg());
    }


    @Override
    public double getPrice() {
        return numberOfEgg * 900;
    }


}
