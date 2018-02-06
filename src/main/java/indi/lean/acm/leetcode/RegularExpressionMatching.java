package indi.lean.acm.leetcode;


public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        // index denote the next character that will be matching
        int index = 0;

        // analyze the regular expression
        for(int cur = 0; cur < p.length();) {
            if(isDot(p.charAt(cur))) {
                if(cur + 1 < p.length() && isAsteric(p.charAt(cur + 1))) {
                    return true;
                }
                int forward = matchDot(s, index);
                if(forward <= 0) {
                    return false;
                }
                index += forward;
                cur++;
            } else if(isAlphabet(p.charAt(cur))) {
                if(cur + 1 < p.length() && isAsteric(p.charAt(cur + 1))) {
                    int forward = matchAsteric(s, index, p.charAt(cur));

                    if (forward < 0) {
                        return false;
                    }
                    index += forward;
                    cur += 2;
                } else {
                    if(s.charAt(index) == p.charAt(cur)) {
                        cur++;
                        index++;
                    }
                }
            }

        }

        if(index >= s.length()) {
            return true;
        }

        return false;
    }

    /**
     * '*' Matches zero or more of the preceding element.
     * @param s
     * @param indexOfMatching the index of s, where the matching process start
     * @param precedingChar
     * @return
     */
    private int matchAsteric(String s, int indexOfMatching, char precedingChar) {
        // make sure the length of s must be bigger than the indexOfMatching
        if(s.length() <= indexOfMatching) {
            return -1;
        }

        if(s.charAt(indexOfMatching) != precedingChar) {
            // it means matches zero character
            return 0;
        }

        int cursorIndex = indexOfMatching + 1;
        while(cursorIndex < s.length()) {
            if(s.charAt(cursorIndex) == precedingChar) {
                cursorIndex++;
            }
        }

        // return the number of consecutive character c
        return cursorIndex - indexOfMatching;
    }

    /**
     * '.' Matches any single character.
     * @param s
     * @param indexOfMatching
     * @return
     */
    private int matchDot(String s, int indexOfMatching) {
        return indexOfMatching < s.length() ? isAlphabet(s.charAt(indexOfMatching)) ? 1 : -1 : -1;
    }

    /**
     * judge whether the char c is the asteric(*)
     * @param c
     * @return
     */
    private boolean isAsteric(char c) {
        return c == '*';
    }

    /**
     * judge whether the char is an Alphabet
     * @param c
     * @return
     */
    private boolean isAlphabet(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    /**
     * judge wether the char is a dot
     * @param c
     * @return
     */
    private boolean isDot(char c) {
        return c == '.';
    }


    public static void main(String ... args) {
        RegularExpressionMatching matcher = new RegularExpressionMatching();
        System.out.println(matcher.isMatch("abcd", "abc."));
        System.out.println(matcher.isMatch("aa","a"));
        System.out.println(matcher.isMatch("aa","aa"));
        System.out.println(matcher.isMatch("aaa","aa"));
        System.out.println(matcher.isMatch("aa", "a*"));
        System.out.println(matcher.isMatch("aa", ".*"));
        System.out.println(matcher.isMatch("ab", ".*"));
        System.out.println(matcher.isMatch("aab", "c*a*b"));
    }
}
