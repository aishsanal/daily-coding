package org.example;

import java.util.Stack;

public class CountInversions {
    /**
     * Given an array of integers arr[]. Find the Inversion Count in the array.
     * Two elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.
     *
     * Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If the array is already sorted then the inversion count is 0.
     * If an array is sorted in the reverse order then the inversion count is the maximum.
     *
     * Examples:
     *
     * Input: arr[] = [2, 4, 1, 3, 5]
     * Output: 3
     * Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
     * Input: arr[] = [2, 3, 4, 5, 6]
     * Output: 0
     * Explanation: As the sequence is already sorted so there is no inversion count.
     * Input: arr[] = [10, 10, 10]
     * Output: 0
     * Explanation: As all the elements of array are same, so there is no inversion count.
     * Constraints:
     * 1 ≤ arr.size() ≤ 105
     * 1 ≤ arr[i] ≤ 104
    */

    static int inversionCount(int[] arr) {
        // Your Code Here
        int l = 0;
        int r = arr.length - 1;
        return divide(arr, l, r);
    }

    static int divide(int[] arr, int l, int r) {
        int count = 0;
        if(l < r) {
            int mid = l + (r - l) / 2;
            count += divide(arr, l, mid) + divide(arr, mid + 1, r) + countInversions(arr, l, mid, r);
        }
        return count;
    }

    static int countInversions(int[] arr, int l, int mid, int r) {
        int count = 0;
        int n1 = mid - l + 1;
        int n2 = r - mid;
        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
                count += n1 - i;
            }
            k++;
        }
        while (i < n1) {
            arr[k++] = L[i++];
        }
        while (j < n2) {
            arr[k++] = R[j++];
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(inversionCount(new int[]{2, 4, 1, 3, 5}));
        System.out.println(inversionCount(new int[]{2, 3, 4, 5, 6}));
        System.out.println(inversionCount(new int[]{10, 10, 10}));
    }
}
