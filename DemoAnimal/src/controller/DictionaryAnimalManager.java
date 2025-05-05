package controller;

import model.Animal;
import storage.AnimalStorage;
import java.util.ArrayList;

public class DictionaryAnimalManager {
    static ArrayList<Animal> animals = AnimalStorage.getAnimals();

    public static void addAnimal(Animal a) {
        animals.add(a);
        AnimalStorage.writeAnimal(animals);
    }

    public static void removeAnimal(Animal animal) {
        animals.remove(animal);
        AnimalStorage.writeAnimal(animals);
    }
    public static void displayAllAnimal(ArrayList<Animal> animals){
        for (Animal animal : animals){
            System.out.println(animal);
        }
    }
    public static void priceAllAnimal(){
        for (Animal animal : animals){
            System.out.println(animal.getPrice());
        }
    }
}
