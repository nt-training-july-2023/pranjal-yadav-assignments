package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Rotate {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter length of array: ");
        int n= sc.nextInt();
        int[] nums= new int[n];
        System.out.println("Enter numbers: ");
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }
        rotate(nums, 2);
        System.out.println("Arrays: " + Arrays.toString(nums));
    }
     static public void rotate(int[] arr, int k) {
        int n = arr.length;
        reverse(arr,0,n-1);
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);

    }
    public static void reverse(int[] arr,int s,int e) {
        while (s < e) {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
}
