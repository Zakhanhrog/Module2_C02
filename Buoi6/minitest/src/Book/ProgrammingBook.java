package Book;

public class ProgrammingBook extends Book {
    private String language;
    private String framework;

    public ProgrammingBook(int bookCode, String name, double price, String author, String language, String framework) {
        super(bookCode, name, price, author);
        this.language = language;
        this.framework = framework;
    }

    public String getLanguage() { return language; }
    public String getFramework() { return framework; }

    public void setLanguage(String language) { this.language = language; }
    public void setFramework(String framework) { this.framework = framework; }

    // Method Overriding ("Nạp chồng" concept applied via overriding)
    @Override
    public double getPrice() {
        return super.getPrice() * 0.95; // 5% discount
    }

    @Override
    public String toString() {
        return "ProgrammingBook{" +
                "bookCode=" + getBookCode() +
                ", name='" + getName() + '\'' +
                ", originalPrice=" + super.getPrice() +
                ", discountedPrice=" + getPrice() +
                ", author='" + getAuthor() + '\'' +
                ", language='" + language + '\'' +
                ", framework='" + framework + '\'' +
                '}';
    }
}
