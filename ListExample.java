// 1. Định nghĩa "Món ăn/uống" (Node) trong bữa ăn
class MonAnNode {
    String tenMon;      // Tên món (ví dụ: "Trứng", "Sữa", "Bánh mì")
    MonAnNode monKeTiep; // Liên kết chỉ đến món KẾ TIẾP trong bữa ăn

    // Hàm tạo một món mới
    MonAnNode(String tenMon) {
        this.tenMon = tenMon;
        this.monKeTiep = null; // Ban đầu chưa biết món kế tiếp là gì
    }

    // --- Phương thức đặc trưng: "Uống gì tiếp theo?" ---
    // Giả định: Sau món hiện tại thì sẽ uống món kế tiếp
    // Thực chất: Chỉ đơn giản là trả về cái node được liên kết ngay sau node này
    public MonAnNode uongGi() {
        System.out.println("Từ [" + this.tenMon + "], xem thử nên uống gì tiếp theo...");
        if (this.monKeTiep != null) {
            System.out.println("-> À, có thể uống [" + this.monKeTiep.tenMon + "]");
        } else {
            System.out.println("-> Hết món để uống rồi.");
        }
        return this.monKeTiep; // Trả về tham chiếu đến món kế tiếp
    }

    // --- Phương thức đặc trưng: "Ăn gì tiếp theo?" ---
    // Giả định: Sau món hiện tại thì sẽ ăn món kế tiếp
    // Thực chất: Cũng chỉ là trả về node được liên kết ngay sau node này
    public MonAnNode anGi() {
        System.out.println("Từ [" + this.tenMon + "], xem thử nên ăn gì tiếp theo...");
        if (this.monKeTiep != null) {
            System.out.println("-> À, có thể ăn [" + this.monKeTiep.tenMon + "]");
        } else {
            System.out.println("-> Hết món để ăn rồi.");
        }
        return this.monKeTiep; // Trả về tham chiếu đến món kế tiếp
    }
}

// 2. Định nghĩa "Trình tự Bữa ăn" (LinkedList)
class BuaAnLinkedList {
    MonAnNode monDauTien; // Chỉ cần biết món đầu tiên là gì

    public BuaAnLinkedList() {
        this.monDauTien = null;
    }

    // Thêm món vào cuối bữa ăn (để thiết lập trình tự)
    public void themMon(String tenMon) {
        MonAnNode monMoi = new MonAnNode(tenMon);
        if (monDauTien == null) {
            monDauTien = monMoi;
        } else {
            MonAnNode current = monDauTien;
            while (current.monKeTiep != null) {
                current = current.monKeTiep;
            }
            current.monKeTiep = monMoi; // Liên kết món cuối cùng với món mới
        }
        System.out.println("Đã thêm [" + tenMon + "] vào thực đơn.");
    }

    // In ra trình tự bữa ăn
    public void inTrinhTu() {
        System.out.print("Trình tự bữa ăn: ");
        MonAnNode current = monDauTien;
        while (current != null) {
            System.out.print("[" + current.tenMon + "] -> ");
            current = current.monKeTiep; // Đi tiếp theo liên kết
        }
        System.out.println("Hết.");
    }
}

// 3. Chạy thử ví dụ Bữa ăn
public class ListExample {
    public static void main(String[] args) {
        // Tạo trình tự bữa ăn
        BuaAnLinkedList buaAn = new BuaAnLinkedList();
        buaAn.themMon("Trứng"); // Món đầu tiên
        buaAn.themMon("Sữa");   // Món thứ hai
        buaAn.themMon("Bánh mì"); // Món thứ ba

        buaAn.inTrinhTu();
        System.out.println("---------------------------");

        // Bắt đầu bữa ăn từ món đầu tiên
        MonAnNode monHienTai = buaAn.monDauTien;

        if (monHienTai != null && monHienTai.tenMon.equals("Trứng")) {
            System.out.println("Đang ở món: [" + monHienTai.tenMon + "]");

            // Từ "Trứng", dùng phương thức "uống gì" để chuyển sang món tiếp theo
            // ==> Đây chính là việc đi theo tham chiếu/liên kết đến node "Sữa"
            MonAnNode monTiepTheo = monHienTai.uongGi(); // monTiepTheo bây giờ là Node "Sữa"

            if (monTiepTheo != null && monTiepTheo.tenMon.equals("Sữa")) {
                System.out.println("\nChuyển sang món: [" + monTiepTheo.tenMon + "]");
                monHienTai = monTiepTheo; // Cập nhật món hiện tại là "Sữa"

                // Từ "Sữa", dùng phương thức "ăn gì" để chuyển sang món tiếp theo
                // ==> Đi theo tham chiếu từ "Sữa" đến node "Bánh mì"
                monTiepTheo = monHienTai.anGi(); // monTiepTheo bây giờ là Node "Bánh mì"

                if (monTiepTheo != null && monTiepTheo.tenMon.equals("Bánh mì")) {
                    System.out.println("\nChuyển sang món: [" + monTiepTheo.tenMon + "]");
                    monHienTai = monTiepTheo; // Cập nhật món hiện tại là "Bánh mì"

                    // Thử xem ăn gì tiếp từ "Bánh mì"
                    System.out.println();
                    monTiepTheo = monHienTai.anGi(); // Sẽ trả về null vì hết món
                    if (monTiepTheo == null) {
                        System.out.println("\n==> Đã kết thúc bữa ăn!");
                    }
                } else {
                    System.out.println("Lỗi: Món sau khi uống sữa không phải Bánh mì?");
                }
            } else {
                System.out.println("Lỗi: Món sau khi ăn trứng không phải Sữa?");
            }
        } else {
            System.out.println("Bữa ăn không bắt đầu bằng Trứng?");
        }
    }
}