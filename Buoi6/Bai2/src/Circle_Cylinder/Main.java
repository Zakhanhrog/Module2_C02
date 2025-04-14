package Circle_Cylinder;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle("red", 5.5);
        System.out.println(circle);

        Cylinder cylinder = new Cylinder();
        cylinder.setRadius(6.5);
        cylinder.setColor("blue");
        cylinder.setHeight(4);
        System.out.println(cylinder);
    }

}