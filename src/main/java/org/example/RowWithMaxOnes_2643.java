package org.example;

import java.util.Arrays;

/**
 * Given a binary matrix (containing only 0 and 1) of order NxN. All rows are sorted already, We need to find the row number with the maximum number of 1s. Also, find the number of 1s in that row.
 * Note:
 *
 * 1. In case of a tie, print the smaller row number.
 * 2. Row number should start from 0th index.
 *
 * Example 1
 *
 * Input:
 * N=3
 * mat[3][3] = {0, 0, 1,
 *               0, 1, 1,
 *               0, 0, 0}
 * Output:
 * Row number = 1
 * MaxCount = 2
 * Explanation:
 * Here, max number of 1s is in row number 1
 * and its count is 2.
 * Example 2
 *
 * Input:
 * N=3
 * mat[3][3] = {1, 1, 1,
 *               1, 1, 1,
 *               0, 0, 0}
 * Output:
 * Row number = 0
 * MaxCount = 3
 * Your Task:
 * You don't need to read input or print anything. The task is to complete the function findMaxRow() which takes mat[][] as the 2D matrix and N as the size of matrix. Your task is to find the row number with the maximum number of 1s and find the number of 1s in that row and return the answer in a vector of size 2 where at 0th index will be the row number and at 1th index will be MaxCount.
 *
 * Expected Time Complexity: O(N)
 * Expected Auxiliary Space: O(1)
 *
 * Constraints:
 * 1 <= N <= 103
 * 0 <= mat[][]<= 1
 */
public class RowWithMaxOnes_2643 {
    public static int[] rowAndMaximumOnes(int[][] mat, int N) {
        int[] res = new int[2];
        for(int i = 0; i < N; i++) {
            int currCount = getCount(mat[i], N);
            if(currCount > res[1]) {
                res[0] = i;
                res[1] = currCount;
            }
        }
        return res;
    }

    private static int getCount(int[] mat, int N) {
        int l = 0;
        int r = N;
        while(l < r) {
            int mid = l + (r - l)/2;
            if(mat[mid] == 1) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return N - l;
    }

    public static void main(String[] args) {
        int [][] array1 = {{0, 0, 1}, {0, 1, 1}, {0, 0, 0}};
        int [] res = rowAndMaximumOnes(array1, 3);
        System.out.println(Arrays.toString(res));

        int [][] array2 = {{1, 1, 1}, {1, 1, 1}, {0, 0, 0}};
        int [] res2 = rowAndMaximumOnes(array2, 3);
        System.out.println(Arrays.toString(res2));
    }
}
