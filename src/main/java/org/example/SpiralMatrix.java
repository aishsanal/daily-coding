package org.example;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    /*
        Given an m x n matrix, return all elements of the matrix in spiral order.

        Example 1:

        Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
        Output: [1,2,3,6,9,8,7,4,5]

        Example 2:

        Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        Output: [1,2,3,4,8,12,11,10,9,5,6,7]


        Constraints:

        m == matrix.length
        n == matrix[i].length
        1 <= m, n <= 10
        -100 <= matrix[i][j] <= 100
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        int k=0;
        int p=0;
        int i=0;
        int j=0;
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList();
        int count=0;
        while(count<m*n){
            for(j=k;j<=n-1-k&&count<m*n;j++){
                result.add(matrix[i][j]);
                count++;
            }
            k++;
            j--;
            for(i=k; i<=m-1-p&&count<m*n;i++){
                result.add(matrix[i][j]);
                count++;
            }
            i--;
            for(j=n-1-k;j>=p&&count<m*n;j--){
                result.add(matrix[i][j]);
                count++;
            }
            p++;
            j++;
            for(i = m-1-p; i >= p&&count<m*n; i--){
                result.add(matrix[i][j]);
                count++;
            }
            i++;
        }
        return result;
    }
    public static void main(String[] args) {
        int array1[][] = {{1,2,3}, {4,5,6}, {7,8,9}};

        List<Integer> result1 = spiralOrder(array1);

        for (Integer integer : result1) System.out.print(integer + " ");

        System.out.println();

        int array2[][] = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};

        List<Integer> result2 = spiralOrder(array2);

        for (Integer integer : result2) System.out.print(integer + " ");
    }
}
