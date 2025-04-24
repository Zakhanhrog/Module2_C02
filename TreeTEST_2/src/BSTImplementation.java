import java.util.LinkedList;
import java.util.Queue;

public class BSTImplementation {
    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        System.out.println("Bắt đầu chèn các phần tử...");
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        bst.insert(30); //trung lap

        System.out.println("\nChèn xong.");

        bst.printTreeStructure();

        // Thực hiện duyệt theo thứ tự để kiểm tra kết quả sắp xếp
        bst.inOrderTraversal();

//        tim kiem
        System.out.println("\nKiểm tra tìm kiếm:");
        System.out.println("Tìm 40: " + bst.search(40)); // true
        System.out.println("Tìm 60: " + bst.search(60)); // true
        System.out.println("Tìm 99: " + bst.search(99)); // false
        System.out.println("Tìm 15: " + bst.search(15)); // false
    }

}