import java.util.Scanner;
public class SumOfNNatural{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("enter a natural number:");
        int n=sc.nextInt();
        if (n<=0){
            System.out.println(n+" is not a natural number");
            return;
        }
        int sum=0,i=1;
        while (i<=n){
            sum+=i;
            i++;
        }
        int formulaSum=n*(n+1)/2;
        System.out.println("sum using while loop: "+sum);
        System.out.println("sum using formula: "+formulaSum);
    }
}