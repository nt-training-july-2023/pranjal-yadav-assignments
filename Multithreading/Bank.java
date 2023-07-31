import java.util.Arrays;

class Account{
    int balance =2000;
    synchronized void deposit(int amount){
        balance+= amount;
        System.out.println("Current balance is "+ balance);
    }

    synchronized void withdraw(int amount){
        if(amount <= balance ){
            balance-= amount;
        }
        else {
            System.out.println("Not enough balance");
        }
        System.out.println("Current balance: "+ balance);
    }
}
class Person1 extends Thread{
    Account acc;
    Person1(){
        acc= new Account();
    }
    public void run(){
        System.out.println("Person 1 thread is running");
    }
}

class Person2 extends Thread{
    Account acc;
    Person2(){
        acc= new Account();
    }
    public void run(){
        System.out.println("Person2 thread is running");
    }
}

public class Bank {
    public static void main(String[] args) {
        Person1 p1= new Person1();
        Person2 p2= new Person2();

        p1.start();
        p2.start();

        p1.acc.deposit(200);
        p2.acc.deposit(20);

        p1.acc.withdraw(3000);
        p2.acc.withdraw(400);

    }
}
