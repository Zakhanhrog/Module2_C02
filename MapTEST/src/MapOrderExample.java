import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapOrderExample {

    public static void main(String[] args) {
        // Dữ liệu mẫu sẽ thêm vào các Map
        // Thứ tự chèn dự định: Charlie -> Alice -> Bob -> David

        // --- 1. HashMap ---
        // Đặc điểm: Không đảm bảo bất kỳ thứ tự nào khi duyệt.
        // Thứ tự có thể thay đổi khi thêm phần tử hoặc tùy vào phiên bản Java.
        Map<String, Integer> hashMap = new HashMap<>();
        System.out.println("Đang thêm vào HashMap...");
        hashMap.put("Charlie", 30);
        hashMap.put("Alice", 20);
        hashMap.put("Bob", 10);
        hashMap.put("David", 25);
        // Thêm lại một key đã có để xem nó có thay đổi thứ tự không (thường là không, chỉ cập nhật value)
        hashMap.put("Alice", 22);

        System.out.println("\n--- Duyệt HashMap (Thứ tự không đảm bảo) ---");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        System.out.println("-----------------------------------------\n");


        // --- 2. LinkedHashMap ---
        // Đặc điểm: Duy trì thứ tự chèn (insertion order) theo mặc định.
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        System.out.println("Đang thêm vào LinkedHashMap...");
        linkedHashMap.put("Charlie", 30);
        linkedHashMap.put("Alice", 20);
        linkedHashMap.put("Bob", 10);
        linkedHashMap.put("David", 25);
        // Thêm lại một key đã có, chỉ cập nhật value, không thay đổi vị trí trong thứ tự chèn
        linkedHashMap.put("Alice", 22);

        System.out.println("\n--- Duyệt LinkedHashMap (Thứ tự chèn) ---");
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        System.out.println("-----------------------------------------\n");


        // --- 3. TreeMap ---
        // Đặc điểm: Sắp xếp các entry dựa trên thứ tự tự nhiên (natural ordering) của key
        // hoặc theo Comparator được cung cấp. Ở đây, String có thứ tự tự nhiên là alphabet.
        Map<String, Integer> treeMap = new TreeMap<>();
        System.out.println("Đang thêm vào TreeMap...");
        treeMap.put("Charlie", 30);
        treeMap.put("Alice", 20);
        treeMap.put("Bob", 10);
        treeMap.put("David", 25);
        // Thêm lại một key đã có, chỉ cập nhật value, vị trí vẫn giữ nguyên theo sắp xếp key
        treeMap.put("Alice", 22);

        System.out.println("\n--- Duyệt TreeMap (Sắp xếp theo Key - Alphabet) ---");
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        System.out.println("-----------------------------------------\n");
    }
}