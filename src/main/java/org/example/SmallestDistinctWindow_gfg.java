package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SmallestDistinctWindow_gfg {
    /**
     * Given a string str, your task is to find the length of the smallest window that contains all the characters of the given string at least once.
     *
     * Example:
     *
     * Input: str = "aabcbcdbca"
     * Output: 4
     * Explanation: Sub-String "dbca" has the smallest length that contains all the characters of str.
     * Input: str = "aaab"
     * Output: 2
     * Explanation: Sub-String "ab" has the smallest length that contains all the characters of str.
     * Input: str = "geeksforgeeks"
     * Output: 7
     * Explanation: There are multiple substring with smallest length that contains all characters of str, "eksforg" and "ksforge".
     * Constraints:
     * 1 ≤ str.size() ≤ 105
     * str contains only lower-case english alphabets.
    }
     */
    public static int findSubString(String str) {
        Set<Character> uniqueSet = new HashSet<>(26);
        int cnt = 0;
        for(char ch : str.toCharArray()) {
            if(!uniqueSet.contains(ch)) {
                cnt++;
                uniqueSet.add(ch);
            }
        }

        int l = 0;
        Map<Character, Integer> freqMap = new HashMap<>(26);
        int k = 0;
        int minLength = Integer.MAX_VALUE;

        for(int r = 0; r < str.length(); r++) {
            char ch = str.charAt(r);
            if (freqMap.getOrDefault(ch, 0) == 0) {
                k++;
                freqMap.put(ch, 1);
                while(k == cnt) {
                    minLength = Math.min(minLength, r - l + 1);
                    freqMap.put(str.charAt(l), freqMap.get(str.charAt(l)) - 1);
                    if(freqMap.get(str.charAt(l)) == 0) {
                        k--;
                    }
                    l++;
                }
            } else {
                freqMap.put(ch, freqMap.get(ch) + 1);
            }
        }
        return minLength;
    }

    public static void main(String[] args) {
        System.out.println(findSubString("aabcbcdbca"));
        System.out.println(findSubString("aaab"));
        System.out.println(findSubString("geeksforgeeks"));
    }
}
