package Strings;

import java.util.Scanner;

public class Length {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter string  : ");
        String str = sc.nextLine();
        //next will take only one string
        //next line will take the entire next line
        int n = str.length();

        System.out.println("The length of string is: " + n);
    }
}
