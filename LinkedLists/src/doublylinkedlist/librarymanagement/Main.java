package doublylinkedlist.librarymanagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);
        int ch;

        while (true) {
            System.out.println("1 Add Book at Beginning");
            System.out.println("2 Add Book at End");
            System.out.println("3 Add Book at Position");
            System.out.println("4 Remove Book by ID");
            System.out.println("5 Search by Title");
            System.out.println("6 Search by Author");
            System.out.println("7 Update Availability");
            System.out.println("8 Display Forward");
            System.out.println("9 Display Reverse");
            System.out.println("10 Count Books");
            System.out.println("0 Exit");
            ch = sc.nextInt();

            if (ch == 0) break;

            if (ch == 1) {
                System.out.print("Enter title, author, genre, id, available (true/false): ");
                lib.addAtBeginning(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextBoolean());
            } else if (ch == 2) {
                System.out.print("Enter title, author, genre, id, available (true/false): ");
                lib.addAtEnd(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextBoolean());
            } else if (ch == 3) {
                System.out.print("Enter title, author, genre, id, available (true/false), position: ");
                lib.addAtPosition(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextBoolean(), sc.nextInt());
            } else if (ch == 4) {
                System.out.print("Enter Book ID to remove: ");
                lib.removeById(sc.nextInt());
            } else if (ch == 5) {
                System.out.print("Enter book title: ");
                lib.searchByTitle(sc.next());
            } else if (ch == 6) {
                System.out.print("Enter author name: ");
                lib.searchByAuthor(sc.next());
            } else if (ch == 7) {
                System.out.print("Enter book ID and new availability (true/false): ");
                lib.updateAvailability(sc.nextInt(), sc.nextBoolean());
            } else if (ch == 8) {
                lib.displayForward();
            } else if (ch == 9) {
                lib.displayReverse();
            } else if (ch == 10) {
                lib.countBooks();
            }
        }
    }
}
