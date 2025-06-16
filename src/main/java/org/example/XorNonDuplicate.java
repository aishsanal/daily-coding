package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class XorNonDuplicate {
    /**
     * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
     *
     * Return the single element that appears only once.
     *
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,1,2,3,3,4,4,8,8]
     * Output: 2
     * Example 2:
     *
     * Input: nums = [3,3,7,7,10,11,11]
     * Output: 10
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 105
     * 0 <= nums[i] <= 105
    */

    public static int singleNonDuplicate(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
        System.out.println(singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
    }
}
