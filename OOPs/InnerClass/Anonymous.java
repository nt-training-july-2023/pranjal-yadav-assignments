package InnerClass;

class P{
    void show(){
        System.out.println("Inside class p");
    }
    void hello(){

    }
}
public class Anonymous {
    public static void main(String[] args) {
        P p = new P(){
            void show(){
                System.out.println("Inside anonymous declaration");
            }
            void hello(){
                System.out.println("Inside hello method");
            }
        };
        p.show();
        p.hello();

        P q= new P(){
            @Override
            void hello() {
                super.hello();
                System.out.println("Overriden by second object");
            }
        };
        q.hello();

    }


}
