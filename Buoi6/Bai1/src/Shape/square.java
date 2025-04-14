package Shape;

public class square extends rectangle {
    public square() {
    }

    public square(double side) {
        super(side, side);
    }

    public square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setHeight(side);
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setHeight(double height) {
        setSide(height);
    }

    @Override
    public String toString() {
        return "Square with side: "
                + getSide()
                + "\n"
                + "subclass: "
                + super.toString();
    }
}

