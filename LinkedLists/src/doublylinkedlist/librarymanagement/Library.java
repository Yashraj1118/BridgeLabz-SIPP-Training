package doublylinkedlist.librarymanagement;

public class Library {
    public Book head;
    public Book tail;

    public void addAtBeginning(String title, String author, String genre, int id, boolean available) {
        Book b = new Book(title, author, genre, id, available);
        if (head == null) {
            head = tail = b;
        } else {
            b.next = head;
            head.prev = b;
            head = b;
        }
    }

    public void addAtEnd(String title, String author, String genre, int id, boolean available) {
        Book b = new Book(title, author, genre, id, available);
        if (tail == null) {
            head = tail = b;
        } else {
            tail.next = b;
            b.prev = tail;
            tail = b;
        }
    }

    public void addAtPosition(String title, String author, String genre, int id, boolean available, int pos) {
        if (pos <= 0 || head == null) {
            addAtBeginning(title, author, genre, id, available);
            return;
        }

        Book temp = head;
        for (int i = 0; i < pos - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        if (temp.next == null) {
            addAtEnd(title, author, genre, id, available);
        } else {
            Book b = new Book(title, author, genre, id, available);
            b.next = temp.next;
            b.prev = temp;
            temp.next.prev = b;
            temp.next = b;
        }
    }

    public void removeById(int id) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                System.out.println("Book removed: " + id);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found");
    }

    public void searchByTitle(String title) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                printBook(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No book with title: " + title);
    }

    public void searchByAuthor(String author) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                printBook(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No books found by author: " + author);
    }

    public void updateAvailability(int id, boolean status) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                temp.available = status;
                System.out.println("Availability updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found");
    }

    public void displayForward() {
        Book temp = head;
        while (temp != null) {
            printBook(temp);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        Book temp = tail;
        while (temp != null) {
            printBook(temp);
            temp = temp.prev;
        }
    }

    public void countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total books: " + count);
    }

    public void printBook(Book b) {
        System.out.println(b.bookId + " | " + b.title + " | " + b.author + " | " + b.genre + " | " + (b.available ? "Available" : "Not Available"));
    }
}
