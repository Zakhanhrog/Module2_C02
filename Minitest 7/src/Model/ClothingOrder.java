package Model;
import java.text.NumberFormat;
import java.util.Locale;


    public class ClothingOrder extends Order {
        private static final long serialVersionUID = 1L;

        private double basePrice;
        private String size;

        public ClothingOrder(String orderId, String customerName, int orderDate, double basePrice, String size) {
            super(orderId, customerName, orderDate);
            this.basePrice = basePrice;
            this.size = size;
        }

        public double getBasePrice() {
            return basePrice;
        }

        public String getSize() {
            return size;
        }

        @Override
        public double calculateTotalPrice() {
            if (size != null && (size.equalsIgnoreCase("L") || size.equalsIgnoreCase("XL"))) {
                return this.basePrice * 1.10;
            } else {
                return this.basePrice;
            }
        }

        @Override
        public void displayInfo() {
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
            System.out.println("--- Clothing Order ---");
            System.out.println("Order ID: " + getOrderId());
            System.out.println("Customer Name: " + getCustomerName());
            System.out.println("Order Date (yyyyMMdd): " + getOrderDate());
            System.out.println("Base Price: " + currencyFormatter.format(basePrice));
            System.out.println("Size: " + size);
            System.out.println("Total Price: " + currencyFormatter.format(calculateTotalPrice()));
            System.out.println("----------------------");
        }

        @Override
        public String toString() {
            return "ClothingOrder \t " +
                    " orderId: " + orderId +
                    ", customerName: " + customerName +
                    ", orderDate: " + orderDate +
                    ", basePrice: " + basePrice +
                    ", size: " + size;
        }

    }

