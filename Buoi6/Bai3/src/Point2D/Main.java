package Point2D;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // --- Kiểm thử lớp Point2D ---
        System.out.println("--- kiem thu Point2D ---");

        // Tạo đối tượng Point2D bằng constructor không tham số
        Point2D p2a = new Point2D();
        System.out.println("p2a (default): " + p2a); // Sử dụng toString() ngầm định
        System.out.println("p2a x: " + p2a.getX());
        System.out.println("p2a y: " + p2a.getY());
        System.out.println("p2a xy: " + Arrays.toString(p2a.getXY())); // In mảng cần Arrays.toString

        // Thay đổi giá trị bằng setters
        p2a.setX(1.1f);
        p2a.setY(2.2f);
        System.out.println("p2a (after setX/setY): " + p2a);

        // Tạo đối tượng Point2D bằng constructor có tham số
        Point2D p2b = new Point2D(3.3f, 4.4f);
        System.out.println("p2b (parameterized): " + p2b);

        // Thay đổi giá trị bằng setXY
        p2b.setXY(5.5f, 6.6f);
        System.out.println("p2b (after setXY): " + p2b);
        System.out.println("p2b xy: " + Arrays.toString(p2b.getXY()));

        System.out.println("\n--- Testing Point3D ---");

        // --- Kiểm thử lớp Point3D ---

        // Tạo đối tượng Point3D bằng constructor không tham số
        Point3D p3a = new Point3D();
        System.out.println("p3a (default): " + p3a);
        System.out.println("p3a x (inherited): " + p3a.getX()); // Gọi phương thức kế thừa
        System.out.println("p3a y (inherited): " + p3a.getY()); // Gọi phương thức kế thừa
        System.out.println("p3a z: " + p3a.getZ());
        System.out.println("p3a xyz: " + Arrays.toString(p3a.getXYZ()));

        // Thay đổi giá trị bằng setters (kế thừa và riêng)
        p3a.setX(10.1f); // Setter kế thừa
        p3a.setY(11.2f); // Setter kế thừa
        p3a.setZ(12.3f); // Setter riêng
        System.out.println("p3a (after setX/setY/setZ): " + p3a);

        // Tạo đối tượng Point3D bằng constructor có tham số
        Point3D p3b = new Point3D(20.1f, 21.2f, 22.3f);
        System.out.println("p3b (parameterized): " + p3b);

        // Thay đổi giá trị bằng setXYZ
        p3b.setXYZ(30.4f, 31.5f, 32.6f);
        System.out.println("p3b (after setXYZ): " + p3b);
        System.out.println("p3b xyz: " + Arrays.toString(p3b.getXYZ()));

        // Kiểm tra tính đa hình (Polymorphism)
        System.out.println("\n--- Polymorphism Test ---");
        Point2D pPoly = new Point3D(100f, 200f, 300f); // Khai báo kiểu Point2D, khởi tạo bằng Point3D
        System.out.println("pPoly (as Point2D, obj Point3D): " + pPoly); // toString() của Point3D được gọi
        // pPoly.getZ(); // Lỗi biên dịch! pPoly là kiểu Point2D, không có getZ()
        // Để gọi getZ(), cần ép kiểu:
        if (pPoly instanceof Point3D) {
            Point3D temp = (Point3D) pPoly;
            System.out.println("pPoly z (after cast): " + temp.getZ());
        }
        System.out.println("pPoly x: " + pPoly.getX()); // OK, getX() có trong Point2D
    }
}