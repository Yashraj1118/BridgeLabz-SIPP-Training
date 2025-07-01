import java.util.*;

public class FlightBookingSystem {
    static class Flight{
        String flightNumber;
        String destinantion;
        Flight(String flightNumber,String destinantion){
            this.flightNumber=flightNumber;
            this.destinantion=destinantion;
        }
        void displayFlight(){
            System.out.println("Flight No: "+flightNumber+" Destination : "+destinantion);
        }
    }
    static class Booking{
        String passengerName;
        String flightNumber;
        Booking(String passengerName,String flightNumber){
            this.flightNumber=flightNumber;
            this.passengerName=passengerName;
        }
        void displayBooking(){
            System.out.println("Passenger : " +passengerName+" \t| Flight No : "+flightNumber);
        }

    }

    static Flight[] flights = {
            new Flight("AI101", "Delhi"),
            new Flight("AI102", "Mumbai"),
            new Flight("AI103", "Bangalore")
    };
    static List<Booking> bookings=new ArrayList<>();
    static Scanner sc=new Scanner(System.in);

    public static void main(String []args){
        int choice;
        do{
            System.out.println("----Flight Booking System----");
            System.out.println("1. View Flights");
            System.out.println("2. Search Flight");
            System.out.println("3. Book Flight");
            System.out.println("4. View Booking");
            System.out.println("5. Exit");
            System.out.print("Enter your choice:");
            choice=sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    viewFlights();
                    break;
                case 2:
                    searchFlight();
                    break;
                case 3:
                    bookFlight();
                    break;
                case 4:
                    viewBookings();
                    break;
                case 5:
                    System.out.println("Thank you for using our system !");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }while (choice!=5);
    }
    static void searchFlight(){
        System.out.println("Enter your destination");
        String destination=sc.nextLine().toLowerCase();
        boolean found=false;
        for(Flight f:flights){
            if(f.destinantion.toLowerCase().equals(destination)){
                f.displayFlight();
                found=true;
            }
        }
        if(!found){
            System.out.println("No Flight Found for :"+destination);
        }
    }
    static void bookFlight(){
        System.out.println("Enter the Flight number :");
        String flightNum=sc.nextLine();
        System.out.println("Enter your Name: ");
        String passangerName=sc.nextLine();
        boolean booked=false;
        for(Flight f:flights){
            if(f.flightNumber.equalsIgnoreCase(flightNum)){
                bookings.add(new Booking(passangerName,f.flightNumber));
                booked=true;
                System.out.println("Flight Booked Successfully!");
                break;
            }
        }
        if(!booked) {
            System.out.println("Sorry No Flight Found");
        }
    }
    static void viewBookings(){
        if(bookings.isEmpty()){
            System.out.println("No Booking Yet!");
            return;
        }
        System.out.println("\n----Your Booking----");
        for(Booking b:bookings){
            b.displayBooking();
        }

    }
    static void viewFlights(){
        for(Flight f:flights){
            f.displayFlight();
        }
    }

}
