package indi.lean.acm.bytedance;

import java.util.*;

public class Problem32 {
    public static int longestValidParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int i = 0, counter = 0, lastMatchLeftIdx = -1, lastMatchRightIdx = -1, max = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    Integer leftBracketIdx = stack.pop();
                    if (lastMatchLeftIdx == -1) {
                        max = counter = 2;
                        lastMatchLeftIdx = leftBracketIdx;
                        lastMatchRightIdx = i;
                    } else if (lastMatchRightIdx + 1 == leftBracketIdx || lastMatchRightIdx + 1 == i) {
                        counter += 2;
                        lastMatchRightIdx = i;
                        max = Math.max(counter, max);
                    } else {
                        max = Math.max(counter, max);
                        counter = 0;
                        lastMatchLeftIdx = leftBracketIdx;
                        lastMatchRightIdx = i;
                    }
                }
            }
            i++;
        }

        return max;
    }

    public static void main(String[] args) {
//        System.out.println(longestValidParentheses("(()"));
//        System.out.println(longestValidParentheses(""));
//        System.out.println(longestValidParentheses("()(()"));
        System.out.println(longestValidParentheses("(()()())"));
    }
}
