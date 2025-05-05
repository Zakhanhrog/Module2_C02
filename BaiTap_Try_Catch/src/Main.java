import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Triangle triangle = new Triangle();
        try {
            System.out.println("Nhap canh 1 cua tam giac: ");
            double edge1 = scanner.nextDouble();
            System.out.println("Nhap canh 2 cua tam giac: ");
            double edge2 = scanner.nextDouble();
            System.out.println("Nhap canh 3 cua tam giac: ");
            double edge3 = scanner.nextDouble();
            triangle.validate(edge1, edge2, edge3);
            System.out.printf(" %.2f, %.2f, %.2f la canh hop le cua tam giac", edge1, edge2, edge3);

        }catch (IllegalTriangleException e){
            System.out.println("Canh khong hop le");
        }finally {
            System.out.println("Hoan thanh!");
            scanner.close();
            System.gc();
        }
    }
}