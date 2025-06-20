package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountTripletsXor1442 {
    /**
     * Given an array of integers arr.
     *
     * We want to select three indices i, j and k where (0 <= i < j <= k < arr.length).
     *
     * Let's define a and b as follows:
     *
     * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
     * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
     * Note that ^ denotes the bitwise-xor operation.
     *
     * Return the number of triplets (i, j and k) Where a == b.
     *
     *
     *
     * Example 1:
     *
     * Input: arr = [2,3,1,6,7]
     * Output: 4
     * Explanation: The triplets are (0,1,2), (0,2,2), (2,3,4) and (2,4,4)
     * Example 2:
     *
     * Input: arr = [1,1,1,1,1]
     * Output: 10
     *
     *
     * Constraints:
     *
     * 1 <= arr.length <= 300
     * 1 <= arr[i] <= 108
    */

    public static int countTriplets(int[] arr) {
        //O(n)
        //0..i..j..k..m
        //0 to i, 0 to j, 0 to k, 0 to m all have same xor
        //=> i to m, j to m, k to m are all 0
        //=> count of triplets = m-i-1 + m-j-1 + m-k-1
        //= 3*(m-1) - (i+j+k); where 3 is the curr frequency of that xor, m is curr index, i+j+k is the sum of indices
        int count = 0;
        int xor = 0;
        Map<Integer, Integer> indexSum = new HashMap();
        Map<Integer, Integer> xorFreq = new HashMap();
        //Handling base case where 0 to k xor becomes 0 for first time;
        indexSum.put(0, -1);
        xorFreq.put(0, 1);
        for (int k = 0; k < arr.length; k++) {
            xor ^= arr[k];
            int freq = xorFreq.getOrDefault(xor, 0);
            int sum = indexSum.getOrDefault(xor, 0);
            count += freq * (k - 1) - sum;
            indexSum.put(xor, sum + k);
            xorFreq.put(xor, freq + 1);
        }
        return count;
    }

    public static int countTripletsBrute(int[] arr) {
        //Brute force n^2
        int currXor = arr[0];
        int tempXor = 0;
        int count = 0;
        for(int k = 1; k < arr.length; k++) {
            currXor ^= arr[k];
            if(currXor == 0) {
                count += k;
            }
            int i = 1;
            tempXor = currXor;
            while(i < k) {
                tempXor ^= arr[i - 1];
                if(tempXor == 0) {
                    count += k - i;
                }
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countTriplets(new int[]{2,3,1,6,7}));
        System.out.println(countTriplets(new int[]{1,1,1,1,1}));
        System.out.println(countTripletsBrute(new int[]{2,3,1,6,7}));
        System.out.println(countTripletsBrute(new int[]{1,1,1,1,1}));
    }
}
