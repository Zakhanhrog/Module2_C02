package view;

import controller.DictionaryAnimalManager;
import model.Animal;
import model.TwoLegAnimal;
import storage.AnimalStorage;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        addAnimal();
        displayAllAnimal();
        priceAllAnimal();

    }
    public static void displayAllAnimal(){
        DictionaryAnimalManager.displayAllAnimal(AnimalStorage.getAnimals());
    }
    public static void priceAllAnimal(){
        DictionaryAnimalManager.priceAllAnimal();
    }
    private static void addAnimal(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of animal: ");
        String name = scanner.nextLine();
        System.out.println("Enter longevity of animal: ");
        int longevity = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter number of eggs: ");
        int numberOfEggs = Integer.parseInt(scanner.nextLine());
        Animal twoLegAnimal = new TwoLegAnimal(name, longevity, numberOfEggs);
        DictionaryAnimalManager.addAnimal(twoLegAnimal);
        scanner.close();
    }
}