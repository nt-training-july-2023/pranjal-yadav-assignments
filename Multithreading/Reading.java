class Threads extends Thread{
    public void run(){
        System.out.println("Thread is running. Name of thread: "+ Thread.currentThread().getName());
    }
}

public class Reading {
    public static void main(String[] args) {
        Threads t1 = new Threads();
        Threads t2 = new Threads();
        Threads t3 = new Threads();
        Threads t4 = new Threads();

        t1.start();
        t2.start();
        t3.start();
        t4.start();


    }
}
