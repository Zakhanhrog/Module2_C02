import java.util.Scanner;

abstract class NhanVien {
    private String maNhanVien;
    private String hoTen;
    private int tuoi;
    private String soDienThoai;
    private String email;

    public NhanVien(String maNhanVien, String hoTen, int tuoi, String soDienThoai, String email) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.soDienThoai = soDienThoai;
        this.email = email;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }
    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public int getTuoi() {
        return tuoi;
    }
    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
    public String getSoDienThoai() {
        return soDienThoai;
    }
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public abstract double tinhLuong();

    @Override
    public String toString() {
        return "MaNV: " + maNhanVien + ", HoTen: " + hoTen + ", Tuoi: " + tuoi +
                ", SDT: " + soDienThoai + ", Email: " + email;
    }
}

class NhanVienFulltime extends NhanVien {
    private double tienThuong;
    private double tienPhat;
    private double luongCung;

    public NhanVienFulltime(String maNhanVien, String hoTen, int tuoi, String soDienThoai, String email,
                            double tienThuong, double tienPhat, double luongCung) {
        super(maNhanVien, hoTen, tuoi, soDienThoai, email);
        this.tienThuong = tienThuong;
        this.tienPhat = tienPhat;
        this.luongCung = luongCung;
    }

    public double getTienThuong() {
        return tienThuong;
    }

    public void setTienThuong(double tienThuong) {
        this.tienThuong = tienThuong;
    }

    public double getTienPhat() {
        return tienPhat;
    }

    public void setTienPhat(double tienPhat) {
        this.tienPhat = tienPhat;
    }

    public double getLuongCung() {
        return luongCung;
    }

    public void setLuongCung(double luongCung) {
        this.luongCung = luongCung;
    }

    @Override
    public double tinhLuong() {
        return this.luongCung + (this.tienThuong - this.tienPhat);
    }

    @Override
    public String toString() {
        return super.toString() + ", Loai: Fulltime, Luong Cung: " + luongCung +
                ", Thuong: " + tienThuong + ", Phat: " + tienPhat + ", Luong Thuc Linh: " + String.format("%.0f", tinhLuong());
    }
}

class NhanVienParttime extends NhanVien {
    private double soGioLamViec;

    public NhanVienParttime(String maNhanVien, String hoTen, int tuoi, String soDienThoai, String email,
                            double soGioLamViec) {
        super(maNhanVien, hoTen, tuoi, soDienThoai, email);
        this.soGioLamViec = soGioLamViec;
    }

    public double getSoGioLamViec() { return soGioLamViec; }
    public void setSoGioLamViec(double soGioLamViec) { this.soGioLamViec = soGioLamViec; }

    @Override
    public double tinhLuong() {
        return this.soGioLamViec * 100000;
    }

    @Override
    public String toString() {
        return super.toString() + ", Loai: Parttime, Gio Lam Viec: " + soGioLamViec +
                ", Luong Thuc Linh: " + String.format("%.0f", tinhLuong());
    }
}

class QuanLyNhanVien {
    private NhanVien[] danhSachNhanVien;
    private int soLuongNhanVienHienTai;
    private final int MAX_EMPLOYEES;

    public QuanLyNhanVien(int maxEmployees) {
        this.MAX_EMPLOYEES = maxEmployees;
        this.danhSachNhanVien = new NhanVien[maxEmployees];
        this.soLuongNhanVienHienTai = 0;
    }

    public boolean themNhanVien(NhanVien nv) {
        if (soLuongNhanVienHienTai < MAX_EMPLOYEES) {
            danhSachNhanVien[soLuongNhanVienHienTai] = nv;
            soLuongNhanVienHienTai++;
            System.out.println("Thêm nhân viên thành công.");
            return true;
        } else {
            System.out.println("Danh sách nhân viên đã đầy, không thể thêm.");
            return false;
        }
    }

    public void hienThiDanhSachNhanVien() {
        System.out.println("\n--- DANH SÁCH TẤT CẢ NHÂN VIÊN ---");
        if (soLuongNhanVienHienTai == 0) {
            System.out.println("Chưa có nhân viên nào.");
            return;
        }
        for (int i = 0; i < soLuongNhanVienHienTai; i++) {
            System.out.println(danhSachNhanVien[i]);
        }
    }

    public double tinhTrungBinhLuong() {
        if (soLuongNhanVienHienTai == 0) {
            return 0.0;
        }
        double tongLuong = 0;
        for (int i = 0; i < soLuongNhanVienHienTai; i++) {
            tongLuong += danhSachNhanVien[i].tinhLuong();
        }
        return tongLuong / soLuongNhanVienHienTai;
    }

    public void lietKeFulltimeLuongThap() {
        if (soLuongNhanVienHienTai == 0) {
            System.out.println("Chưa có nhân viên nào để thực hiện chức năng này.");
            return;
        }
        double luongTrungBinh = tinhTrungBinhLuong();
        System.out.println("\n--- DANH SÁCH NHÂN VIÊN FULLTIME CÓ LƯƠNG THẤP HƠN TRUNG BÌNH (" + String.format("%.2f", luongTrungBinh) + ") ---");
        boolean found = false;
        for (int i = 0; i < soLuongNhanVienHienTai; i++) {
            if (danhSachNhanVien[i] instanceof NhanVienFulltime) {
                if (danhSachNhanVien[i].tinhLuong() < luongTrungBinh) {
                    System.out.println(danhSachNhanVien[i]);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("Không có nhân viên fulltime nào có lương thấp hơn mức trung bình.");
        }
    }

    public double tinhTongLuongParttime() {
        double tongLuongParttime = 0;
        for (int i = 0; i < soLuongNhanVienHienTai; i++) {
            if (danhSachNhanVien[i] instanceof NhanVienParttime) {
                tongLuongParttime += danhSachNhanVien[i].tinhLuong();
            }
        }
        return tongLuongParttime;
    }

    public void sapXepFulltimeTheoLuong() {
        int countFulltime = 0;
        for (int i = 0; i < soLuongNhanVienHienTai; i++) {
            if (danhSachNhanVien[i] instanceof NhanVienFulltime) {
                countFulltime++;
            }
        }

        if (countFulltime == 0) {
            System.out.println("\n--- KHÔNG CÓ NHÂN VIÊN FULLTIME ĐỂ SẮP XẾP ---");
            return;
        }

        NhanVienFulltime[] danhSachFulltime = new NhanVienFulltime[countFulltime];
        int index = 0;
        for (int i = 0; i < soLuongNhanVienHienTai; i++) {
            if (danhSachNhanVien[i] instanceof NhanVienFulltime) {
                danhSachFulltime[index++] = (NhanVienFulltime) danhSachNhanVien[i];
            }
        }

        int n = danhSachFulltime.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (danhSachFulltime[j].tinhLuong() > danhSachFulltime[j + 1].tinhLuong()) {
                    NhanVienFulltime temp = danhSachFulltime[j];
                    danhSachFulltime[j] = danhSachFulltime[j + 1];
                    danhSachFulltime[j + 1] = temp;
                }
            }
        }

        System.out.println("\n--- DANH SÁCH NHÂN VIÊN FULLTIME SAU KHI SẮP XẾP THEO LƯƠNG TĂNG DẦN ---");
        for (int i = 0; i < danhSachFulltime.length; i++) {
            System.out.println(danhSachFulltime[i]);
        }
    }

    public static void main(String[] args) {
        QuanLyNhanVien qlnv = new QuanLyNhanVien(100);
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        // dữ liệu nhân vien
        qlnv.themNhanVien(new NhanVienFulltime("FT001", "Nguyen Van A", 30, "090111222", "a@gmail.com", 2000000, 500000, 15000000));
        qlnv.themNhanVien(new NhanVienParttime("PT001", "Le Van C", 22, "091555666", "c@gmail.com", 100));
        qlnv.themNhanVien(new NhanVienFulltime("FT003", "Tran Thi B", 28, "090333444", "b@gmail.com", 1500000, 200000, 12000000));
        qlnv.themNhanVien(new NhanVienFulltime("FT004", "Tran Thi C", 28, "090333445", "c@gmail.com", 1600000, 100000, 15000000));
        qlnv.themNhanVien(new NhanVienFulltime("FT005", "Tran Thi D", 28, "090337446", "d@gmail.com", 1700000, 600000, 17000000));
        qlnv.themNhanVien(new NhanVienFulltime("FT006", "Tran Thi K", 28, "090338449", "k@gmail.com", 1800000, 700000, 13000000));


        do {
            System.out.println("\n--- MENU QUẢN LÝ NHÂN VIÊN ---");
            System.out.println("1. Thêm nhân viên mới");
            System.out.println("2. Hiển thị danh sách tất cả nhân viên");
            System.out.println("3. Tính lương trung bình của công ty");
            System.out.println("4. Liệt kê nhân viên Fulltime có lương thấp hơn trung bình");
            System.out.println("5. Tính tổng lương phải trả cho nhân viên Parttime");
            System.out.println("6. Sắp xếp nhân viên Fulltime theo lương tăng dần và hiển thị");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn của bạn: ");


            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        themNhanVienMoi(scanner, qlnv);
                        break;
                    case 2:
                        qlnv.hienThiDanhSachNhanVien();
                        break;
                    case 3:
                        double luongTB = qlnv.tinhTrungBinhLuong();
                        if (luongTB == 0 && qlnv.soLuongNhanVienHienTai == 0) {
                            System.out.println("Chưa có nhân viên nào để tính lương trung bình.");
                        } else {
                            System.out.println("Lương trung bình của công ty: " + String.format("%.2f", luongTB));
                        }
                        break;
                    case 4:
                        qlnv.lietKeFulltimeLuongThap();
                        break;
                    case 5:
                        double tongLuongPT = qlnv.tinhTongLuongParttime();
                        System.out.println("Tổng lương phải trả cho nhân viên Parttime: " + String.format("%.0f", tongLuongPT));
                        break;
                    case 6:
                        qlnv.sapXepFulltimeTheoLuong();
                        break;
                    case 0:
                        System.out.println("Đang thoát chương trình...");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                }
            } else {
                System.out.println("Đầu vào không hợp lệ. Vui lòng nhập số.");
                scanner.next();
                scanner.nextLine();
                choice = -1;
            }

        } while (choice != 0);

        scanner.close();
        System.out.println("Chương trình đã kết thúc.");
    }

    private static void themNhanVienMoi(Scanner scanner, QuanLyNhanVien qlnv) {
        System.out.println("\n--- THÊM NHÂN VIÊN MỚI ---");
        System.out.println("Chọn loại nhân viên:");
        System.out.println("1. Nhân viên Fulltime");
        System.out.println("2. Nhân viên Parttime");
        System.out.print("Lựa chọn của bạn: ");
        int loaiNV = -1;


        while (loaiNV == -1) {
            if (scanner.hasNextInt()) {
                int tempLoai = scanner.nextInt();
                scanner.nextLine();
                if (tempLoai == 1 || tempLoai == 2) {
                    loaiNV = tempLoai;
                } else {
                    System.out.println("Lựa chọn loại nhân viên không hợp lệ (chỉ 1 hoặc 2). Vui lòng nhập lại.");
                    System.out.print("Lựa chọn của bạn: ");
                }
            } else {
                System.out.println("Đầu vào không hợp lệ. Vui lòng nhập số 1 hoặc 2.");
                scanner.next();
                scanner.nextLine();
                System.out.print("Lựa chọn của bạn: ");
            }
        }


        System.out.print("Nhập mã nhân viên: ");
        String maNV = scanner.nextLine();
        System.out.print("Nhập họ tên: ");
        String hoTen = scanner.nextLine();

        int tuoi = -1;
        while (tuoi <= 0) {
            System.out.print("Nhập tuổi: ");
            if (scanner.hasNextInt()) {
                tuoi = scanner.nextInt();
                scanner.nextLine();
                if (tuoi <= 0) {
                    System.out.println("Tuổi phải là số dương.");
                }
            } else {
                System.out.println("Tuổi phải là một số nguyên dương.");
                scanner.next();
                scanner.nextLine();
                tuoi = -1;
            }
        }


        System.out.print("Nhập số điện thoại: ");
        String sdt = scanner.nextLine();
        System.out.print("Nhập email: ");
        String email = scanner.nextLine();

        if (loaiNV == 1) {
            double luongCung = -1, tienThuong = -1, tienPhat = -1;

            while(luongCung < 0) {
                System.out.print("Nhập lương cứng: ");
                if(scanner.hasNextDouble()) {
                    luongCung = scanner.nextDouble();
                    scanner.nextLine();
                    if(luongCung < 0) System.out.println("Lương cứng không được âm.");
                } else {
                    System.out.println("Lương cứng phải là một số.");
                    scanner.next();
                    scanner.nextLine();
                    luongCung = -1;
                }
            }
            while(tienThuong < 0) {
                System.out.print("Nhập tiền thưởng: ");
                if(scanner.hasNextDouble()) {
                    tienThuong = scanner.nextDouble();
                    scanner.nextLine();
                    if(tienThuong < 0) System.out.println("Tiền thưởng không được âm.");
                } else {
                    System.out.println("Tiền thưởng phải là một số.");
                    scanner.next();
                    scanner.nextLine();
                    tienThuong = -1;
                }
            }
            while(tienPhat < 0) {
                System.out.print("Nhập tiền phạt: ");
                if (scanner.hasNextDouble()) {
                    tienPhat = scanner.nextDouble();
                    scanner.nextLine();
                    if(tienPhat < 0) System.out.println("Tiền phạt không được âm.");
                } else {
                    System.out.println("Tiền phạt phải là một số.");
                    scanner.next();
                    scanner.nextLine();
                    tienPhat = -1;
                }
            }

            NhanVien nv = new NhanVienFulltime(maNV, hoTen, tuoi, sdt, email, tienThuong, tienPhat, luongCung);
            qlnv.themNhanVien(nv);

        } else {
            double soGioLamViec = -1;
            while(soGioLamViec < 0) {
                System.out.print("Nhập số giờ làm việc: ");
                if (scanner.hasNextDouble()) {
                    soGioLamViec = scanner.nextDouble();
                    scanner.nextLine();
                    if(soGioLamViec < 0) System.out.println("Số giờ làm không được âm.");
                } else {
                    System.out.println("Số giờ làm việc phải là một số.");
                    scanner.next();
                    scanner.nextLine();
                    soGioLamViec = -1;
                }
            }
            NhanVien nv = new NhanVienParttime(maNV, hoTen, tuoi, sdt, email, soGioLamViec);
            qlnv.themNhanVien(nv);
        }
    }
}