package Question1;

import java.util.Scanner;

/**This class calculates area of a square
 * @author Pranjal
 */
public class Square {
    /**
     * This method calcultes the area of the square
     * @param a Length of a side of square
     * @return Return area of square
     */
    public static int calc_area(int a){
        /**
         * multiplying product of height and base with 0.5
         */
        int area = a*a;
        return area;
    }

    /**
     * This is main method
     * @param args
     *
     */
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        /**
         * Taking length of side input from user
         */
        System.out.println("Enter length of side of square ");
        int side= sc.nextInt();

        int area= calc_area(side);

        /**
         * Printing area of square
         */
        System.out.println("Area of square is " + area);
    }
}
