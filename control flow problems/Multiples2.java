import java.util.Scanner;
public class Multiples2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a number: ");
        int number = sc.nextInt();
        if (number <= 0 || number >= 100) {
            System.out.println("invalid input");
            return;
        }
        for (int i=100;i>=1;i--) {
            if (i % number == 0) System.out.println(i);
        }
    }
}