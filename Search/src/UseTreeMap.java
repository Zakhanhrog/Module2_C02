import java.util.*;


public class UseTreeMap {
    public static void main(String[] args) {
        // sap xep theo do dai string
        Comparator<String> sortByLength = Comparator.comparingInt(String::length);
        // sap xep theo aplhaB neu 2 chu co do dai bang nhau
        Comparator<String> sortByLengththenAplhaB = sortByLength.thenComparing(Comparator.naturalOrder());

        // sap xep theo key la Interger
        Comparator<Integer> sortByKey = Comparator.comparingInt(i->i );

//        TreeMap<Integer, Student> mapStudent = new TreeMap<>(Comparator.reverseOrder());    // giam dan
        TreeMap<Integer, Student> mapStudent = new TreeMap<>(sortByKey);
        Scanner sc = new Scanner(System.in);

        Student s1 = new Student("Khanh", 12, 123);
        Student s2 = new Student("Hung", 23, 393);
        Student s3 = new Student("Tu", 15, 1822);
        Student s4 = new Student("Lam", 25, 999);
        Student s5 = new Student("Johnn", 34, 777);
        Student s6 = new Student("Pham Khanh", 24, 666);
        Student s7 = new Student("Nam", 26, 555);

        mapStudent.put(11 , s1);
        mapStudent.put(5, s2);
        mapStudent.put(41, s3);
        mapStudent.put(30, s4);
        mapStudent.put(21, s5);
        mapStudent.put(12, s6);
        mapStudent.put(23, s7);

        //in treemap theo thu tu cai dat o dau
        mapStudent.forEach((key, value) -> System.out.println(key + "\t" + value));

        // tu dong sap xep theo key tang dan ( tu dong sap xep cua treemap )
        System.out.println("Danh sach sinh vien: "+ mapStudent);

        // sap xep bang comparator - su dung ARRAYS
        ArrayList<Student> studentList = new ArrayList<>(mapStudent.values());
        Collections.sort(studentList, new SortStudentByName());
        System.out.println("Danh sach sinh vien sau khi sap xep: " + studentList);

        Collections.sort(studentList, new SortStudentByKey());
        System.out.println("Danh sach sinh vien sau khi sap xep: " + studentList);

        // cach don gian de sap xep theo tuoi hay bat ki doi tuong nao minh muon
        studentList.sort(Comparator.comparing(Student::getAge));

        // tim sinh vien theo key
        System.out.print("Nhap Key can tim kiem: ");
        System.out.println();
        int key = sc.nextInt();
        if (mapStudent.containsKey(key)) {
            System.out.println("Thong tin cua sinh vien la: " + mapStudent.get(key));
        } else {
            System.out.println("Khong co sinh vien co key:  " + key);
        }
    }
}
