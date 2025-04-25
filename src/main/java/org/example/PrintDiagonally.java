package org.example;

import java.util.ArrayList;

/*
    Give a N * N square matrix A, return all the elements of its anti-diagonals from top to bottom.

    Example 1:

    Input:
    N = 2
    A = [[1, 2],
         [3, 4]]
    Output:
    1 2 3 4
    Explanation:

    Hence, elements will be returned in the
    order {1, 2, 3, 4}.
    Example 2:

    Input:
    N = 3
    A = [[1, 2, 3],
         [4, 5, 6],
         [7, 8, 9]]
    Output:
    1 2 4 3 5 7 6 8 9
    Explanation:

    Hence, elements will be returned in
    the order {1, 2, 4, 3, 5, 7, 6, 8, 9}.

    Your Task:
    You don't need to read input or print anything. Your task is to complete the function downwardDiagonal() which takes an integer N and a 2D matrix A[ ][ ] as input parameters and returns the list of all elements of its anti-diagonals from top to bottom.

    Expected Time Complexity: O(N*N)
    Expected Auxillary Space: O(N*N)

    Constraints:
    1 ≤ N, M ≤ 103
 */
public class PrintDiagonally {
    static ArrayList<Integer> downwardDiagonal(int N, int A[][])
    {
        ArrayList<Integer> output = new ArrayList();
        int i, j, k;
        for (k=0; k < N; k++) {
            i = 0;
            j = k;
            while (j >= 0) {
                output.add(A[i][j]);
                i++;
                j--;
            }
        }

        for (k=N-1; k >= 1; k--) {
            i = N-k;
            j = N-1;
            while (i < N) {
                output.add(A[i][j]);
                i++;
                j--;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int [][] array1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ArrayList<Integer> op1 = downwardDiagonal(3, array1);
        op1.forEach(System.out::println);

        int [][] array2 = {{1, 2}, {3, 4}};
        ArrayList<Integer> op2 = downwardDiagonal(2, array2);
        op2.forEach(System.out::println);
    }
}
