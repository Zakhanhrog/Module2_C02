package Book;


public class Main {
    public static void main(String[] args) {
        // Create individual book objects
        ProgrammingBook pBook1 = new ProgrammingBook(101, "Clean Code", 150.0, "Robert C. Martin", "Java", "N/A");
        ProgrammingBook pBook2 = new ProgrammingBook(102, "Effective Java", 180.0, "Joshua Bloch", "Java", "N/A");
        ProgrammingBook pBook3 = new ProgrammingBook(103, "Python Crash Course", 120.0, "Eric Matthes", "Python", "Django");

        FictionBook fBook1 = new FictionBook(201, "Harry Potter 1", 95.0, "J.K. Rowling", "Fantasy");
        FictionBook fBook2 = new FictionBook(202, "Dune", 110.0, "Frank Herbert", "Viễn tưởng 1");
        FictionBook fBook3 = new FictionBook(203, "The Hobbit", 85.0, "J.R.R. Tolkien", "Viễn tưởng 1");

        // Calculate total price by summing individual prices
        double totalPrice = pBook1.getPrice() + pBook2.getPrice() + pBook3.getPrice() +
                fBook1.getPrice() + fBook2.getPrice() + fBook3.getPrice();

        System.out.println("Tổng tiền của 6 cuốn sách: " + String.format("%.2f", totalPrice));
        System.out.println("------------------------------------");

        // Count Java Programming books individually
        int javaBookCount = 0;
        if ("Java".equalsIgnoreCase(pBook1.getLanguage())) {
            javaBookCount++;
        }
        if ("Java".equalsIgnoreCase(pBook2.getLanguage())) {
            javaBookCount++;
        }
        if ("Java".equalsIgnoreCase(pBook3.getLanguage())) {
            javaBookCount++;
        }
        System.out.println("Số sách ProgrammingBook có language là \"Java\": " + javaBookCount);
        System.out.println("------------------------------------");

        // Count Fiction books with category "Viễn tưởng 1" individually
        int fictionCategoryCount = 0;
        if ("Viễn tưởng 1".equalsIgnoreCase(fBook1.getCategory())) {
            fictionCategoryCount++;
        }
        if ("Viễn tưởng 1".equalsIgnoreCase(fBook2.getCategory())) {
            fictionCategoryCount++;
        }
        if ("Viễn tưởng 1".equalsIgnoreCase(fBook3.getCategory())) {
            fictionCategoryCount++;
        }
        System.out.println("Số sách Fiction có category là \"Viễn tưởng 1\": " + fictionCategoryCount);
        System.out.println("------------------------------------");

        // Count Fiction books with price < 100 individually
        int fictionPriceCount = 0;
        if (fBook1.getPrice() < 100.0) {
            fictionPriceCount++;
        }
        if (fBook2.getPrice() < 100.0) {
            fictionPriceCount++;
        }
        if (fBook3.getPrice() < 100.0) {
            fictionPriceCount++;
        }
        System.out.println("Số sách Fiction có giá (sau giảm) < 100: " + fictionPriceCount);
        System.out.println("------------------------------------");

    }
}