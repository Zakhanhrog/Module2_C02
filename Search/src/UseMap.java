import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UseMap {
    public static void main(String[] args) {
        Map<Integer, Student> listStudent = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        Student student1 = new Student("John", 12, 99999);
        Student student2 = new Student("Khanh", 34, 888888);
        Student student3 = new Student("Lam", 23, 7777777);
        Student student4 = new Student("Tu", 25, 666666);

        listStudent.put(student1.getNumberPhone(), student1);
        listStudent.put(student2.getNumberPhone(), student2);
        listStudent.put(student3.getNumberPhone(), student3);
        listStudent.put(student4.getNumberPhone(), student4);

        // tim sinh vien theo sdt ( key )
        System.out.println("Nhap sdt de lay thong tin sinh vien: ");
        int numberPhone = sc.nextInt();
        if (listStudent.containsKey(numberPhone)) {
            System.out.println("Thong tin cua sinh vien la: " + listStudent.get(numberPhone));
        } else {
            System.out.println("Khong co sinh vien co sdt " + numberPhone);
        }



    }
}
