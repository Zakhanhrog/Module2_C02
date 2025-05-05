package storage;

import model.Animal;
import java.io.*;
import java.util.ArrayList;

public class AnimalStorage {
    private static final String FILE_NAME_ANIMAL = "/Users/ngogiakhanh/Documents/Module 2/DemoAnimal/src/storage/storage_animail.txt";

    public static ArrayList<Animal> getAnimals() {
        ArrayList<Animal> loadedAnimals = new ArrayList<>();
        File file = new File(FILE_NAME_ANIMAL);

        if (!file.exists() || file.length() == 0) {
            System.out.println("Data file not found or is empty. Starting with an empty list.");
            return loadedAnimals;
        }

        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            Object readObject = ois.readObject();
            if (readObject instanceof ArrayList<?>) {
                loadedAnimals = (ArrayList<Animal>) readObject;
                System.out.println("Successfully loaded " + loadedAnimals.size() + " animals from file.");
            } else {
                System.err.println("Error: File does not contain a valid ArrayList of Animals.");
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error: File disappeared unexpectedly: " + e.getMessage());
        } catch (EOFException e) {
            System.err.println("Error: Reached end of file unexpectedly, file might be corrupted: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading animal data file (IOException): " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Class definition mismatch between saved data and current code: " + e.getMessage());
        } catch (ClassCastException e) {
            System.err.println("Error: Data in file is not an ArrayList of Animals: " + e.getMessage());
        }

        return loadedAnimals;
    }


    public static void writeAnimal(ArrayList<Animal> animalsToWrite) {
        File file = new File(FILE_NAME_ANIMAL);
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(animalsToWrite);
            System.out.println("Successfully wrote " + animalsToWrite.size() + " animals to file.");

        } catch (FileNotFoundException e) {
            System.err.println("Error: Cannot find or create file for writing: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error writing animal data to file (IOException): " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArrayList<Animal> testRead = getAnimals();
        System.out.println("Animals read from file:");
        System.out.println(testRead);

        ArrayList<Animal> testWrite = new ArrayList<>();
        testWrite.add(new model.TwoLegAnimal("TestChicken", 2, 5));
        writeAnimal(testWrite);
    }
}