package org.example;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class kthLargestElement {
    /**
     * Given an integer array nums and an integer k, return the kth largest element in the array.
     *
     * Note that it is the kth largest element in the sorted order, not the kth distinct element.
     *
     * Can you solve it without sorting?
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [3,2,1,5,6,4], k = 2
     * Output: 5
     * Example 2:
     *
     * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
     * Output: 4
     *
     *
     * Constraints:
     *
     * 1 <= k <= nums.length <= 105
     * -104 <= nums[i] <= 104
     */

    /*
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;
        int pivot = -1;
        while(low <= high) {
            pivot = partition(nums, low, high);
            if (pivot == k - 1) {
                return nums[pivot];
            }
            if(k - 1 < pivot) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }
        return nums[pivot];
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for(int j = low; j<=high; j++) {
            if(arr[j] >= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return i;
    }
}
*/
    //Above soln gives n2 solution in worst case even with random pivot
    //Below soln uses priority queue which stores elements in ascending order by default and least element is the topmost element
    public static int kthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        System.out.println(kthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(kthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
