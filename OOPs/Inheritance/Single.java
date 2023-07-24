package Inheritance;

class Animal{
    void eats(){
        System.out.println("Animal eats");
    }
}
class Dog extends Animal {
    void barks(){
        System.out.println("Dog barks");
    }
}

public class Single {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.eats();
        Dog d= new Dog();
        d.eats();
        d.barks();
        Animal b= new Dog();
        b.eats();

    }
}
