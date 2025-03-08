package org.example;

import java.util.Arrays;

public class MaxElement {
    /*
    One array of integers is given as an input ,which is initially increasing and then decreasing or it can be only
    increasing or decreasing , you need to find the maximum value in the array in O(Log n) Time complexity and O(1)
    Space Complexity Asked in: Amazon, Microsoft, Uber
    case 1:
    actual = findMaximum([8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1],0,10)
    expected = 500

    case2:
     actual = findMaximum([10, 20, 30, 40, 50],0,4)
     expected = 50

    case3:
    actual = findMaximum([120, 100, 80, 20, 0],0,4)
    expected = 120
    */
    static int findMaximum(int array[], int start, int end)
    {
        if (start == end) {
            return array[start];
        }
        if(array[start] > array[start + 1]) {
            return array[start]; //decreasing
        }
        if(array[end] > array[end - 1]) {
            return array[end]; //increasing
        }
        while(start <= end) {
            int mid = (start + end)/2;
            if (array[mid-1]<array[mid] && array[mid+1] < array[mid]) {
                return array[mid];
            } else if(array[mid-1]<array[mid] && array[mid+1] > array[mid]) {
                start = mid +1;
            } else {
                end = mid -1;
            }
        }
        return -1;
    }


    public static void main (String[] args)
    {
        int array[] = {3, 5,15, 50, 11, 10, 8, 6};
        int n = array.length;
        System.out.println("The maximum Value "+  findMaximum(array, 0, n-1));

        int array2[] = {120, 100, 80, 20, 0};
        int n2 = array.length;
        System.out.println("The maximum Value "+  findMaximum(array2, 0, n2-1));
    }
}
