package org.example;

import java.util.HashSet;
import java.util.Set;

public class XorOfRepeatingNums3158 {
    /**
     * You are given an array nums, where each number in the array appears either once or twice.
     *
     * Return the bitwise XOR of all the numbers that appear twice in the array, or 0 if no number appears twice.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,1,3]
     *
     * Output: 1
     *
     * Explanation:
     *
     * The only number that appears twice in nums is 1.
     *
     * Example 2:
     *
     * Input: nums = [1,2,3]
     *
     * Output: 0
     *
     * Explanation:
     *
     * No number appears twice in nums.
     *
     * Example 3:
     *
     * Input: nums = [1,2,2,1]
     *
     * Output: 3
     *
     * Explanation:
     *
     * Numbers 1 and 2 appeared twice. 1 XOR 2 == 3.
     *
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 50
     * 1 <= nums[i] <= 50
     * Each number in nums appears either once or twice.
    */

    public static int duplicateNumbersXor(int[] nums) {
        int res = 0;
        Set<Integer> freqMap = new HashSet();
        for(int i = 0; i < nums.length; i++) {
            if(freqMap.contains(nums[i])) {
                res = (res ^ nums[i]);
            } else {
                freqMap.add(nums[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(duplicateNumbersXor(new int[]{1,2,1,3}));
        System.out.println(duplicateNumbersXor(new int[]{1,2,3}));
        System.out.println(duplicateNumbersXor(new int[]{1,2,2,1}));
    }
}
