import java.util.LinkedList;
import java.util.Queue;

class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int data) {
        this.root = insertRecursive(this.root, data);
    }

    public boolean search(int data) {
        return searchRecursive(this.root, data);
    }

    private boolean searchRecursive(Node currentNode, int data) {
        // trường hợp 1: Cây rỗng hoặc không tìm thấy
        if (currentNode == null) {
            return false;
        }
        // trường hợp 2: thấy có giá trị tại nút hiện tại
        if (data == currentNode.data) {
            return true;
        }
        // trường hợp 3: giá trị cần tìm nhỏ hơn -> tìm ở cây con trái
        if (data < currentNode.data) {
            return searchRecursive(currentNode.left, data);
        }
        // trường hợp 4: giá trị cần tìm lớn hơn -> tìm ở cây con phải
        else {
            return searchRecursive(currentNode.right, data);
        }
    }

        private Node insertRecursive(Node currentNode, int data) {
            // Trường hợp 1: Cây (hoặc cây con) rỗng -> tạo nút mới làm gốc
            if (currentNode == null) {
                return new Node(data);
            }

            // Trường hợp 2: Dữ liệu cần chèn nhỏ hơn dữ liệu của nút hiện tại -> đi sang trái
            if (data < currentNode.data) {
                currentNode.left = insertRecursive(currentNode.left, data);
            }
            // Trường hợp 3: Dữ liệu cần chèn lớn hơn dữ liệu của nút hiện tại -> đi sang phải
            else if (data > currentNode.data) {
                currentNode.right = insertRecursive(currentNode.right, data);
            }
            // Trường hợp 4: Dữ liệu bằng với nút hiện tại (trùng lặp)
            else {
                System.out.println("Giá trị " + data + " đã tồn tại, bỏ qua.");
                return currentNode;
            }

            return currentNode;
        }


    public void inOrderTraversal() {
        System.out.print("Duyệt theo thứ tự (In-order): ");
        inOrderRecursive(this.root);
        System.out.println(); // Xuống dòng sau khi duyệt xong
    }

    // phương thức duyệt theo thứ tự
    private void inOrderRecursive(Node node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.print(node.data + " ");
            inOrderRecursive(node.right);
        }
    }


    // In cây theo tầng - Để dễ hình dung hơn
    public void printTreeStructure() {
        if (root == null) {
            System.out.println("Cây rỗng.");
            return;
        }
        System.out.println("Cấu trúc cây (duyệt theo tầng):");
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                System.out.print(currentNode.data + " ");
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            System.out.println();
        }
    }
}