package Strings;

public class Concat {
    public static void main(String[] args) {
        String s1= "Hello";
        String s2= "-World";
        String s3= s1.concat(s2);
        //new object s3 is created


        String s4= s1+s2;
        //String s4=(new StringBuilder()).append("Hello").append("-World").toString();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
    }
}
