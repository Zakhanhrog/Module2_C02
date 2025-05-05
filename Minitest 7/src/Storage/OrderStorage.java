package Storage;

import Model.Order;
import java.io.*;
import java.util.ArrayList;

public class OrderStorage {

    private static final String DEFAULT_FILENAME = "/Users/ngogiakhanh/Documents/Module 2/Minitest 7/src/Storage/order.dat";
    public void saveOrders(ArrayList<Order> ordersToSave) {
        try {
            File file = new File(DEFAULT_FILENAME);
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ordersToSave);
            System.out.println("Data successfully saved to " + DEFAULT_FILENAME);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Order> loadOrders() throws IOException, ClassNotFoundException {
        File file = new File(DEFAULT_FILENAME);
        if (!file.exists() || file.length() == 0) {
            System.out.println(">> Data file '" + DEFAULT_FILENAME + "' not found or empty. Starting with empty list.");
            return new ArrayList<>();
        }

        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            if (obj instanceof ArrayList) {
                System.out.println(">> Data successfully loaded from " + DEFAULT_FILENAME);
                return (ArrayList<Order>) obj;
            } else {
                System.err.println("Error: File '" + DEFAULT_FILENAME + "' contains invalid data format.");
                return new ArrayList<>();// danh sach rong
            }
        } catch (EOFException e) {
            System.out.println(">> Data file '" + DEFAULT_FILENAME + "' is empty. Starting with empty list.");
            return new ArrayList<>();
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found during read (should not happen here): " + e.getMessage());
            return new ArrayList<>();
        }
    }
}