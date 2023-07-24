package Inheritance;


class Animal2{
    void eats(){
        System.out.println("Animal eats");
    }
}

class Cat1 extends Animal2{
    void meows(){
        System.out.println("Cat  meows");
    }
}

class Do2g extends Animal2{
    void barks(){
        System.out.println("Dog barks");
    }
}

public class Hierarchical {
    public static void main(String[] args) {
        Cat1 c= new Cat1();
        Do2g d= new Do2g();

        c.meows();
        d.barks();

        c.eats();
        d.eats();
    }
}
