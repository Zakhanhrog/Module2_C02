import java.time.LocalDate;

class MaterialManager {
    private Material[] materials;
    private int count;

    public MaterialManager(int maxSize) {
        materials = new Material[maxSize];
        count = 0;
    }

    public void addMaterial(Material material) {
        if (count < materials.length) {
            materials[count] = material;
            count++;
        } else {
            System.out.println("Lỗi: Không thể thêm vật liệu, danh sách đã đầy.");
        }
    }

    public void editMaterial(String id, Material updatedMaterial) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (materials[i] != null && materials[i].getId().equals(id)) {
                System.out.println("Đang cập nhật vật liệu có ID: " + id);
                materials[i] = updatedMaterial;
                found = true;
                System.out.println("Đã cập nhật thành công.");
                break;
            }
        }
        if (!found) {
            System.out.println("Lỗi: Không tìm thấy vật liệu với ID: " + id + " để sửa.");
        }
    }

    public void deleteMaterial(String id) {
        int foundIndex = -1;
        for (int i = 0; i < count; i++) {
            if (materials[i] != null && materials[i].getId().equals(id)) {
                System.out.println("Đang xóa vật liệu có ID: " + id + " (" + materials[i].getName() + ")");
                foundIndex = i;
                break;
            }
        }

        if (foundIndex != -1) {
            for (int i = foundIndex; i < count - 1; i++) {
                materials[i] = materials[i + 1];
            }
            materials[count - 1] = null;
            count--;
            System.out.println("Đã xóa thành công.");
        } else {
            System.out.println("Lỗi: Không tìm thấy vật liệu với ID: " + id + " để xóa.");
        }
    }

    public void displayAllMaterials() {
        System.out.println("\n--- Danh sách vật liệu hiện tại (" + count + " mục) ---");
        if (count == 0) {
            System.out.println("Danh sách trống.");
            return;
        }
        for (int i = 0; i < count; i++) {
            if (materials[i] != null) {
                System.out.println((i + 1) + ". " + materials[i].toString());
                if (materials[i] instanceof Discount) {
                    Discount itemDiscount = (Discount) materials[i];
                    System.out.println("   Giá gốc: " + materials[i].getAmount() + ", Giá sau chiết khấu: " + itemDiscount.getRealMoney());
                }
            }
        }
        System.out.println("----------------------------------------");
    }

    public double calculateTotalAmount() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            if (materials[i] != null) {
                total += materials[i].getAmount();
            }
        }
        return total;
    }

    public double calculateTotalRealMoney() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            if (materials[i] != null) {
                if (materials[i] instanceof Discount) {
                    Discount discountItem = (Discount) materials[i];
                    total += discountItem.getRealMoney();
                } else {
                    total += materials[i].getAmount();
                }
            }
        }
        return total;
    }

    public double calculateDifference() {
        double totalAmount = calculateTotalAmount();
        double totalRealMoney = calculateTotalRealMoney();
        return totalAmount - totalRealMoney;
    }
}