package Loops;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number  : ");
        int n= sc.nextInt();

        int sum = (n*(n+1))/2;
        System.out.println("Sum of first n numbers are: " +sum);
    }
}

