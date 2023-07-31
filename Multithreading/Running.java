import java.util.Set;

class Thread2 extends Thread{
    public void run(){
        System.out.println("start method is called");
        System.out.println();
    }
}

public class Running {
    public static void main(String[] args) {
        Thread2 t1 = new Thread2();
        Thread2 t2 = new Thread2();
        Thread2 t3 = new Thread2();

        t1.start();
        t2.start();
        t3.start();

        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();

        for(Thread t : threadSet){
            System.out.println(t);
        }
    }
}
