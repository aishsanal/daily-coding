package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DistrictElementCountInEveryWindow {
    /**
     * Given an integer array arr[] and a number k. Find the count of distinct elements in every window of size k in the array.
     *
     * Examples:
     *
     * Input: arr[] = [1, 2, 1, 3, 4, 2, 3], k = 4
     * Output:  [3, 4, 4, 3]
     * Explanation: Window 1 of size k = 4 is 1 2 1 3. Number of distinct elements in this window are 3.
     * Window 2 of size k = 4 is 2 1 3 4. Number of distinct elements in this window are 4.
     * Window 3 of size k = 4 is 1 3 4 2. Number of distinct elements in this window are 4.
     * Window 4 of size k = 4 is 3 4 2 3. Number of distinct elements in this window are 3.
     * Input: arr[] = [4, 1, 1], k = 2
     * Output: [2, 1]
     * Explanation: Window 1 of size k = 2 is 4 1. Number of distinct elements in this window are 2.
     * Window 2 of size k = 2 is 1 1. Number of distinct elements in this window is 1.
     * Input: arr[] = [1, 1, 1, 1, 1], k = 3
     * Output: [1, 1, 1]
     * Constraints:
     * 1 <= k <= arr.size() <= 105
     * 1 <= arr[i] <= 105
    */

    public static ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        ArrayList<Integer> result = new ArrayList();
        int l = 0;
        int count = 0;
        Map<Integer, Integer> freqMap = new HashMap();
        for(int r = 0; r < arr.length; r++) {
            freqMap.put(arr[r], freqMap.getOrDefault(arr[r], 0) + 1);
            if(freqMap.get(arr[r]) == 1) {
                //New distinct
                count++;
            }
            if (r - l + 1 == k) {
                result.add(count);
                freqMap.put(arr[l], freqMap.get(arr[l]) - 1);
                if(freqMap.get(arr[l]) == 0) {
                    count--;
                }
                l++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countDistinct(new int[]{4, 1, 1}, 2));
        System.out.println(countDistinct(new int[]{1, 2, 1, 3, 4, 2, 3}, 4));
        System.out.println(countDistinct(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
