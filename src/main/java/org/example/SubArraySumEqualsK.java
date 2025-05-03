package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
    /**
     * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
     *
     * A subarray is a contiguous non-empty sequence of elements within an array.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,1,1], k = 2
     * Output: 2
     * Example 2:
     *
     * Input: nums = [1,2,3], k = 3
     * Output: 2
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 2 * 104
     * -1000 <= nums[i] <= 1000
     * -107 <= k <= 107
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, ArrayList<Integer>> sumIndexMap = new HashMap<>();
        int count = 0;
        int sum=0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum == k) {
                count++;
            }
            if(sumIndexMap.containsKey(sum - k)) {
                list = sumIndexMap.get(sum - k);
                count+=list.size();
            }
            if(sumIndexMap.containsKey(sum)) {
                list = sumIndexMap.get(sum);
                list.add(i);
                sumIndexMap.put(sum, list);
            } else{
                sumIndexMap.put(sum, new ArrayList<>(Arrays.asList(i)));
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1}, 2));
        System.out.println(subarraySum(new int[]{1,2,3}, 3));
    }
}
