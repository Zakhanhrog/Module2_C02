import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

// Lớp đại diện cho một đối tượng phức tạp hơn để minh họa Comparator


public class TreeExampleGeneral {

    public static void main(String[] args) {

        System.out.println("===== TreeSet với Thứ Tự Tự Nhiên (Integer) =====");
        // TreeSet lưu trữ Integer, Integer có sẵn Comparable (thứ tự tự nhiên)
        // Các phần tử sẽ tự động được sắp xếp tăng dần và duy nhất.
        SortedSet<Integer> numberSet = new TreeSet<>();
        numberSet.add(50);
        numberSet.add(20);
        numberSet.add(80);
        numberSet.add(20); // Thêm trùng lặp -> sẽ bị bỏ qua
        numberSet.add(10);
        numberSet.add(65);

        System.out.println("TreeSet (Integer - Natural Order): " + numberSet); // Output: [10, 20, 50, 65, 80]
        System.out.println("Phần tử đầu tiên (nhỏ nhất): " + numberSet.first()); // Output: 10
        System.out.println("Phần tử cuối cùng (lớn nhất): " + numberSet.last());  // Output: 80
        System.out.println("Các phần tử >= 50: " + numberSet.tailSet(50)); // Output: [50, 65, 80]
        System.out.println("Kiểm tra chứa 65? " + numberSet.contains(65)); // Output: true
        System.out.println("Kiểm tra chứa 100? " + numberSet.contains(100)); // Output: false


        System.out.println("\n===== TreeSet với Comparator Tùy Chỉnh (String - Theo Độ Dài) =====");
        // Tạo một Comparator để sắp xếp String theo độ dài, nếu bằng độ dài thì theo alphabet
        Comparator<String> lengthComparator = Comparator
                .comparingInt(String::length) // So sánh độ dài trước
                .thenComparing(Comparator.naturalOrder()); // Nếu độ dài bằng nhau, so sánh tự nhiên

        SortedSet<String> stringSet = new TreeSet<>(lengthComparator);
        stringSet.add("Banana");
        stringSet.add("Apple");
        stringSet.add("Orange");
        stringSet.add("Kiwi");
        stringSet.add("Fig");
        stringSet.add("Grapes");

        System.out.println("TreeSet (String - Length Order): " + stringSet); // Output: [Fig, Kiwi, Apple, Banana, Grapes, Orange] (Sắp xếp theo độ dài, rồi alphabet)


        System.out.println("\n===== TreeMap với Thứ Tự Tự Nhiên Của Key (String - Alphabet) =====");
        // TreeMap lưu cặp Key-Value, sắp xếp theo Key (String - thứ tự alphabet tự nhiên)
        Map<String, Integer> fruitCalories = new TreeMap<>();
        fruitCalories.put("Banana", 105);
        fruitCalories.put("Apple", 95);
        fruitCalories.put("Orange", 62);
        fruitCalories.put("Kiwi", 42);
        fruitCalories.put("Apple", 98); // Cập nhật giá trị cho key "Apple"

        System.out.println("TreeMap (Keys - Natural Order):");
        // Duyệt qua entrySet để thấy thứ tự sắp xếp theo key
        for (Map.Entry<String, Integer> entry : fruitCalories.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
        // Output sẽ sắp xếp theo Key: Apple, Banana, Kiwi, Orange


        System.out.println("\n===== TreeMap với Comparator Tùy Chỉnh Của Key (Book - Theo Tiêu Đề) =====");
        // Sử dụng đối tượng Book làm Key. Mặc định (nếu dùng new TreeMap<>()) sẽ dùng compareTo (theo số trang).
        // Bây giờ ta tạo Comparator để sắp xếp theo tiêu đề thay thế.
        Comparator<Book> titleComparator = Comparator.comparing(Book::getTitle);

        Map<Book, String> bookAuthors = new TreeMap<>(titleComparator); // Cung cấp Comparator
        Book book1 = new Book("The Lord of the Rings", 1178);
        Book book2 = new Book("A Brief History of Time", 256);
        Book book3 = new Book("Pride and Prejudice", 432);
        Book book4 = new Book("The Hitchhiker's Guide to the Galaxy", 224);

        bookAuthors.put(book1, "J.R.R. Tolkien");
        bookAuthors.put(book2, "Stephen Hawking");
        bookAuthors.put(book3, "Jane Austen");
        bookAuthors.put(book4, "Douglas Adams");

        System.out.println("TreeMap (Book Keys - Title Order):");
        for (Map.Entry<Book, String> entry : bookAuthors.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> Author: " + entry.getValue());
        }
        // Output sẽ sắp xếp theo tiêu đề sách (A Brief..., Pride..., The Hitchhiker's..., The Lord...)


        System.out.println("\n===== TreeMap với Thứ Tự Tự Nhiên của Key (Book - Theo Số Trang) =====");
        // Nếu không cung cấp Comparator, TreeMap sẽ dùng compareTo() của lớp Book (đã định nghĩa là theo số trang)
        Map<Book, String> bookAuthorsNatural = new TreeMap<>(); // Không có Comparator -> dùng compareTo()
        bookAuthorsNatural.put(book1, "J.R.R. Tolkien");
        bookAuthorsNatural.put(book2, "Stephen Hawking");
        bookAuthorsNatural.put(book3, "Jane Austen");
        bookAuthorsNatural.put(book4, "Douglas Adams");

        System.out.println("TreeMap (Book Keys - Natural Order - Pages):");
        for (Map.Entry<Book, String> entry : bookAuthorsNatural.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> Author: " + entry.getValue());
        }
        // Output sẽ sắp xếp theo số trang sách (The Hitchhiker's..., A Brief..., Pride..., The Lord...)

    }
}