package Model;

import java.io.Serializable;
import java.util.Objects;


public abstract class Order implements Payable, Comparable<Order>, Serializable {
    private static final long serialVersionUID = 1L;

    protected String orderId;
    protected String customerName;
    protected int orderDate;

    public Order(String orderId, String customerName, int orderDate) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = orderDate;
    }

    // Getters
    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getOrderDate() {
        return orderDate;
    }

    // Phương thức trừu tượng, lớp con phải cài đặt
    public abstract void displayInfo();

    // Phương thức từ Payable, lớp con phải cài đặt
    @Override
    public abstract double calculateTotalPrice();

    // Cài đặt Comparable: Sắp xếp theo ngày tăng dần
    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.orderDate, other.orderDate);
    }

    // Cài đặt equals và hashCode dựa trên orderId (giả sử là duy nhất)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    // toString cơ bản cho việc debug hoặc ghi log đơn giản
    @Override
    public String toString() {
        return "Order [ID=" + orderId + ", Customer=" + customerName + ", Date=" + orderDate + "]";
    }
}