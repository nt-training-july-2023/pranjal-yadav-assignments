package Loops;

import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number  : ");
        int n= sc.nextInt();
        int num=n;
        int sum=0;
        while(n>0){
            int rem= n%10;
            n=n/10;
            sum+= rem*rem*rem;
        }
        if(sum==num){
            System.out.println("Armstrong number");
        }
        else {
            System.out.println("Not an armstrong number");
        }
    }
}
