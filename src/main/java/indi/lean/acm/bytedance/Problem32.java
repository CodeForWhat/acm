package indi.lean.acm.bytedance;

import java.util.*;

public class Problem32 {
    public static int longestValidParentheses(String s) {
        boolean[] flags = new boolean[s.length()];
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    Integer leftBracketIdx = stack.pop();
                    flags[leftBracketIdx] = true;
                    flags[i] = true;
                }
            }
            i++;
        }

        int counter = 0, max = 0;
        for (int j = 0; j < s.length(); j++) {
            if (flags[j]) {
                counter++;
                max = Math.max(max, counter);
            } else {
                max = Math.max(max, counter);
                counter = 0;
            }
        }

        return max;
    }

    public static int longestValidParenthesesD(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                for (int j = 0; j < i; j++) {
                    if ((i - j + 1) % 2 != 0) {
                        continue;
                    }

                    dp[j][i] |= ((j + 1 == i) || dp[j + 1][i - 1]) && s.charAt(j) == '(';
                    if (!dp[j][i] && i > 2) {
                        dp[j][i] |= (dp[j][i - 2] && s.charAt(i - 1) == '(');
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (dp[i][j]) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }

        return max;
    }


    public static void main(String[] args) {
        System.out.println(longestValidParenthesesD("(()"));
        System.out.println(longestValidParenthesesD(""));
        System.out.println(longestValidParenthesesD("()(()"));
        System.out.println(longestValidParenthesesD("(()()())"));
    }
}
