package Arrays;

import java.util.Arrays;

public class Matrices {
    public static void main(String[] args) {
        int[][] a= { { 1, 1, 1, 1 },
                { 2, 2, 2, 2 },
                { 3, 3, 3, 3 },
                { 4, 4, 4, 4 } };
        int b[][]= { { 1, 1, 1, 1 },
                { 2, 2, 2, 2 },
                { 3, 3, 3, 3 },
                { 4, 4, 4, 4 } };

        int[][] sum= new int[4][4];
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                sum[i][j] = a[i][j]+ b[i][j];
            }
        }

        for(int[] row: sum){
            System.out.println(Arrays.toString(row));
        }

    }
}
