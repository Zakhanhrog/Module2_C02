import org.w3c.dom.Node;

public class FileNode extends FileSystemNode{
    private long size;

    public FileNode(String name, long size) {
        super(name);
        this.size = size;
    }

    @Override
    public long calculateSize() {
        return this.size;
    }

    @Override
    public void printTree(String indent) {
        System.out.println(indent + name + "(" + size + "bytes)");
    }
    public long getSize() {
        return size;
    }
}
