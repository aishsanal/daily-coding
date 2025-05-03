package org.example;

public class SearchInSortedMatrix {
    /*
    Matrix n*n is given, where all elements in any individual row or column are sorted. In such a matrix, we have to find the position of a value in O(n) Time Complexity and O(1) Space Complexity

    Example 1:
    * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * element = 3
     * output = true
    */
    public static void search(int[][] nums, int target) {
        int i = 0;
        int n = nums.length;
        int j = n - 1;
        while(i < n && j >= 0){
            if(nums[i][j] == target) {
                System.out.println("Element found at position : (" + i + "," + j + ")");
                return ;
            }
            if(target < nums[i][j]){
                j--;
            } else {
                i++;
            }
        }
        System.out.println("Element is not found in the matrix");
    }


    public static void main (String[] args)
    {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        search(array, 7);

        int[][] array2 = {{10, 20, 30, 40}, {15, 25, 36, 46}, {28, 29, 37, 48}, {32, 33, 39, 50}};
        search(array2, 32);
    }
}
