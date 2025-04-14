package Book;

public class Book {
    private int bookCode;
    private String name;
    private double price;
    private String author;

    public Book(int bookCode, String name, double price, String author) {
        this.bookCode = bookCode;
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public int getBookCode() { return bookCode; }
    public String getName() { return name; }
    public double getPrice() { return price; } // Base implementation
    public String getAuthor() { return author; }

    public void setBookCode(int bookCode) { this.bookCode = bookCode; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setAuthor(String author) { this.author = author; }

    @Override
    public String toString() {
        return "Book{" +
                "bookCode=" + bookCode +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }
}
