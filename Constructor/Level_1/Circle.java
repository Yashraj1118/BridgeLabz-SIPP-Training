package Level_1;

public class Circle {
	 double radius;

	    // Default constructor
	    Circle() {
	        this(1.0); // Calls parameterized constructor
	    }

	    // Parameterized constructor
	    Circle(double radius) {
	        this.radius = radius;
	    }

	    void displayArea() {
	        double area = Math.PI * radius * radius;
	        System.out.println("Area: " + area);
	    }
}
