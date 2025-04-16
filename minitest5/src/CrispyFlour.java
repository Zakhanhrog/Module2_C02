import java.time.LocalDate;
import java.time.Period; // Thêm import Period

class CrispyFlour extends Material implements Discount {
    private int quantity;

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        return quantity * getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusYears(1);
    }

    @Override
    public double getRealMoney() {
        LocalDate today = LocalDate.now();
        LocalDate expiryDate = getExpiryDate();
        double originalAmount = getAmount();
        double discountRate = 0.05;

        // Tính số tháng còn lại sử dụng Period
        // Period.between tính khoảng thời gian theo năm, tháng, ngày.
        // toTotalMonths() trả về tổng số tháng trong khoảng thời gian đó.
        // Thêm điều kiện today.isBefore(expiryDate) để tránh lỗi nếu đã hết hạn
        long monthsToExpiry = 0;
        if (today.isBefore(expiryDate)) {
            monthsToExpiry = Period.between(today, expiryDate).toTotalMonths();
        } else {
            monthsToExpiry = -1;
        }


        // Logic chiết khấu giữ nguyên
        if (monthsToExpiry >= 0 && monthsToExpiry <= 2) { // <= 2 tháng (0, 1, 2)
            discountRate = 0.40;
        } else if (monthsToExpiry > 2 && monthsToExpiry <= 4) { // <= 4 tháng (3, 4)
            discountRate = 0.20;
        }
        // Nếu monthsToExpiry < 0 (đã hết hạn) hoặc > 4, giữ nguyên 5%

        double discountedAmount = originalAmount * (1 - discountRate);
        return discountedAmount;
    }

    @Override
    public String toString() {
        return "CrispyFlour{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", manufacturingDate=" + getManufacturingDate() +
                ", cost=" + getCost() +
                ", quantity=" + quantity +
                ", expiryDate=" + getExpiryDate() +
                '}';
    }
}