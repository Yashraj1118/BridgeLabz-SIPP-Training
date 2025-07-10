package doublylinkedlist.librarymanagement;

public class Book {
    public String title;
    public String author;
    public String genre;
    public int bookId;
    public boolean available;

    public Book prev;
    public Book next;

    public Book(String title, String author, String genre, int bookId, boolean available) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.available = available;
    }
}
