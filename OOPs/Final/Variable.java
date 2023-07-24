package Final;

public class Variable {
    static final double gravity= 9.8;


    static double initial_velocity= 10;

    public static void main(String[] args) {
        int time= 10;
        double ans= initial_velocity + (gravity*time);
        System.out.println("The final velocity after " +time + " seconds is "+ ans);
    }

}
