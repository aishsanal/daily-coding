package org.example;

import java.util.Arrays;

public class Find2NonDupes {
    /**
     * Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.
     *
     * You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,1,3,2,5]
     * Output: [3,5]
     * Explanation:  [5, 3] is also a valid answer.
     * Example 2:
     *
     * Input: nums = [-1,0]
     * Output: [-1,0]
     * Example 3:
     *
     * Input: nums = [0,1]
     * Output: [1,0]
     *
     *
     * Constraints:
     *
     * 2 <= nums.length <= 3 * 104
     * -231 <= nums[i] <= 231 - 1
     * Each integer in nums will appear twice, only two integers will appear once.
    */

    public static int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int n : nums) {
            xor^=n;
        }
        //Finally xor is the XOR of the 2 non repeating numbers
        //Now finding the last set bit of that => the 2 numbers have 1 and 0 at that place
        int lastSetBit = xor & -xor;
        int x = 0; //For numbers with last set bit 1
        int y = 0; //For numbers with last set bit 0
        for(int i = 0; i < nums.length; i++) {
            if ((nums[i] & lastSetBit) != 0) {
                x ^= nums[i];
            } else {
                y ^= nums[i];
            }
        }
        return new int[] {x, y};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumber(new int[]{1,2,1,3,2,5})));
        System.out.println(Arrays.toString(singleNumber(singleNumber(new int[]{-1,0}))));
        System.out.println(Arrays.toString(singleNumber(singleNumber(new int[]{0,1}))));
    }
}
