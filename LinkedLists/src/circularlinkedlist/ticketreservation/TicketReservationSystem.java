package circularlinkedlist.ticketreservation;

public class TicketReservationSystem {
    public Ticket head = null;
    public Ticket tail = null;

    public void addTicket(int id, String customer, String movie, String seat, String time) {
        Ticket t = new Ticket(id, customer, movie, seat, time);
        if (head == null) {
            head = tail = t;
            t.next = t;
        } else {
            tail.next = t;
            t.next = head;
            tail = t;
        }
    }

    public void removeTicket(int id) {
        if (head == null) return;

        Ticket curr = head;
        Ticket prev = tail;

        do {
            if (curr.ticketId == id) {
                if (curr == head && curr == tail) {
                    head = tail = null;
                } else if (curr == head) {
                    head = head.next;
                    tail.next = head;
                } else if (curr == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = curr.next;
                }
                System.out.println("Ticket " + id + " cancelled");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Ticket not found");
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }

        Ticket temp = head;
        do {
            System.out.println(temp.ticketId + " | " + temp.customerName + " | " + temp.movieName + " | " + temp.seatNumber + " | " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByCustomer(String customerName) {
        if (head == null) {
            System.out.println("No tickets available");
            return;
        }

        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(customerName)) {
                System.out.println(temp.ticketId + " | " + temp.movieName + " | " + temp.seatNumber + " | " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) System.out.println("No ticket found for " + customerName);
    }

    public void searchByMovie(String movieName) {
        if (head == null) {
            System.out.println("No tickets available");
            return;
        }

        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.movieName.equalsIgnoreCase(movieName)) {
                System.out.println(temp.ticketId + " | " + temp.customerName + " | " + temp.seatNumber + " | " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) System.out.println("No tickets found for movie " + movieName);
    }

    public void totalTickets() {
        int count = 0;
        if (head == null) {
            System.out.println("Total tickets booked: 0");
            return;
        }

        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Total tickets booked: " + count);
    }
}
