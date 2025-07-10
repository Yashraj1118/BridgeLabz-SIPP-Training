package circularlinkedlist.ticketreservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();
        Scanner sc = new Scanner(System.in);
        int ch;

        while (true) {
            System.out.println("1 Book Ticket");
            System.out.println("2 Cancel Ticket by ID");
            System.out.println("3 Show All Tickets");
            System.out.println("4 Search by Customer Name");
            System.out.println("5 Search by Movie Name");
            System.out.println("6 Total Booked Tickets");
            System.out.println("0 Exit");
            ch = sc.nextInt();

            if (ch == 0) break;

            if (ch == 1) {
                System.out.print("Enter Ticket ID, Customer Name, Movie Name, Seat Number, Booking Time: ");
                int id = sc.nextInt();
                String customer = sc.next();
                String movie = sc.next();
                String seat = sc.next();
                String time = sc.next();
                system.addTicket(id, customer, movie, seat, time);
            } else if (ch == 2) {
                System.out.print("Enter Ticket ID to cancel: ");
                system.removeTicket(sc.nextInt());
            } else if (ch == 3) {
                system.displayTickets();
            } else if (ch == 4) {
                System.out.print("Enter Customer Name: ");
                system.searchByCustomer(sc.next());
            } else if (ch == 5) {
                System.out.print("Enter Movie Name: ");
                system.searchByMovie(sc.next());
            } else if (ch == 6) {
                system.totalTickets();
            }
        }
    }
}
