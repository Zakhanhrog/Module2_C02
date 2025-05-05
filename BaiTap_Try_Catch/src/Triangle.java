public class Triangle {
    public static void validate(double a, double b, double c) throws IllegalTriangleException {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("Triangle is not legal");
        }
        if (a<= 0 || b <= 0 || c <= 0){
            throw new IllegalTriangleException("Triangle is not legal");
        }
    }
}
