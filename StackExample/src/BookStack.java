import java.util.ArrayList;

public class BookStack {
    private ArrayList<String> stack = new ArrayList<>();

    public void push(String book) {
        stack.add(book);
        System.out.println("Đã đặt sách: " + book);
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Chồng sách đang rỗng!");
            return null;
        }
        String removed = stack.remove(stack.size() - 1);
        System.out.println("Đã lấy ra sách: " + removed);
        return removed;
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("Chồng sách đang rỗng!");
            return null;
        }
        String top = stack.get(stack.size() - 1);
        System.out.println("Sách trên cùng là: " + top);
        return top;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void printAllStack() {
        if (isEmpty()) {
            System.out.println("Chồng sách đang rỗng.");
        } else {
            System.out.println("Chồng sách hiện tại:");
            for (int i = stack.size() - 1; i >= 0; i--) {
                System.out.println("[" + stack.get(i) + "]");
            }
        }
    }
}
