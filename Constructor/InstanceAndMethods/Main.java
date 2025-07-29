package InstanceAndMethods;

public class Main {
	 public static void main(String[] args) {
	
	// 1.product inventory
	 Product p1 = new Product("Laptop", 50000);
	 Product p2 = new Product("Mobile", 20000);

	 p1.displayProductDetails();
	 p2.displayProductDetails();

	 Product.displayTotalProducts();
	    
	 
	 // 2.online course management
	 Course c1 = new Course("Java", 3, 15000);
     Course c2 = new Course("Python", 2, 12000);

     c1.displayCourseDetails();
     c2.displayCourseDetails();

     Course.updateInstituteName("XYZ Academy");

     c1.displayCourseDetails();
     c2.displayCourseDetails();
     
     // 3. Vehicle Registration
     Vehicle v1 = new Vehicle("Amit", "Car");
     Vehicle v2 = new Vehicle("Rina", "Bike");

     v1.displayVehicleDetails();
     v2.displayVehicleDetails();

     Vehicle.updateRegistrationFee(6000);

     v1.displayVehicleDetails();
	 }
}
