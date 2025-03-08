package org.example;

public class MoveZeroes {
    /*
    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

    Note that you must do this in-place without making a copy of the array.



    Example 1:

    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]
    Example 2:

    Input: nums = [0]
    Output: [0]


    Constraints:

    1 <= nums.length <= 104
    -231 <= nums[i] <= 231 - 1
     */
    public static void moveZeroes(int[] nums) {
        if( nums == null || nums.length ==0)
            return;
        int writePointer = 0;
        for(int readPointer=0; readPointer<nums.length;readPointer++){
            if(nums[writePointer] == 0){
                if(nums[readPointer] != 0){
                    nums[writePointer] = nums[readPointer];
                    nums[readPointer] = 0;
                    writePointer++;
                }

            }
            else{
                writePointer++;
            }
        }

    }
    public static void main(String[] args)
    {
        int colours1[] = {0,1,0,3,12};
        moveZeroes(colours1);
        for (int colour : colours1) {
            System.out.print(colour);
        }
        System.out.println();
        int colours2[] = {0};
        moveZeroes(colours2);
        for (int colour : colours2) {
            System.out.print(colour);
        }
    }
}
