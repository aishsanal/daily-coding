package org.example;

public class LongestTurbulentSubArray {
    /**
     Given an integer array arr, return the length of a maximum size turbulent subarray of arr.

     A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.

     More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if and only if:

     For i <= k < j:
     arr[k] > arr[k + 1] when k is odd, and
     arr[k] < arr[k + 1] when k is even.
     Or, for i <= k < j:
     arr[k] > arr[k + 1] when k is even, and
     arr[k] < arr[k + 1] when k is odd.


     Example 1:

     Input: arr = [9,4,2,10,7,8,8,1,9]
     Output: 5
     Explanation: arr[1] > arr[2] < arr[3] > arr[4] < arr[5]
     Example 2:

     Input: arr = [4,8,12,16]
     Output: 2
     Example 3:

     Input: arr = [100]
     Output: 1


     Constraints:

     1 <= arr.length <= 4 * 104
     0 <= arr[i] <= 109
     */
    public static int maxTurbulenceSize(int[] arr) {
        if(arr.length == 1)
            return 1;
        boolean lessThan = false;
        boolean greaterThan = false;
        int start = 0;
        int  maxSum = 0;
        for(int i=1; i<arr.length; i++) {
            if(arr[i]<arr[i-1] && !lessThan) {
                lessThan = true;
                greaterThan = false;
            } else if (arr[i]>arr[i-1] && !greaterThan) {
                greaterThan = true;
                lessThan = false;
            } else if(arr[i] == arr[i-1]) {
                start = i;
                greaterThan = false;
                lessThan = false;
            }else {
                start = i-1;
                if(arr[i] > arr[i-1]) {
                    greaterThan = true;
                    lessThan = false;
                } else if(arr[i] < arr[i-1]) {
                    lessThan = true;
                    greaterThan = false;
                }
            }
            maxSum = Math.max(maxSum, i-start+1);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9}));
        System.out.println(maxTurbulenceSize(new int[]{100}));
        System.out.println(maxTurbulenceSize(new int[]{4,8,12,16}));
    }
}
