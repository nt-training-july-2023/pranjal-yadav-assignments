package Inheritance;


class Animal1{
    void eats(){
        System.out.println("Animal eats");
    }
}

class Feline extends Animal1{
    void identify(){
        System.out.println("I'm a feline");
    }
}

class Cat extends Feline{
    void meows(){
        System.out.println("Cat meows");
    }

}

public class Multilevel {
    public static void main(String[] args) {
        Animal1 a = new Animal1();
        Feline f= new Feline();
        Cat c= new Cat();
        a.eats();
        f.identify();

        c.eats();
        c.identify();
        c.meows();
    }
}
