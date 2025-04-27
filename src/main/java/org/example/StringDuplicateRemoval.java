package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringDuplicateRemoval {
//    public static String removeDuplicates(String s) {
//        boolean[] ascii = new boolean[256];
//        Arrays.fill(ascii, false);
//        StringBuilder output = new StringBuilder();
//        for(char c : s.toCharArray()) {
//            if(!ascii[c]) {
//                ascii[c] = true;
//                output.append(c);
//            }
//        }
//        return output.toString();
//    }
static String removeDuplicates(String s) {
    Map<Character, Boolean> ascii = new HashMap<>();
    StringBuilder output = new StringBuilder();
    for(Character c : s.toCharArray()) {
        if(null == ascii.get(c)) {
            ascii.put(c, true);
            output.append(c);
        }
    }
    return output.toString();
}

    public static void main(String[] args) {
        System.out.println(removeDuplicates("geEksforGEeks"));
        System.out.println(removeDuplicates("HaPpyNewYear"));
    }
}
