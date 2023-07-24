package Final;

final class A{
    static void show(){
        System.out.println("This method is inside final class");
    }
}

//class B extends A{
//
//}
//cannot inherit final class a

public class Class {
    public static void main(String[] args) {
        A.show();
    }
}
