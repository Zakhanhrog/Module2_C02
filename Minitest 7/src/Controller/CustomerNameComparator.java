package Controller;
import Model.Order;
import java.util.Comparator;

class CustomerNameComparator implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {
        return o1.getCustomerName().compareToIgnoreCase(o2.getCustomerName());
    }
}
