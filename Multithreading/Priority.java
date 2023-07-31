class Thread7 extends Thread{
    public void run(){
        System.out.println("Thread is running");
    }
}

public class Priority {
    public static void main(String[] args) {
        Thread7 t1= new Thread7();
        Thread7 t2= new Thread7();
        Thread7 t3= new Thread7();

//        t1.start();
//        t2.start();
//        t3.start();

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        System.out.println(t3.getPriority());

        t1.setPriority(1);
        t2.setPriority(6);
        t3.setPriority(9);

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        System.out.println(t3.getPriority());
    }
}
