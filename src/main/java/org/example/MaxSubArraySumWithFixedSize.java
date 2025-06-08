package org.example;

public class MaxSubArraySumWithFixedSize {
    /**
     Problem: Given an array of integers, find the maximum sum of a subarray with a fixed window size.
     */
    public static int maxSum(int[] arr, int k) {
        int maxSum = 0;
        int currSum = 0;
        int count = 0;
        int start = 0;
        for(int i=0; i< arr.length; i++) {
            currSum+=arr[i];
            count++;
            if(count == k){
                maxSum = Math.max(maxSum, currSum);
                currSum-=arr[start];
                start++;
                count--;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{2, 1, 5, 0, 1, 2, 3, 0, 2, 1}, 3));
    }
}
