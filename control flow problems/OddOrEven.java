import java.util.Scanner;
public class OddOrEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a natural number: ");
        int n=sc.nextInt();
        if (n<=0) {
            System.out.println("not a natural number.");
            return;
        }
        for (int i=1; i<=n;i++) {
            if (i%2==0) System.out.println(i + " is even");
            else System.out.println(i+" is odd");
        }
    }
}