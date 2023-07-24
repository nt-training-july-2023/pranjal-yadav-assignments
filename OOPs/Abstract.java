abstract class Parent{
    Parent(){
        System.out.println("This is parent class constructor");
    }

    abstract public void show();
    public void onlyInParent(){
        System.out.println("This method is only present in Parent class");
    }


}
class Child extends Parent{
    Child(){
        System.out.println("This is child class constructor");
    }

    @Override
    public void show() {
        System.out.println("This method is overridden from parent class");
    }

    void onlyInChild(){
        System.out.println("This method is only present in Child class");
    }

}

public class Abstract {
    public static void main(String[] args) {
        Child c= new Child();
        c.onlyInChild();
        c.onlyInParent();
        c.show();
    }
}
