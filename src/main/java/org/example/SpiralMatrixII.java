package org.example;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixII {
    /*
        Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.



        Example 1:


        Input: n = 3
        Output: [[1,2,3],[8,9,4],[7,6,5]]
        Example 2:

        Input: n = 1
        Output: [[1]]


        Constraints:

        1 <= n <= 20
     */
    public static int[][] generateMatrix(int n) {
        int row_start=0;
        int col_start=0;
        int end=n-1;
        int[][] result = new int[n][n];
        int count=1;
        int i;
        int j;

        while(count <= n*n){
            for(j=col_start; j<=end ;j++){
                result[row_start][j] = count;
                count++;
            }
            for(i=row_start+1; i<=end; i++){
                result[i][end] = count;
                count++;
            }
            for(j=end-1;j>= col_start;j--){
                result[end][j] = count;
                count++;
            }
            for(i = end-1; i > row_start; i--){
                result[i][col_start] = count;
                count++;
            }

            row_start++;
            col_start++;
            end--;

            if (count > n*n)
                break;
        }
        return result;
    }
    public static void main(String[] args) {
        int n= 3;
        int[][] result1 = generateMatrix(3);

        for (int i=0; i<n; i++) {
            for (int j = 0; j< n; j++)
                System.out.println(result1[i][j] + " ");
            System.out.println();
        }

        System.out.println();

        n=1;
        int[][] result2 = generateMatrix(1);

        for (int i=0; i<n; i++) {
            for (int j = 0; j< n; j++)
                System.out.println(result2[i][j] + " ");
            System.out.println();
        }
    }
}
