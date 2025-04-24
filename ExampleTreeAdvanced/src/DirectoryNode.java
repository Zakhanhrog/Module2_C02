import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class DirectoryNode extends FileSystemNode{

    private SortedMap<String, FileSystemNode> children;

    public DirectoryNode(String name) {
        super(name);
        children = new TreeMap<>();
    }
    public void addNode(FileSystemNode node) {
        if (node == null) {
            System.err.println("Loi khong them nut");
            return;
        }
        if (children.containsKey(node.getName())) {
            System.out.println("Thong bao: Nut '"+node.getName()+ "' da ton tai trong thu muc"
            + this.name + " !");
        }else {
            children.put(node.getName(), node);
        }
    }
    public FileSystemNode findNode(String name) {
        return children.get(name);
    }


    @Override
    public long calculateSize() {
        long totalSize = 0;
        for (FileSystemNode child : children.values()) {
            totalSize += child.calculateSize();
        }
        return totalSize;
    }

    @Override
    public void printTree(String indent) {
        System.out.println(indent + name + "/");
        for (FileSystemNode child : children.values()) {
            child.printTree(indent + "  ");
        }

    }
    public List<FileSystemNode> getChildren() {
        return new ArrayList<>(children.values());
    }
}
