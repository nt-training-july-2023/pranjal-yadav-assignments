package InnerClass;

class A{
    void display(){
        class Inner{
            void show(){
                System.out.println("Inside method local inner class");
            }
        }
        Inner in= new Inner();
        in.show();
    }
}

public class MethodLocal {
    public static void main(String[] args) {
        A a= new A();
        a.display();
    }

}
