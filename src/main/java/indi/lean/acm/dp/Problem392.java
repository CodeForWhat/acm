package indi.lean.acm.dp;

public class Problem392 {
    public static boolean isSubsequence(String s, String t) {
        int sIdx = 0, tIdx = 0;
        while (sIdx < s.length() && tIdx < t.length()) {
            if (s.charAt(sIdx) == t.charAt(tIdx)) {
                tIdx++;
                sIdx++;
            } else {
                tIdx++;
            }
        }

        return sIdx == s.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }
}
