package InnerClass;

class Out{
    void outerMethod(){
        System.out.println("Outer Method");
    }

    class In{
        void innerMethod(){
            System.out.println("Inner Method");
        }
    }
}

public class Nested {
    public static void main(String[] args) {
        Out.In in = new Out().new In();
        in.innerMethod();

        Out out= new Out();
        out.outerMethod();
    }
}
