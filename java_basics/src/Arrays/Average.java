package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter length of array: ");
        int n= sc.nextInt();
        int[] nums= new int[n];
        int sum= 0;
        System.out.println("Enter numbers: ");
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
            sum+= nums[i];
        }

        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Average: " + sum/n);
    }
}
