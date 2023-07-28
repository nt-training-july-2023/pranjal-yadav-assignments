package Question1;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class is used to calculate the area of a triangle
 * @author Pranjal
 */

public class Triangle {

    /**
     * This is program to calculate area of a triangle with given height and base
     * @param height
     * @param base
     * @return ans
     */
    public static double calc_area(double height, double base){
        /**
         * multiplying product of height and base with 0.5
         */
        double ans= (0.5) * height *base;
        return ans;
    }
    /**
     * This is main class
     * @param args
     */
    public static void main(String[] args) throws IOException {

        Scanner sc= new Scanner(System.in);

        /**
         * Taking height and base input from user
         */
        System.out.println("Enter height ");
        double height = sc.nextDouble();

        System.out.println("Enter base ");
        double base = sc.nextDouble();

        /**
         * Calling calc_area function
         */
        double area= calc_area(height, base);

        /**
         * Printing result
         */
        System.out.println("The area of triangle is " + area);
    }
}

