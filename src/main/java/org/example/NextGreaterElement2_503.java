package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement2_503 {
    /**
     * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
     *
     * The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,1]
     * Output: [2,-1,2]
     * Explanation: The first 1's next greater number is 2;
     * The number 2 can't find next greater number.
     * The second 1's next greater number needs to search circularly, which is also 2.
     * Example 2:
     *
     * Input: nums = [1,2,3,4,3]
     * Output: [2,3,4,-1,4]
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 104
     * -109 <= nums[i] <= 109
    */
    /** Solution with 2 loops
     * class Solution {
     *     public int[] nextGreaterElements(int[] nums) {
     *         Stack<Integer> stack = new Stack<>();
     *         int[] res = new int[nums.length];
     *         Arrays.fill(res, -1);
     *
     *         for(int i = 0; i < nums.length; i++) {
     *             while(!stack.empty() && nums[i] > nums[stack.peek()]) {
     *                 res[stack.pop()] = nums[i];
     *             }
     *             stack.push(i);
     *         }
     *
     *         for(int i = 0; i < nums.length; i++) {
     *             while(!stack.empty() && nums[i] > nums[stack.peek()]) {
     *                 res[stack.pop()] = nums[i];
     *             }
     *         }
     *         return res;
     *     }
     * }
     * @param nums
     * @return
     */

    public static int[] nextGreaterElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        for(int i = 0; i < 2 * n; i++) {
            while(!stack.empty() && nums[i % n] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{1,2,1})));
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{1,2,3,4,3})));
    }
}
