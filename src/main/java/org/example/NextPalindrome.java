package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

/*
    Given a number, in the form of an array Num[] of size N containing digits from 1 to 9(inclusive). The task is to find the next smallest palindrome strictly larger than the given number.

    Example 1:

    Input:
    N = 11
    Num[] = {9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2}
    Output: 9 4 1 8 8 0 8 8 1 4 9
    Explanation: Next smallest palindrome is
    9 4 1 8 8 0 8 8 1 4 9
    Example 2:

    Input:
    N = 5
    Num[] = {2, 3, 5, 4, 5}
    Output: 2 3 6 3 2
    Explanation: Next smallest palindrome is
    2 3 6 3 2
    Your Task:
    Complete the function generateNextPalindrome() which takes an array num, and a single integer n, as input parameters and returns an array of integers denoting the answer. You don't have to print answers or take inputs.

    Expected Time Complexity: O(N)
    Expected Auxiliary Space: O(1)

    Constraints:
    1 <= N <= 105
    1 <= Num[i] <= 9
 */
public class NextPalindrome {
    public static Vector<Integer> generateNextPalindrome(int num[], int n) {
        Vector<Integer> result = new Vector<>(n);
        boolean allElementsAre9 = Arrays.stream(num).allMatch(x -> x == 9);
        if (allElementsAre9) {
            //All elements are 9
            Collections.fill(result, 0);
            result.add(0, 1);
            result.add(1);
            return result;
        }

        if (n % 2 == 0) {
            //Even number of digits
            int rightMid = n / 2;
            int leftMid = rightMid - 1;
            if (num[leftMid] <= num[rightMid]) {
                num[leftMid]++;
            }
            for (int i = 0; i <= leftMid; i++) {
                result.add(num[i]);
            }
            for (int j = leftMid; j>=0 ; j--) {
                result.add(num[j]);
            }
            return result;
        } else {
            int mid = n / 2;
            int leftMid = mid - 1;
            int rightMid = mid + 1;
            while (num[leftMid] == num[rightMid] && rightMid < n) {
                leftMid--;
                rightMid++;
            }
            if (rightMid >= n || num[leftMid] < num[rightMid]) {
                if (num[mid] == 9) {
                    for (int i = mid; i >= 0; i--) {
                        if (num[i] == 9) {
                            num[i] = 0;
                        } else {
                            num[i]++;
                            break;
                        }
                    }
                } else {
                    num[mid]++;
                }
            }
            for (int i = 0; i < mid; i++) {
                result.add(num[i]);
            }
            for (int i = mid; i >= 0; i--) {
                result.add(num[i]);
            }
            return result;
        }
    }

    public static void main(String[] args)
    {
        int num1[] = {9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2};
        System.out.println("Input = " + Arrays.toString(num1));
        System.out.println("Output = " + generateNextPalindrome(num1, num1.length));
        System.out.println();

//        int num2[] = {3, 2, 1};
//        System.out.println("Input = " + Arrays.toString(num2));
//        System.out.println("Output = " + generateNextPalindrome(num2, num2.length));
//        System.out.println();
//
//        int num3[] = {2, 1, 8, 7, 6, 5};
//        System.out.println("Input = " + Arrays.toString(num3));
//        System.out.println("Output = " + generateNextPalindrome(num3, num3.length));
//        System.out.println();
    }

}
