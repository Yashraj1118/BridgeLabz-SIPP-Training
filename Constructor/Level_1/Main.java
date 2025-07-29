package Level_1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		//1. Book class with default and parameterized.
		System.out.print("Enter the Book Title: ");
		String title=sc.nextLine();
		System.out.print("Enter the Author name: ");
		String author=sc.nextLine();
		System.out.print("Enter the Book price: ");
		double price=sc.nextDouble();
		
		Book b=new Book(title,author,price);
		b.Display();
		
		// 2. Circle class with constructor chaining
		System.out.print("Enter the radius : ");
		double radius = sc.nextDouble();
        Circle defaultCircle = new Circle();
        Circle customCircle = new Circle(radius);
        defaultCircle.displayArea();
        customCircle.displayArea();
        
        System.out.println();
        
     // 3. Person class with copy constructor
        System.out.print("Enter person name: ");
        String name=sc.nextLine();
        System.out.print("Enter person age : ");
        int age=sc.nextInt();
        Person p1 = new Person(name,age);
        Person p2 = new Person(p1); // copy
        p1.display();
        p2.display();

        System.out.println();
        
        // 4. HotelBooking with all constructors
        System.out.print("Enter Guest name: ");
		String guestname=sc.nextLine();
		System.out.print("Enter room type: ");
		String roomtype=sc.nextLine();
		System.out.print("Enter nights: ");
		int nights=sc.nextInt();
        HotelBooking booking1 = new HotelBooking(); // default
        HotelBooking booking2 = new HotelBooking(guestname,roomtype,nights); // parameterized
        HotelBooking booking3 = new HotelBooking(booking2); // copy

        booking1.display();
        booking2.display();
        booking3.display();

        System.out.println();
        
        // 5. Book class and borrow method
        LibraryBook b1 = new LibraryBook("Bhagavad Gita", "Ved Vyas", 299.99, true);
        b1.display();
        b1.borrow();  // borrow once
        b1.borrow();  // try borrowing again
        
        System.out.println();
     // 6. CarRental and cost calculation
        
        CarRental rental = new CarRental("Ram", "Swift", 4);
        rental.calculateTotalCost();
        
        
	}
}
