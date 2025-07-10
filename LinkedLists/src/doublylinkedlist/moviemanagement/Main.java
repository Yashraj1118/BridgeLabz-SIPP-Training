package doublylinkedlist.moviemanagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MovieList list = new MovieList();
        Scanner sc = new Scanner(System.in);
        int ch;

        while (true) {
            System.out.println("1 Add at Beginning");
            System.out.println("2 Add at End");
            System.out.println("3 Add at Position");
            System.out.println("4 Remove by Title");
            System.out.println("5 Search by Director");
            System.out.println("6 Search by Rating");
            System.out.println("7 Update Rating");
            System.out.println("8 Display Forward");
            System.out.println("9 Display Reverse");
            System.out.println("0 Exit");
            ch = sc.nextInt();

            if (ch == 0) break;

            if (ch == 1) {
                System.out.print("Enter title, director, year, rating: ");
                list.addAtBeginning(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
            } else if (ch == 2) {
                System.out.print("Enter title, director, year, rating: ");
                list.addAtEnd(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
            } else if (ch == 3) {
                System.out.print("Enter title, director, year, rating, position: ");
                list.addAtPosition(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble(), sc.nextInt());
            } else if (ch == 4) {
                System.out.print("Enter title to remove: ");
                list.removeByTitle(sc.next());
            } else if (ch == 5) {
                System.out.print("Enter director name: ");
                list.searchByDirector(sc.next());
            } else if (ch == 6) {
                System.out.print("Enter rating: ");
                list.searchByRating(sc.nextDouble());
            } else if (ch == 7) {
                System.out.print("Enter title and new rating: ");
                list.updateRating(sc.next(), sc.nextDouble());
            } else if (ch == 8) {
                list.displayForward();
            } else if (ch == 9) {
                list.displayReverse();
            }
        }
    }
}
