import java.util.Scanner;
public class MultiplesBelow100{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a number: ");
        int number = sc.nextInt();
        if (number <= 0 || number >= 100) {
            System.out.println("invalid input.");
            return;
        }
        int counter = number - 1;
        while (counter > 1) {
            if (counter % number == 0) {
                System.out.println(counter);
            }
            counter--;
        }
    }
}