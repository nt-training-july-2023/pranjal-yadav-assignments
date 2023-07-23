package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Largest {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter length of array: ");
        int n= sc.nextInt();
        int[] nums= new int[n];
        int larg=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
            if(nums[i]> larg){
                larg = nums[i];
            }
        }

        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Largest number: " + larg);

    }
}
