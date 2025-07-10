package circularlinkedlist.ticketreservation;

public class Ticket {
    public int ticketId;
    public String customerName;
    public String movieName;
    public String seatNumber;
    public String bookingTime;

    public Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
    }
}
