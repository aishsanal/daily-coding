package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcatanatedSubString_30 {
    /**
     * You are given a string s and an array of strings words. All the strings of words are of the same length.
     *
     * A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.
     *
     * For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
     * Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "barfoothefoobarman", words = ["foo","bar"]
     *
     * Output: [0,9]
     *
     * Explanation:
     *
     * The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
     * The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
     *
     * Example 2:
     *
     * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
     *
     * Output: []
     *
     * Explanation:
     *
     * There is no concatenated substring.
     *
     * Example 3:
     *
     * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
     *
     * Output: [6,9,12]
     *
     * Explanation:
     *
     * The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
     * The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
     * The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].
     *
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 104
     * 1 <= words.length <= 5000
     * 1 <= words[i].length <= 30
     * s and words[i] consist of lowercase English letters.
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList();

        Map<String, Integer> freq = new HashMap<>();
        for(String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        int k = words[0].length();
        for(int i = 0; i < k; i++) {
            int count = 0;
            int l = i;
            Map<String, Integer> temp = new HashMap<>();
            for(int r = i; r + k <= s.length(); r += k) {
                String curr = s.substring(r, r + k);
                if(freq.getOrDefault(curr, 0) == 0) {
                    l = r + k;
                    count = 0;
                    temp.clear();
                    continue;
                }
                temp.put(curr, temp.getOrDefault(curr, 0) + 1);
                while(temp.get(curr) > freq.get(curr)) {
                    String curr1 = s.substring(l, l + k);
                    temp.put(curr1, temp.get(curr1) - 1);
                    l += k;
                    count--;
                }
                count++;
                if(count == words.length) {
                    res.add(l);
                    String first = s.substring(l, l + k);
                    count--;
                    temp.put(first, temp.get(first) - 1);
                    l += k;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"}));
        System.out.println(findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}));
        System.out.println(findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo","barr","wing","ding","wing"}));
    }
}
