package Final;


class Parent{
    final void show(){
        System.out.println("Final Method inside parent class");
    }

    void someRandomMethod(){
        System.out.println("Non final method inside parent class");
    }
}

class Child extends Parent{
    @Override
    void someRandomMethod() {
        super.someRandomMethod();
        System.out.println("Non final method changed in child class");
    }

//    void show(){
//
//    }
//    cannot override final method
}
public class Method {
    public static void main(String[] args) {
        Parent p = new Parent();
        p.show();
        p.someRandomMethod();

        Child c= new Child();
        c.someRandomMethod();
        c.show();
    }
}
