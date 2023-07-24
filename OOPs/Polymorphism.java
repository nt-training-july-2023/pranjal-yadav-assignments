
//COMPILE TIME OR OVERLOADING
class Addition{
    static int add(int a, int b){
        return a+b;
    }
    static double add( double a, double b){
        return a+b;
    }
}

class Area{
    static double cal_area(double a, double b){
        return a*b;
    }
}

class Triangle extends Area{
    static double calc_area(double h, double base){
        return 0.5*h*base;
    }
}

class Circle extends Area{
    static double calc_area(int radius){
        return 3.14*radius*radius;
    }
}

public class Polymorphism {

    public static void main(String[] args) {
        System.out.println("Compile time polymorphism or overloading");
        System.out.println(Addition.add(2,3));
        System.out.println(Addition.add(2.0, 8.7));


        System.out.println( "Runtime polymorphism or overriding");
        System.out.println(Triangle.calc_area(4,6));
        System.out.println(Circle.calc_area(4));
    }


}
