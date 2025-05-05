package model;

public class FourLegAnimal extends Animal {
    private int numberOfChilden;

    public FourLegAnimal() {
    }

    public FourLegAnimal(String name, int longevity, int numberOfChilden) {
        super(name, longevity);
        this.numberOfChilden = numberOfChilden;
    }

    public int getNumberOfChilden() {
        return numberOfChilden;
    }

    public void setNumberOfChilden(int numberOfChilden) {
        this.numberOfChilden = numberOfChilden;
    }

    @Override
    void displayInfo() {
        System.out.println("Name: " + getName() + "\nLongevity: " + getLongevity() + "\nNumber of children: " + getNumberOfChilden());
    }

    @Override
    public double getPrice() {
        return numberOfChilden * 1200;
    }
}
