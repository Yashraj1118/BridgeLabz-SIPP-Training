package Level_1;

public class LibraryBook {
	 String title;
	    String author;
	    double price;
	    boolean availability;

	    LibraryBook(String title, String author, double price, boolean availability) {
	        this.title = title;
	        this.author = author;
	        this.price = price;
	        this.availability = availability;
	    }

	    void borrow() {
	        if (availability) {
	            availability = false;
	            System.out.println("Book borrowed successfully.");
	        } else {
	            System.out.println("Book not available.");
	        }
	    }

	    void display() {
	        System.out.println(title + " by " + author + " - ₹" + price + " | Available: " + availability);
	    }
}
