package Strings;

import java.util.Scanner;

public class Character {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter string  : ");
        String str = sc.nextLine();
        System.out.println("Enter postion: ");
        int n= sc.nextInt();
        System.out.println( "Postion at "+n+ " is " +str.charAt(n));
    }
}
