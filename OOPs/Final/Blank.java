package Final;


import java.util.Enumeration;

//blank final variables are left undeclared and are later initialised in the constructors only
//THEY CANNOT BE INITIALISED INSIDE ANY OTHER METHOD WHATSOEVER
public class Blank {
    final int num;

    public Blank(int num) {
        this.num = num;
    }

    public static void main(String[] args) {
        Blank b= new Blank(10);
        System.out.println(b.num);
    }


}
