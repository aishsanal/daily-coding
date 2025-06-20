package org.example;

import java.util.Arrays;

public class SingleNumber2 {
    /**
     * Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
     *
     * You must implement a solution with a linear runtime complexity and use only constant extra space.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,2,3,2]
     * Output: 3
     * Example 2:
     *
     * Input: nums = [0,1,0,1,0,1,99]
     * Output: 99
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 3 * 104
     * -231 <= nums[i] <= 231 - 1
     * Each element in nums appears exactly three times except for one element which appears once.
    */

    public static int singleNumber(int[] nums) {
        int[] count = new int[32];
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < 32; j++) {
                if((nums[i] & (1<<j)) != 0) {
                    count[j]++;
                }
            }
        }
        int num = 0;
        for(int i = 0; i < 32; i++) {
            if(count[i] % 3 != 0) {
                num |= (1<<i);
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{0,1,0,1,0,1,99}));
        System.out.println(singleNumber(new int[]{2,2,3,2}));
    }
}
