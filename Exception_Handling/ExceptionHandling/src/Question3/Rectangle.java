package Question3;

import java.util.Scanner;

public class Rectangle {
    int length;
    int width;

    void calc_area(Rectangle r){
        int area = r.length*r.width;
        System.out.println("Area of rectangle is " + area);
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Rectangle r= new Rectangle();

        System.out.println("Enter length: ");
        r.length= sc.nextInt();
        System.out.println("Enter width: ");
        r.width= sc.nextInt();

        try{
            if(r.length<0 || r.width<0){
                throw new InvalidDimensionException("Length or width smaller than zero");
            }else {
                r.calc_area(r);
            }
        }catch (InvalidDimensionException e){
            System.out.println(e);
        }
    }
}
