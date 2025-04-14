package Shape;

public class rectangle extends Shape {
    private double width;
    private double height;

    public rectangle() {

    }

    public rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * Math.PI * width;
    }

    @Override
    public String toString() {
        return "rectangle with of "
                + "width: " + width
                + ", height: " + height
                + ", area: " + getArea()
                + ", perimeter: " + getPerimeter()
                + super.toString();
    }
}