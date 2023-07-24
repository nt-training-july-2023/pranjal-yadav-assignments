package Inheritance;

interface Aquatic{
    public void lives_in();
}
interface Terrestrial{
    public void lives_in();
}

class Frog extends Animal implements Terrestrial, Aquatic{

    @Override
    public void lives_in() {
        System.out.println("Lives in both land and water");
    }
}

public class Multiple {
    public static void main(String[] args) {
        Frog f= new Frog();
        f.lives_in();
    }
}
