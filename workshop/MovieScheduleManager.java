import java.util.*;

class InvalidTimeFormatException extends Exception{
    public InvalidTimeFormatException(String message){
        super(message);
    }
}
public class MovieScheduleManager {
    static Map<String,Set<String>> movies=new HashMap<>();

    static Scanner sc=new Scanner(System.in);

    static void addMovies(String title,String time) throws InvalidTimeFormatException{
        if(!isValidTimeFormat(time)){
            throw new InvalidTimeFormatException("Time format should be in HH:MM eg (10:25)");
        }
        if(!movies.containsKey(title.toUpperCase())) {
            movies.put(title.toUpperCase(), new HashSet<>());
        }
        movies.get(title.toUpperCase()).add(time);
        System.out.println("Movies Added Successfully!");
    }
    static boolean isValidTimeFormat(String time){
        if (!time.matches("\\d{2}:\\d{2}")) return false;

        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int min = Integer.parseInt(parts[1]);
        return hour >= 0 && hour <= 23 && min >= 0 && min <= 59;
    }
    static void searchMovies(String title){
        if(!movies.containsKey(title)){
            System.out.println("No matching movie Found!");
            return;
        }
        System.out.println("Movie found : " +title);
        System.out.println("Its avilable shows are : ");
        for(String time:movies.get(title)){
            System.out.print(time+" | ");
        }
    }
    static void displayAllMovies(){
        if(movies.isEmpty()){
            System.out.println("No Movie is Scheduled! please schedule a movie");
            return;
        }
        for(String title :movies.keySet()){
            System.out.println("Movie Title is : "+title);
//            System.out.println("Avilable Shows:");
//            for(String time:movies.get(title)){
//                System.out.print(time+" | ");
//            }
        }
    }

    static void generateReport() {
        if (movies.isEmpty()) {
            System.out.println("No movies to report.");
            return;
        }

        System.out.println("\n--- Movie Schedule Report ---");
        String[] titles = movies.keySet().toArray(new String[0]);
        for (String title : titles) {
            Set<String> times = movies.get(title);
            String[] timeArray = times.toArray(new String[0]);
            System.out.println("Movie: " + title);
            System.out.println("Showtimes: " + Arrays.toString(timeArray));
        }
    }

    public static void main(String args[]){
        int choice;
        do{
            System.out.println("\n--- CinemaTime: Movie Schedule Manager ---");
            System.out.println("1. Add Movie");
            System.out.println("2. Search Movie");
            System.out.println("3. Display All Movies");
            System.out.println("4. Generate Report (Array Output)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter movie title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter showtime (HH:MM): ");
                        String time = sc.nextLine();
                        addMovies(title, time);
                        break;

                    case 2:
                        System.out.print("Enter keyword to search: ");
                        String keyword = sc.nextLine();
                        searchMovies(keyword);
                        break;

                    case 3:
                        displayAllMovies();
                        break;

                    case 4:
                        generateReport();
                        break;

                    case 5:
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } catch (InvalidTimeFormatException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error: Invalid movie index accessed.");
            } catch (Exception e) {
                System.out.println("Unexpected Error: " + e.getMessage());
            }
        }while(choice!=5);
    }
}
