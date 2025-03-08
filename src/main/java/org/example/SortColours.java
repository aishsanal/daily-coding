package org.example;

import java.util.Arrays;

public class SortColours {
    /*
    Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

    We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

    You must solve this problem without using the library's sort function.



    Example 1:

    Input: nums = [2,0,2,1,1,0]
    Output: [0,0,1,1,2,2]
    Example 2:

    Input: nums = [2,0,1]
    Output: [0,1,2]


    Constraints:

    n == nums.length
    1 <= n <= 300
    nums[i] is either 0, 1, or 2.
     */
    public static void sortColors(int[] nums) {
        int start = 0;
        int i = 0;
        int end = nums.length - 1;
        while (i <= end) {
            if (nums[i] == 2) {
                nums[i] = nums[end];
                nums[end] = 2;
                end--;
            } else if(nums[i] == 0) {
                nums[i] = nums[start];
                nums[start] = 0;
                start++;
                i++;
            } else{
                i++;
            }
        }
    }
    public static void main(String[] args)
    {
        int colours1[] = {2,0,2,1,1,0};
        sortColors(colours1);
        for (int colour : colours1) {
            System.out.print(colour);
        }
        System.out.println();
        int colours2[] = {2,0,1};
        sortColors(colours2);
        for (int colour : colours2) {
            System.out.print(colour);
        }
    }
}
