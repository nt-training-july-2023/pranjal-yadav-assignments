package Strings;

public class Equals {
    public static void main(String[] args) {
        String s1= "Hello";
        String s2 = "Hello";
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));

        String s3= new String("Hello");
        System.out.println(s1==s3);
        System.out.println(s1.equals(s3));

        String s4 = "World";
        System.out.println(s3.equals(s4));
    }
}
