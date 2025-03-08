package org.example;

import java.util.ArrayList;
import java.util.List;

public class LeftSmallerRightGreater {
    /*
        Given an unsorted array of arr. Find the first element in an array such that all of its left elements are smaller and all right elements of its are greater than it.

        Note: Return -1 if there is no such element.

        Examples :

        Input: arr = [4, 2, 5, 7]
        Output: 5
        Explanation: Elements on left of 5 are smaller than 5 and on right of it are greater than 5.
        Input: arr = [11, 9, 12]
        Output: -1
        Explanation: As no element here which we can say smaller in left & greater in right.
        Constraints:
        3 <= arr.size() <= 106
        1 <= arri <= 106
     */
    public static int findElement(List<Integer> arr) {
        int n = arr.size();
        boolean[] left_traversal = new boolean[n];
        boolean[] right_traversal = new boolean[n];;
        int left_max = arr.get(0);
        int right_min=arr.get(n-1);
        left_traversal[0] = false;
        for(int i=1;i<n;i++){
            if(arr.get(i)>left_max){
                left_traversal[i]=true;
                left_max=arr.get(i);
            }
            else{
                left_traversal[i]=false;
            }
        }
        right_traversal[n-1]=false;
        for(int i=n-2;i>=0;i--){
            if(arr.get(i)<right_min){
                right_traversal[i]=true;
                right_min=arr.get(i);
            }
            else{
                right_traversal[i]=false;
            }
        }
        for(int i = 0;i<n;i++){
            if(left_traversal[i]==true && right_traversal[i]==true)
                return arr.get(i);
        }
        return -1;
    }
    public static void main(String[] args)
    {
        List<Integer> num1 = new ArrayList<>(List.of(4, 2, 5, 7));
        System.out.println(findElement(num1));

        List<Integer> num2 = new ArrayList<>(List.of(11, 9, 12));
        System.out.println(findElement(num2));
//        System.out.println();
//        int num3[] = {2, 1, 8, 7, 6, 5};
//        nextPermutation(num3);
//        for(int num : num3){
//            System.out.print(num);
        }
}
