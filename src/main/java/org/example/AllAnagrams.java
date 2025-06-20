package org.example;

import java.util.ArrayList;
import java.util.List;

public class AllAnagrams {
    /**
     Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.



     Example 1:

     Input: s = "cbaebabacd", p = "abc"
     Output: [0,6]
     Explanation:
     The substring with start index = 0 is "cba", which is an anagram of "abc".
     The substring with start index = 6 is "bac", which is an anagram of "abc".
     Example 2:

     Input: s = "abab", p = "ab"
     Output: [0,1,2]
     Explanation:
     The substring with start index = 0 is "ab", which is an anagram of "ab".
     The substring with start index = 1 is "ba", which is an anagram of "ab".
     The substring with start index = 2 is "ab", which is an anagram of "ab".


     Constraints:

     1 <= s.length, p.length <= 3 * 104
     s and p consist of lowercase English letters.
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList();
        int[] pFreq = new int [26];
        int[] sFreq = new int [26];
        p.chars().forEach(c -> pFreq[c-'a']++);
        int start = 0;
        boolean isEqual = true;
        for(int end = 0; end<s.length(); end++) {
            char ch = s.charAt(end);
            sFreq[ch-'a']++;
            if(end-start+1 == p.length()) {
                for(int i=0; i<sFreq.length;i++){
                    if(sFreq[i]!=pFreq[i]){
                        isEqual = false;
                        break;
                    }
                }
                if(isEqual){
                    result.add(start);
                }
                sFreq[s.charAt(start)-'a']--;
                start++;
                isEqual = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
        System.out.println(findAnagrams("cbaebabacd", "pq"));
        System.out.println(findAnagrams("ab", "cbaebabacd"));
    }
}
