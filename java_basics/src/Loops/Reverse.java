package Loops;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number  : ");
        int n= sc.nextInt();
        int rem=0;
        int ans=0;
        int i=1;
        while(n>0){
            rem= n%10;
            ans= ans*10 + rem;
            n=n/10;
            i=i*10;
        }
        System.out.println("reverse number is : "+ ans  );
    }
}
