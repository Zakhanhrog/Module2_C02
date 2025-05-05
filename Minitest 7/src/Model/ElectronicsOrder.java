package Model;
import java.text.NumberFormat;
import java.util.Locale;

    public class ElectronicsOrder extends Order {
        private static final long serialVersionUID = 1L;

        private double itemPrice;
        private int warrantyMonths;

        public ElectronicsOrder(String orderId, String customerName, int orderDate, double itemPrice, int warrantyMonths) {
            super(orderId, customerName, orderDate);
            this.itemPrice = itemPrice;
            this.warrantyMonths = warrantyMonths;
        }

        public double getItemPrice() {
            return itemPrice;
        }

        public int getWarrantyMonths() {
            return warrantyMonths;
        }

        @Override
        public double calculateTotalPrice() {
            return this.itemPrice + (this.warrantyMonths * 50.0);
        }

        @Override
        public void displayInfo() {
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
            System.out.println("--- Electronics Order ---");
            System.out.println("Order ID: " + getOrderId());
            System.out.println("Customer Name: " + getCustomerName());
            System.out.println("Order Date (yyyyMMdd): " + getOrderDate());
            System.out.println("Item Price: " + currencyFormatter.format(itemPrice));
            System.out.println("Warranty Months: " + warrantyMonths);
            System.out.println("Total Price: " + currencyFormatter.format(calculateTotalPrice()));
            System.out.println("------------------------");
        }

        @Override
        public String toString() {
            return "ElectronicsOrder " +
                    "\t orderId: " + orderId +
                    ", customerName: " + customerName  +
                    ", orderDate: " + orderDate +
                    ", itemPrice: " + itemPrice +
                    ", warrantyMonths: " + warrantyMonths;
        }
    }

