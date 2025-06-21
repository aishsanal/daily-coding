package org.example;

import java.util.HashMap;
import java.util.Map;

public class Sqrt_69 {
    /**
     * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
     *
     * You must not use any built-in exponent function or operator.
     *
     * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
     *
     *
     * Example 1:
     *
     * Input: x = 4
     * Output: 2
     * Explanation: The square root of 4 is 2, so we return 2.
     * Example 2:
     *
     * Input: x = 8
     * Output: 2
     * Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
     *
     *
     * Constraints:
     *
     * 0 <= x <= 231 - 1
    */

    public static int mySqrt(int x) {
        int l = 1;
        int r = x / 2 + 2;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if((long)mid * mid > x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l-1;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(2147395599));
        System.out.println(mySqrt(1));
    }
}
