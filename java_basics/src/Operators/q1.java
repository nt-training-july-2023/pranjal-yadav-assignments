package Operators;

import java.io.PrintStream;
import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter any 2 integers");

        int a= sc.nextInt();
        int b= sc.nextInt();

        System.out.println("Adding the numbers: " + add(a,b));
        System.out.println("Subtracting the numbers: " + sub(a,b));
        System.out.println("Multiplying the numbers: " + multiply(a,b));
        System.out.println("Dividing the numbers: " + divide(a,b));
        System.out.println("Modulus of numbers: " + mod(a,b));



    }
    static int add(int a, int b){
        return a+b;
    }

    static int sub (int a, int b){
        return a-b;
    }

    static int multiply(int a, int b){
        return a*b;
    }

    static double divide(int a, int b){
        return (double) a/b;
    }

    static int mod(int a , int b){
        return a%b;
    }
}
