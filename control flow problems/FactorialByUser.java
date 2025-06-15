import java.util.Scanner;
public class FactorialByUser{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a positive integer: ");
        int n = sc.nextInt();
        if (n < 0) {
            System.out.println("Invalid input");
            return;
        }
        long fact = 1;
        int i = 1;
        while (i <= n) {
            fact *= i;
            i++;
        }
        System.out.println("Factorial of " + n + " is " + fact);
    }
}