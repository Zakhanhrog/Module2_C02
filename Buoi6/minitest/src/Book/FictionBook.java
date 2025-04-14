package Book;

public class FictionBook extends Book{
    private String category;

    public FictionBook(int bookCode, String name, double price, String author, String category) {
        super(bookCode, name, price, author);
        this.category = category;
    }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }


    @Override
    public double getPrice() {
        return super.getPrice() * 0.93; // 7% discount
    }

    @Override
    public String toString() {
        return "FictionBook{" +
                "bookCode=" + getBookCode() +
                ", name='" + getName() + '\'' +
                ", originalPrice=" + super.getPrice() +
                ", discountedPrice=" + getPrice() +
                ", author='" + getAuthor() + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
