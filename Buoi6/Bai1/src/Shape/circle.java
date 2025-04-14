package Shape;

    public class circle extends Shape {
        private double radius = 1.2;

        public circle() {
        }

        public circle(double radius) {
            this.radius = radius;
        }

        public circle(double radius, String color, boolean filled) {
            super(color, filled);
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

        public double getArea() {
            return Math.PI * radius * radius;
        }

        public double getPerimeter() {
            return 2 * Math.PI * radius;
        }

        @Override
        public String toString() {
            return "cicrle with radius: "
                    + getRadius()
                    + "\n"
                    + "which subclass: "
                    + super.toString();
        }

    }
