import java.util.Scanner;


interface Replace{
    void replace_vowels(String s);
}
public class Vowels {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter String");
        String s= sc.nextLine();

        Replace r=(String str)->{
            str = str.replaceAll("[aeiou]", "#" );
            System.out.println(str);
        };

        r.replace_vowels(s);
    }
}
