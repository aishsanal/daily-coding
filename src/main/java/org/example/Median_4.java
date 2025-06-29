package org.example;

public class Median_4 {
    /**
     * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
     *
     * The overall run time complexity should be O(log (m+n)).
     *
     *
     *
     * Example 1:
     *
     * Input: nums1 = [1,3], nums2 = [2]
     * Output: 2.00000
     * Explanation: merged array = [1,2,3] and median is 2.
     * Example 2:
     *
     * Input: nums1 = [1,2], nums2 = [3,4]
     * Output: 2.50000
     * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
     *
     *
     * Constraints:
     *
     * nums1.length == m
     * nums2.length == n
     * 0 <= m <= 1000
     * 0 <= n <= 1000
     * 1 <= m + n <= 2000
     * -106 <= nums1[i], nums2[i] <= 106
    */

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n)
            return findMedianSortedArrays(nums2, nums1);

        int total = (m + n + 1)/2;
        int l = 0;
        int r = m;

        while(l <= r) {
            int p1 = l + (r - l) / 2;
            int p2 = total - p1;

            int leftMax1 = p1 == 0 ? Integer.MIN_VALUE : nums1[p1-1];
            int leftMax2 = p2 == 0 ? Integer.MIN_VALUE : nums2[p2-1];
            int rightMin1 = p1 == m ? Integer.MAX_VALUE : nums1[p1];
            int rightMin2 = p2 == n ? Integer.MAX_VALUE : nums2[p2];

            if(leftMax1 <= rightMin2 && leftMax2 <= rightMin1) {
                if(((m + n) & 1) == 0) {
                    return (double)(Math.max(leftMax1, leftMax2) + Math.min(rightMin1, rightMin2)) / 2;
                } else {
                    return Math.max(leftMax1, leftMax2);
                }
            }
            else if (leftMax1 > rightMin2){
                r = p1 - 1;
            } else {
                l = p1 + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3, 4}));
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{1}));
    }
}
