import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Stack<int[]> stack = new Stack<>();

        stack.push(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        stack.push(new int[]{10,11,12,13,14,15,16,17,18,19});

        for (int[] arr : stack) {
            System.out.print("Mảng: ");
            for (int value : arr) {
                System.out.print(value + " ");
            }
        }
        stack.pop();
        stack.peek();
        for (int[] arr : stack) {
            System.out.print("\nMảng: ");
            for (int value : arr) {
                System.out.print(value + " ");
            }
        }
    }
}
