package org.example;

public class MinimumWindowSubstring76 {
    /**
     * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
     *
     * The testcases will be generated such that the answer is unique.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "ADOBECODEBANC", t = "ABC"
     * Output: "BANC"
     * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
     * Example 2:
     *
     * Input: s = "a", t = "a"
     * Output: "a"
     * Explanation: The entire string s is the minimum window.
     * Example 3:
     *
     * Input: s = "a", t = "aa"
     * Output: ""
     * Explanation: Both 'a's from t must be included in the window.
     * Since the largest window of s only has one 'a', return empty string.
     *
     *
     * Constraints:
     *
     * m == s.length
     * n == t.length
     * 1 <= m, n <= 105
     * s and t consist of uppercase and lowercase English letters.
     *
     *
     * Follow up: Could you find an algorithm that runs in O(m + n) time?
    */

    /* public static String minWindow(String s, String t) {
        int tLength = t.length();
        int[] tFreq = new int[128];
        for(char ch : t.toCharArray()) {
            tFreq[ch]++;
        }
        int currLength = 0;
        int minLength = Integer.MAX_VALUE;
        int res_l = -1;
        int res_r = -1;
        int[] sFreq = new int[128];
        int l = 0;

        for(int r = l; r < s.length(); r++) {
            char curr = s.charAt(r);
            if(tFreq[curr] != 0 && sFreq[curr] < tFreq[curr]) {
                currLength++;
            }
            sFreq[curr]++;

            if(currLength == tLength) {
                if(r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    res_l = l;
                    res_r = r;
                }
                char lChar = s.charAt(l);
                if(sFreq[lChar] == tFreq[lChar])
                    currLength--;
                sFreq[lChar]--;
                l++;
                while(l < r && (tFreq[s.charAt(l)] == 0 || sFreq[s.charAt(l)] > tFreq[s.charAt(l)])) {
                    sFreq[s.charAt(l)]--;
                    l++;
                }
                if((currLength == tLength) && (r - l + 1 < minLength)) {
                    minLength = r - l + 1;
                    res_l = l;
                    res_r = r;
                }

            }
        }
        return res_l == -1 ? "" : s.substring(res_l, res_r + 1);
    }
     */
    public static String minWindow(String s, String t) {
        int[] freq = new int[128];
        for(char ch : t.toCharArray()) {
            freq[ch]++;
        }
        int k = 0;
        int minLength = Integer.MAX_VALUE;
        int start = -1;
        int l = 0;

        for(int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            freq[ch]--;
            if(freq[ch] >= 0) {
                k++;
            }
            while(k == t.length()) {
                if (r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    start = l;
                }
                ch = s.charAt(l);
                freq[ch]++;
                if(freq[ch] > 0) {
                    k--;
                }
                l++;
            }
        }
        return start == -1 ? "" : s.substring(start, start + minLength);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("a", "aa"));
        System.out.println(minWindow("bba", "ab"));
    }
}
