package Loops;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number  : ");
        int n= sc.nextInt();

        int rev = reverse(n);

        if(rev==n){
            System.out.println("The number is palindrome");
        }else {
            System.out.println("The number is not palindrome");
        }
    }
    public static int reverse(int n){
        int rem=0;
        int ans=0;
        int i=1;
        while(n>0){
            rem= n%10;
            ans= ans*10 + rem;
            n=n/10;
            i=i*10;
        }
        return ans;
    }
}
