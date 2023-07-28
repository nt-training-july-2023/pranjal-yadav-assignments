package Question7;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        int[] nums= { 1, 2, 4, 5,67, 8, 10, 4, 2, 6,43, 7,87,3 };
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter index you want to access");
        int index= sc.nextInt();
        try {
            if(index<0 || index>= nums.length){
                throw new IndexOutOfBoundsException("Index should be 0 or less than than "+ nums.length);
            } else if (nums==null) {
                throw new NullPointerException();
            }else {
                System.out.println("The number at index "+ index + " is " + nums[index]);
            }
        }catch (NullPointerException e){
            System.out.println(e);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
        }
    }
}
