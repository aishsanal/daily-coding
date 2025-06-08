package org.example;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingChars {
    /**
     Problem: Calculates the length of the longest substring without repeating characters in a string.
     */
    public static int longestSubString(String str) {
        int maxLength = 0;
        Map<Character, Integer> indexMap = new HashMap<>();
        int start = 0;
        for(int i=0; i<str.length(); i++){
            char currChar = str.charAt(i);
           if (indexMap.containsKey(currChar)) {
                start = Math.max(start, indexMap.get(currChar) + 1);
           }
           indexMap.put(currChar, i);
           maxLength = Math.max(maxLength, i-start+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestSubString("abcbbcbbkhlkkmnhhgbabfds"));
        System.out.println(longestSubString("abcabcbb"));
        System.out.println(longestSubString("bbbbb"));
        System.out.println(longestSubString("pwwkew"));
    }
}
