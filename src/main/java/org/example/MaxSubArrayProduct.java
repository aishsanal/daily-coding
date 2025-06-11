package org.example;

public class MaxSubArrayProduct {
    /**
     Given an integer array nums, find a subarray that has the largest product, and return the product.

     The test cases are generated so that the answer will fit in a 32-bit integer.



     Example 1:

     Input: nums = [2,3,-2,4]
     Output: 6
     Explanation: [2,3] has the largest product 6.
     Example 2:

     Input: nums = [-2,0,-1]
     Output: 0
     Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


     Constraints:

     1 <= nums.length <= 2 * 104
     -10 <= nums[i] <= 10
     The product of any subarray of nums is guaranteed to fit in a 32-bit integer.
     */
    public static int subarrayPdt(int[] nums) {
        int maxPdt = nums[0];
        int minPdt = nums[0];
        int ans = nums[0];
        for(int i=1; i < nums.length; i++) {
            int currMax = maxPdt;
            int currMin = minPdt;
            maxPdt = Math.max(nums[i], Math.max(currMax * nums[i], currMin * nums[i]));
            minPdt = Math.min(nums[i], Math.min(currMax * nums[i], currMin * nums[i]));
            ans = Math.max(ans, maxPdt);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(subarrayPdt(new int[]{2,3,-2,4}));
        System.out.println(subarrayPdt(new int[]{-2,0,-1}));
    }
}
