package org.example;

import java.util.Arrays;
/*
    Given an array of integers arr[] representing a permutation, implement the next permutation that rearranges the numbers into the lexicographically next greater permutation. If no such permutation exists, rearrange the numbers into the lowest possible order (i.e., sorted in ascending order).

    Note - A permutation of an array of integers refers to a specific arrangement of its elements in a sequence or linear order.

    Examples:

    Input: arr = [2, 4, 1, 7, 5, 0]
    Output: [2, 4, 5, 0, 1, 7]
    Explanation: The next permutation of the given array is {2, 4, 5, 0, 1, 7}.
    Input: arr = [3, 2, 1]
    Output: [1, 2, 3]
    Explanation: As arr[] is the last permutation, the next permutation is the lowest one.
    Input: arr = [3, 4, 2, 5, 1]
    Output: [3, 4, 5, 1, 2]
    Explanation: The next permutation of the given array is {3, 4, 5, 1, 2}.
    Constraints:
    1 ≤ arr.size() ≤ 105
    0 ≤ arr[i] ≤ 105
 */
public class NextPermutaion {
    public static void nextPermutation(int[] arr) {
        // code here
        int n = arr.length;
        if(n==1)
            return;
        int curr=n-2;
        int j;
        while(curr>=0){
            j=n-1;
            while(j>curr){
                if(arr[j]>arr[curr]){
                    int temp = arr[j];
                    arr[j]=arr[curr];
                    arr[curr]=temp;
                    break;
                }
                j--;
            }
            if(j>curr)
                break;
            curr--;
        }
        if(curr<0){
            Arrays.sort(arr);
        } else{
            curr++;
            while(curr<n-1){
                j=n-1;
                int small =curr;
                while(j>curr){
                    if(arr[j]<arr[small]){
                        small = j;
                    }
                    j--;
                }
                int temp = arr[curr];
                arr[curr] = arr[small];
                arr[small] = temp;
                curr++;
            }
        }

    }
    public static void main(String[] args)
    {
        int num1[] = {2, 4, 1, 7, 5, 0};

        nextPermutation(num1);
        for(int num : num1){
            System.out.print(num);
        }
        System.out.println();
        int num2[] = {3, 2, 1};
        nextPermutation(num2);
        for(int num : num2){
            System.out.print(num);
        }
        System.out.println();
        int num3[] = {2, 1, 8, 7, 6, 5};
        nextPermutation(num3);
        for(int num : num3){
            System.out.print(num);
        }
    }

}
