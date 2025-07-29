package Level_1;

public class HotelBooking {
	String guestName;
    String roomType;
    int nights;

    // Default constructor
    HotelBooking() {
        this("Guest", "Standard", 1);
    }

    // Parameterized constructor
    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy constructor
    HotelBooking(HotelBooking other) {
        this(other.guestName, other.roomType, other.nights);
    }

    void display() {
        System.out.println(guestName + " | " + roomType + " | Nights: " + nights);
    }
}
