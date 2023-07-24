package Static;

//class A{
//    static {
//        System.out.println("Hello");
//    }
//}

public class Block {

    static {
        System.out.println("First static block");
    }
    static int a=10;
    static {
        System.out.println(a);
        System.out.println("Inside 2nd static block");
    }


    public static void main(String[] args) {
        System.out.println("Inside Main method");
    }
}
