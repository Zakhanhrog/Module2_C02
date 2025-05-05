import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int[] createArrayRandom() {
        Random random = new Random();
        int[] arr = new int[50];
        System.out.println("Danh sach phan tu cua mang: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = createArrayRandom();
        System.out.println();
        System.out.println("Nhap so can tim trong mang (vi tri thu may): ");
        int index = input.nextInt();
        try {
            System.out.printf("Phan tu can tim la: %d", arr[index]);
            System.out.println();
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.err.println("Loi tinh toan");
        } catch (Exception e) {
            System.err.println("Khong co phan tu can tim trong mang!");
        } finally {
            System.out.println("Hoan thanh!");
            System.out.println("Dang xoa mang...");
            arr = null;
            System.gc();
            System.out.println("Mang da xoa!");
            System.out.println("Dang thoat...");
            input.close();
        }
    }
}