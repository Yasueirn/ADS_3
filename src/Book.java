public class Book {
    private int isbn;
    private int pageCount;

    public Book(int isbn, int pageCount) {
        this.isbn = isbn;
        this.pageCount = pageCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Book)) return false;
        Book other = (Book) obj;
        return this.isbn == other.isbn && this.pageCount == other.pageCount;
    }
}
