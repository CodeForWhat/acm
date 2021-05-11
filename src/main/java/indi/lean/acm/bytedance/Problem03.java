package indi.lean.acm.bytedance;

import java.util.HashSet;
import java.util.Set;

public class Problem03 {
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.length() - i < maxLength) {
                return maxLength;
            }
            for (int j = i; ; j++) {
                if (j >= s.length() || chars.contains(s.charAt(j))) {
                    maxLength = Math.max(maxLength, j - i);
                    chars.clear();
                    break;
                } else {
                    chars.add(s.charAt(j));
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "ab";
//        String s = "pwwkew";
//        String s = "bbbbb";
//        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
