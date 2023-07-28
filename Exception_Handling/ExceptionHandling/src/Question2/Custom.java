package Question2;

import java.util.Scanner;

public class Custom {
    static double balance=1000;
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        System.out.println("Enter amount to be withdrawn");
        double amount = sc.nextDouble();
        try {
            if(amount<0)  {
                throw new InvalidInputException("Negative amount.");
            }else if (amount> balance){
                throw new InvalidInputException("You do not have enough balance to withdraw this amount.");
            }
            else{
                System.out.println("Withdrawal successful!");
            }
        }catch (InvalidInputException e){
            System.out.println(e);
        }

    }
}
