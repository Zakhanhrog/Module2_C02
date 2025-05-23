package Shape;

public class Shape {
    private String color = "red";
    private boolean filled = false;

    public Shape() {
    }
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public boolean isFilled() {
        return filled;
    }
    @Override
    public String toString() {
        return "color: " + getColor() + ", filled: " + (isFilled() ? "filled" : "not filled");
    }
}
