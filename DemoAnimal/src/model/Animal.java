package model;

import java.io.Serializable;

public abstract class Animal implements Comparable<Animal>, Price, Serializable {
    private String name;
    private int longevity;

    public Animal() {
    }

    public Animal(String name, int longevity) {
        this.name = name;
        this.longevity = longevity;
    }

    public int getLongevity() {
        return longevity;
    }

    public void setLongevity(int longevity) {
        this.longevity = longevity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", longevity=" + longevity +
                '}';
    }

    @Override
    public int compareTo(Animal o) {
        return 0;
    }

    @Override
    public double getPrice() {
        return 0;
    }
    abstract void displayInfo();
}
