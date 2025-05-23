package org.example;

import java.util.ArrayList;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * Example 2:
 *
 *
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 *
 * Constraints:
 *
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 */
public class Rotate2DArray {
    public static void rotate(int[][] matrix) {
        int n = matrix[0].length;
        for (int k= 0; k < n/2; k++) {
            for (int j = k; j<n-1-k; j++) {
                int i = k;
                int temp1 = matrix[j][n-1-k];
                matrix[j][n-1-k] = matrix[i][j];
                int temp2 = matrix[n-1-k][n-1-j];
                matrix[n-1-k][n-1-j] = temp1;
                temp1 = matrix[n-1-j][k];
                matrix[n-1-j][k] = temp2;
                matrix[i][j] = temp1;
            }
        }
    }

    public static void main(String[] args) {
        int [][] array1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(array1);
        for (int[] ints : array1) {
            for (int j = 0; j < array1[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
