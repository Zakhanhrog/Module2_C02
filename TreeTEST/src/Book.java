// Lớp đại diện cho một đối tượng phức tạp hơn để minh họa Comparator
class Book implements Comparable<Book> {
    String title;
    int pages;

    public Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }
    public int getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return "Book{" + "title='" + title + '\'' + ", pages=" + pages + '}';
    }

    // 1. THỨ TỰ TỰ NHIÊN: Sắp xếp sách theo số trang (tăng dần)
    @Override
    public int compareTo(Book other) {
        // So sánh dựa trên số trang
        return Integer.compare(this.pages, other.pages);
        // Nếu muốn sắp xếp theo tiêu đề:
        // return this.title.compareTo(other.title);
    }
}