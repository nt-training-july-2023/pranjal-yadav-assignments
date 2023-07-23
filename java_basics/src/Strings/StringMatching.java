package Strings;

import java.util.Scanner;

public class StringMatching {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter string  : ");
        String str = sc.nextLine();

        System.out.println("Enter character or string to check");
        String match= sc.nextLine();

        if(str.startsWith(match)){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }
}
