import java.util.Scanner;
public class FactorsOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a positive integer: ");
        int number = sc.nextInt();
        int counter = 1;
        while (counter < number) {
            if (number % counter == 0){
                System.out.println(counter);
            }
            counter++;
        }
    }
}