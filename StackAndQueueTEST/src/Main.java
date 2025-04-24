import java.util.Stack;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
      Stack<ArrayList> stack = new Stack<>();
      ArrayList<String> arr = new ArrayList<>();
      ArrayList<String> arr1 = new ArrayList<>();

      arr.add("Khanh");
      arr.add("Tu");
      arr.add("Hung");

      arr1.add("Khanh");
      arr1.add("Tu");
      arr1.add("Hung");

      stack.push(arr);
      stack.push(arr1);

      System.out.println(stack);
//      pushArrAndPrint(arr, stack);

        stack.pop();
        System.out.println(stack);
    }


}