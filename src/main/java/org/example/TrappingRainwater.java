package org.example;

import java.util.HashMap;
import java.util.Map;

public class TrappingRainwater {
    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
     * Example 2:
     *
     * Input: height = [4,2,0,3,2,5]
     * Output: 9
     *
     *
     * Constraints:
     *
     * n == height.length
     * 1 <= n <= 2 * 104
     * 0 <= height[i] <= 105
    */

    public static int trap(int[] height) {
        int n = height.length;
        int[] leftToRight = new int[n];
        int currMax = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            currMax = Math.max(currMax, height[i]);
            leftToRight[i] = currMax;
        }

        int[] rightToLeft = new int[n];
        currMax = Integer.MIN_VALUE;
        for(int i = n - 1; i >= 0; i--) {
            currMax = Math.max(currMax, height[i]);
            rightToLeft[i] = currMax;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(leftToRight[i], rightToLeft[i]) - height[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trap(new int[]{4,2,0,3,2,5}));
    }
}
