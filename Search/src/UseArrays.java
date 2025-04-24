
import java.util.*;

public class UseArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> listStudent = new ArrayList<>();
        listStudent.add(new Student("Khanh", 18));
        listStudent.add(new Student("Tu", 40));
        listStudent.add(new Student("Hung", 22));
        listStudent.add(new Student("Tung", 44));
        listStudent.add(new Student("Nam", 26));
        System.out.println("List student: " + listStudent);

        listStudent.sort(Comparable::compareTo);
        for(Student student : listStudent) {
            System.out.println(student);
        }
        // khong su dung de quy
        System.out.println("Nhap vao tuoi muon in ra: ");
        int inputAge = scanner.nextInt();
        int out = binarySearchDoNotUseRecursive(listStudent, inputAge);
        if (out !=-1){
            System.out.println("Hoc sinh: " + listStudent.get(binarySearchDoNotUseRecursive(listStudent, inputAge)));
        }else {
            System.out.println("Khong co hoc sinh tuoi " + inputAge);
        }

        // su dung de quy
        System.out.println("Nhap vao tuoi muon in ra: ");
        inputAge = scanner.nextInt();
        out = binarySearchUseRecursive(listStudent, inputAge, 0, listStudent.size() - 1);
        if (out !=-1){
            System.out.println("Hoc sinh: " + listStudent.get(binarySearchUseRecursive(listStudent, inputAge, 0, listStudent.size() - 1)));
        }else {
            System.out.println("Khong co hoc sinh tuoi " + inputAge);
        }

    }
    public static int binarySearchDoNotUseRecursive(List<Student> listStudent, int inputAge) {
        int low = 0;
        int high = listStudent.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int compare = listStudent.get(mid).getAge() - inputAge;
            if (compare < 0) {
                low = mid + 1;
            } else if (compare > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    public static int binarySearchUseRecursive(List<Student> listStudent, int inputAge, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (listStudent.get(mid).getAge() == inputAge) {
            return mid;
        } else if (listStudent.get(mid).getAge() > inputAge) {
            return binarySearchUseRecursive( listStudent, inputAge, low, mid - 1 );
        } else {
            return binarySearchUseRecursive( listStudent, inputAge, mid + 1, high );
        }
    }
}