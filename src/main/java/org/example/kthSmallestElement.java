package org.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class kthSmallestElement {
    /**
     Given an array arr[] and an integer k where k is smaller than the size of the array, your task is to find the kth smallest element in the given array.

     Follow up: Don't solve it using the inbuilt sort function.

     Examples :

     Input: arr[] = [7, 10, 4, 3, 20, 15], k = 3
     Output: 7
     Explanation: 3rd smallest element in the given array is 7.
     Input: arr[] = [2, 3, 1, 20, 15], k = 4
     Output: 15
     Explanation: 4th smallest element in the given array is 15.
     Constraints:
     1 <= arr.size <= 106
     1<= arr[i] <= 106
     1 <= k <= n
     */
    public static int kthSmallest(int[] arr, int k) {
        /*
        // Your code here
        int low = 0;
        int high = arr.length - 1;
        int pivot = -1;
        while(low <= high) {
            pivot = partition(arr, low, high);
            if (pivot == k - 1) {
                return arr[pivot];
            }
            if(k-1 < pivot) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }
        return arr[pivot];
         */
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : arr) {
            pq.offer(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for(int j = low; j<=high; j++) {
            if(arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[]{7, 10, 4, 3, 20, 15}, 3));
        System.out.println(kthSmallest(new int[]{2, 3, 6, 5, 8, 7, 4, 1, 9}, 8));
    }
}
