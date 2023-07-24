package Static;

public class StaticToNonStatic {
    int normalInt=20;
    static int staticInt=30;
    void normalMethod(){
        int a=10;
        System.out.println("Inside normal method");
        normalInt=50;
    }
    static void staticMethod(){
//        normalInt=40;
//        cannot be done
        staticInt=40;
        System.out.println(staticInt);
    }
    public static void main(String[] args) {
        StaticToNonStatic st= new StaticToNonStatic();
        st.normalMethod();
        StaticToNonStatic.staticMethod();
    }
}


//cannot access non static attributes from static methods