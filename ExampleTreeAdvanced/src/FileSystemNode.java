import java.util.Objects;

public abstract class FileSystemNode {
    protected String name;

    public FileSystemNode(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public abstract long calculateSize();

    public abstract void printTree(String indent);

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        FileSystemNode that = (FileSystemNode) obj;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
