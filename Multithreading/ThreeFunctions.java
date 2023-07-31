class Sum extends Thread{
    static int sum=0;
    public void run(){
        try {
            int sum=0;
            for(int i=0; i<10; i++){
                Thread.sleep(1000);
                sum+=i;
                System.out.println(sum);
            }
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

    }
}

class Reverse extends Thread{
    public void run(){
        for(int i=9; i>=0; i--){
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
                System.out.println(e);
            }
            System.out.println(i);
        }
    }
}

class Fibo extends Thread{
    public void run(){
        int p1=0;
        int p2=1;

        for(int i=0; i<9; i++){
            int p3= p1+p2;
            System.out.println(p3);
            p1=p2;
            p2=p3;
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }
}

public class ThreeFunctions {
    public static void main(String[] args) {
        Sum s = new Sum();
        s.start();

        Reverse r= new Reverse();
        r.start();

        Fibo f= new Fibo();
        f.start();
    }
}
