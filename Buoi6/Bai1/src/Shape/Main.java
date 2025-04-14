package Shape;

public class Main {
    public static void main(String[] args) {
        // lop cha hinh hoc
        Shape c = new Shape();
        System.out.println(c);
        c.setColor("green");
        System.out.println(c);
        c = new Shape("blue", true);
        System.out.println(c);

        // hinh tron  ke thua hinh hoc
        circle c1 = new circle();
        System.out.println(c1);
        c1 = new circle(2.3, "bluesky", true);
        System.out.println(c1);
        System.out.printf("area: %.2f", c1.getArea());
        System.out.println();
        System.out.printf("perimeter:  %.2f", c1.getPerimeter());

        // hinh chu nhat ke thua hinh hoc
        System.out.println();
        rectangle c2 = new rectangle();
        System.out.println(c2);
        c2 = new rectangle(3.4, 5.3, "blueskynew", true);
        System.out.println(c2);

        // hinh vuong ke thua hinh hoc
        System.out.println();
        square c3 = new square();
        System.out.println(c3);
        c3 = new square(2.3, "bluesky", true);
        System.out.println(c3);

    }
}
