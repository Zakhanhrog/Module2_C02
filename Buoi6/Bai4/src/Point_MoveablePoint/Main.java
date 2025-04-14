package Point_MoveablePoint;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

                // Tạo đối tượng Point
                Point p1 = new Point(3.5f, 4.1f);
                System.out.println("Point p1: " + p1); // Output: Point p1: (3.5,4.1)

                // Tạo đối tượng MovablePoint
                MoveablePoint mp1 = new MoveablePoint(1.0f, 2.0f, 0.5f, 0.2f);
                System.out.println("MovablePoint mp1 (before move): " + mp1); // Output: MovablePoint mp1 (before move): (1.0,2.0),speed=(0.5,0.2)

                // Di chuyển mp1
                mp1.move();
                System.out.println("MovablePoint mp1 (after move 1): " + mp1); // Output: MovablePoint mp1 (after move 1): (1.5,2.2),speed=(0.5,0.2)

                // Di chuyển tiếp (method chaining)
                mp1.move().move(); // Di chuyển 2 lần nữa
                System.out.println("MovablePoint mp1 (after move 3): " + mp1); // Output: MovablePoint mp1 (after move 3): (2.5,2.6),speed=(0.5,0.2)

                // Thay đổi tốc độ
                mp1.setSpeed(1.0f, 1.0f);
                mp1.move();
                System.out.println("MovablePoint mp1 (after speed change and move): " + mp1); // Output: MovablePoint mp1 (after speed change and move): (3.5,3.6),speed=(1.0,1.0)

                // Tạo MovablePoint chỉ với tốc độ
                MoveablePoint mp2 = new MoveablePoint( -0.1f, 0.1f);
                System.out.println("MovablePoint mp2 (initial): " + mp2); // Output: MovablePoint mp2 (initial): (0.0,0.0),speed=(-0.1,0.1)
                mp2.move();
                System.out.println("MovablePoint mp2 (after move): " + mp2); // Output: MovablePoint mp2 (after move): (-0.1,0.1),speed=(-0.1,0.1)

    }
}