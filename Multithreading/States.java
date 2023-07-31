class Thread5 extends Thread{
    public void run(){
        System.out.println("Thread is running");
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            System.out.println(e);
        }

    }
}

public class States {
    public static void main(String[] args) {
        Thread5 t1= new Thread5();

        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());
        try {
            t1.join();
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println(t1.getState());

        Thread t= new Thread(){
            public void run(){
                try{
                    Thread.sleep(10000);
                }catch (InterruptedException e){
                    System.out.println(e);
                }
            }
        };

        t.start();
        System.out.println(t.getState());
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){
            System.out.println(e);
        }

        System.out.println(t.getState());


    }
}