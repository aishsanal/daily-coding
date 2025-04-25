package org.example;

/*
    Array of length n having integers 1 to n with some elements being repeated. Count frequencies of all elements from 1 to n in Time Complexity O(n) and Space Complexity O(1) Asked in : : PayTm, VmWare, Amazon

    Example:

    Input array elements: 5, 1, 2, 5, 5, 5, 1, 1, 2, 2
    Output
    Frequency of 5 = 4
    Frequency of 2 = 3
    Frequency of 1 = 3
    Hint1 : All the numbers are between 1 to n in the given array
    Hint2: Think of updating index of array for given number
 */
public class CountFrequencies {
    public static void countfrequenciesEfficient(int input[]) {
        int n = input.length;
        for (int i=0; i< n; i++) {
            if (input[i] < n) {
                input[input[i] - 1]+=n;
            } else {
                int num = input[i] % n;
                if(num != 0)
                    input[num - 1]+=n;
                else {
                    if (i != n - 1) {
                        input[n - 1] += n;
                    }
                }
            }
        }
        for (int i=0; i< n; i++) {
            int curr_num = i + 1;
            int count = input[i]/n;
            System.out.println("Frequency of " + curr_num+ "= " + count);
        }
    }

    public static void main(String[] args) {
        int[] input = { 2, 3, 3, 2, 5 };
        countfrequenciesEfficient(input);
        System.out.println();

        int[] input2 = { 1, 2, 2, 1, 1, 2, 3, 2};
        countfrequenciesEfficient(input2);
        System.out.println();

        int[] input3 = { 1, 2, 2};
        countfrequenciesEfficient(input3);
        System.out.println();

        int[] input4 = {4, 4, 4, 4};
        countfrequenciesEfficient(input4);
    }
}

