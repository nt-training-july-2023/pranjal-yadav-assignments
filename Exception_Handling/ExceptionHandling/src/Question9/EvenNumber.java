package Question9;

import java.lang.reflect.Type;
import java.util.Scanner;


public class EvenNumber {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter an even number ");
        int num = sc.nextInt();
        try {
            if(num%2 == 0){
                System.out.println("The number you entered is even.");
            }else {
                throw new NotEvenNumberException("The number you entered is odd. Please enter an even number");
            }
        }catch (NotEvenNumberException e){
            System.out.println(e);
        }
    }
}
