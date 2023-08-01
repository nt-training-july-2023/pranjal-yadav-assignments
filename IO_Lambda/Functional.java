import java.util.Scanner;

interface Shape{
    void area();
}


public class Functional {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        Shape circle = () -> {
            System.out.println("Enter radius");
            int r= sc.nextInt();
            double area_circle = 3.14 * r* r;
            System.out.println("The area of circle is "+ area_circle);
        };

        Shape rectangle = () -> {
            System.out.println("Enter length of rectangle ");
            int l= sc.nextInt();
            System.out.println("Enter width of rectangle ");
            int w= sc.nextInt();
            int area_rectangle= l*w;
            System.out.println("The area of rectangle is " + area_rectangle);
        };

        Shape square = () ->{
            System.out.println("Enter side of square ");
            int side= sc.nextInt();
            int area_square = side * side;
            System.out.println("The area of square is " + area_square);
        };

        Shape cube = () ->{
            System.out.println("Enter side of cube");
            int side= sc.nextInt();
            int area_cube= 6 * side*side;
            System.out.println("Surface area of cube is "+ area_cube);
        };

        Shape sphere = () -> {
            System.out.println("Enter radius of sphere ");
            int radius= sc.nextInt();
            double area_sphere = 4 * 3.14 * radius * radius;
            System.out.println("Surface area of sphere is " + area_sphere);
        };

        Shape cylinder = () -> {
            System.out.println("Enter radius of cylinder ");
            int radius = sc.nextInt();
            System.out.println("Enter height of cylinder ");
            int height = sc.nextInt();
            //2πrh+2πr2
            double area_cylinder = (2 * 3.14 * radius * height)+ (2 *3.14 *radius*radius);
            System.out.println("Surface area of cylinder is " + area_cylinder);
        };

        circle.area();
        square.area();
        rectangle.area();
        cube.area();
        cylinder.area();
        sphere.area();

    }
}
