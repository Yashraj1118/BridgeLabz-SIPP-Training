package Level_1;

public class CarRental {
	 String customerName;
	    String carModel;
	    int rentalDays;

	    CarRental(String customerName, String carModel, int rentalDays) {
	        this.customerName = customerName;
	        this.carModel = carModel;
	        this.rentalDays = rentalDays;
	    }

	    void calculateTotalCost() {
	        int ratePerDay = 1000; // Example fixed rate
	        int total = ratePerDay * rentalDays;
	        System.out.println("Total cost for " + customerName + ": ₹" + total);
	    }
}
