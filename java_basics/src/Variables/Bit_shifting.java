package Variables;

public class Bit_shifting {
    public static void main(String[] args) {
        byte a = 64, b;
        int i;

        i = a << 2;
        b = (byte)(a << 2);
        System.out.println("Original value of a: " + a);
        System.out.println("i and b: " + i + " " + b);

        //LEFT SHIFT (SIGNED)
        int number = -2; System.out.println(number);
        System.out.println("Before shift : " + Integer.toBinaryString(number)); number = number >> 1; //shifting 1 right bit System.out.println(number); System.out.println("After shift : " + Integer.toBinaryString(number));

       // Read more: https://javarevisited.blogspot.com/2015/02/difference-between-right-shift-and.html#ixzz884dCvtKo
    }
}
