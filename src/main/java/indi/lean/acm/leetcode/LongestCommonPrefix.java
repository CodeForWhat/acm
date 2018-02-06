package indi.lean.acm.leetcode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder commonPrefix = new StringBuilder();
        int currentIndex = 0;
        Character tempChar = null;

        while(strs.length > 0) {
            for(String str : strs) {
                if(currentIndex >= str.length() ||
                        (tempChar != null && tempChar.charValue() != str.charAt(currentIndex))) {
                    return commonPrefix.toString();
                }

                if(tempChar == null) {
                    tempChar = str.charAt(currentIndex);
                }
            }
            currentIndex++;
            commonPrefix.append(tempChar);
            tempChar = null;
        }

        return commonPrefix.toString();
    }

    public static void main(String ... args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"hello", "helaha", "heluosi"}));
    }
}
