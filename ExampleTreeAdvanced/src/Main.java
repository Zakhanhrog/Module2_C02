import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // 1. tao thu muc moi
        DirectoryNode root = new DirectoryNode("/"); //thu muc goc

        DirectoryNode docs = new DirectoryNode("Documents");
        DirectoryNode downloads = new DirectoryNode("Downloads");
        DirectoryNode pictures = new DirectoryNode("Pictures");

        FileNode report = new FileNode("report.docx", 16340); //16KB
        FileNode notes = new FileNode("notes.txt", 6340); //16KB

        DirectoryNode projectA = new DirectoryNode("ProjectA");
        FileNode code1 = new FileNode("main.java", 8340);
        FileNode readme = new FileNode("README.md", 1024);

        FileNode installer = new FileNode("setup.exe", 10485760); // 10 MB
        FileNode image1 = new FileNode("cat.jpg", 512000); // 500 KB
        FileNode image2 = new FileNode("dog.png", 1024000);

        root.addNode(downloads);
        root.addNode(pictures);
        root.addNode(docs);

        root.addNode(notes);
        root.addNode(projectA);
        root.addNode(report);

        projectA.addNode(code1);
        projectA.addNode(readme);

        projectA.addNode(installer);

        pictures.addNode(image1);
        pictures.addNode(image2);

        // 2. in cau truc file tu goc
        System.out.println("Cấu trúc cây thư mục:");
        System.out.println("----------------------");
        root.printTree(""); // Bắt đầu với không thụt đầu dòng
        System.out.println("----------------------\n");

        // 3. tinh va in kich thuoc thu muc documents
        long docsSize = docs.calculateSize();
        System.out.println("Tổng kích thước thư mục docs '" + docs.getName() + "': " + docsSize + " bytes");
        System.out.println("----------------------\n");

        long picturesSize = docs.calculateSize();
        System.out.println("Tổng kích thước thư mục pictures '" + pictures.getName() + "': " + picturesSize + " bytes");
        System.out.println("----------------------\n");


        // 4. tim kien nut
        System.out.println("Tìm kiếm nút:");
        System.out.println("----------------------");
        FileSystemNode foundNode1 = root.findNode("Documents");
        if (foundNode1 instanceof DirectoryNode) {
            System.out.println("Tìm thấy thư mục: " + foundNode1.getName());
            // Thử tìm con bên trong thư mục vừa tìm được
            FileSystemNode foundNode2 = ((DirectoryNode) foundNode1).findNode("ProjectA");
            if(foundNode2 != null) {
                System.out.println("  -> Tìm thấy nút con: " + foundNode2.getName());
            } else {
                System.out.println("  -> Không tìm thấy nút con 'ProjectA' trong 'Documents'");
            }
        } else {
            System.out.println("Không tìm thấy nút 'Documents' hoặc nó không phải thư mục.");
        }

        FileSystemNode nonExistent = root.findNode("Music");
        System.out.println("Tìm thấy nút 'Music': " + (nonExistent != null ? nonExistent.getName() : "Không tìm thấy"));
        System.out.println("----------------------\n");

        // 5. lay danh sach con cua mot thu muc
        System.out.println("Danh sách con của thư mục '" + docs.getName() + "' (theo thứ tự alphabet):");
        System.out.println("----------------------");
        List<FileSystemNode> docChildren = docs.getChildren();
        for(FileSystemNode child : docChildren) {
            System.out.println("- " + child.getName() + (child instanceof DirectoryNode ? "/" : ""));
        }
        System.out.println("----------------------");





    }
}