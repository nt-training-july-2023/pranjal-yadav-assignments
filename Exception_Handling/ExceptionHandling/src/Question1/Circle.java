package Question1;

import java.util.Scanner;

/**
 * This class is used to calculate area of a circle
 * @author Pranjal
 */
public class Circle {

    /**
     *
     * @param r Raduis of circle
     * @return area Returns area of Circle
     */
    public static double calc_area(double r){
        double area = 3.14 * r * r;
        return area;
    }

    /**
     * This is the main method
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        /**
         * Taking input from user
         */
        System.out.println("Enter radius of circle: ");
        double radius = sc.nextDouble();
        double area= calc_area(radius);
        /**
         * Printing area of Circle
         */
        System.out.println("The area of circle is " + area);

    }
}
