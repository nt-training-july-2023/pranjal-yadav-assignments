package Variables;

import java.util.Scanner;

public class q4 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("For the equation   ax2 + bx + c input");

        //taking values of a, b, c
        System.out.println("the value of a: ");
        int a= sc.nextInt();
        System.out.println("the value of b: ");
        int b= sc.nextInt();
        System.out.println("the value of c: ");
        int c= sc.nextInt();

        double discriminant= Math.sqrt ((b*b) - 4*a*c);

        double ans1 =  (-b + discriminant)/2.0*a*c;
//        double ans2 =  (-b - discriminant)/2.0*a*c;
        System.out.println("The roots of the equation "+a+"x2 +"+b+"x +"+c + "  are");
        System.out.println(ans1 + " and ");

    }
}
