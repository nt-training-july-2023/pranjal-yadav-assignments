package Operators;

import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int height, base;

        System.out.println("Enter height of triangle");
        height= sc.nextInt();

        System.out.println("Enter base of triangle");
        base = sc.nextInt();

        double area = (double) 0.5*height * base;
        System.out.println("Area of triangle is: " + area);
    }
}
