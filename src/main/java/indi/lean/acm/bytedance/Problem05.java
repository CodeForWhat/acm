package indi.lean.acm.bytedance;

public class Problem05 {
    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int left = 0, right = 0, maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int r = s.length() - 1;
            for (; r > i; r--) {
                if (s.charAt(i) == s.charAt(r)) {
                    // 判断s[i, r]是不是回文
                    int j = i, k = r;
                    while (j <= k && s.charAt(j) == s.charAt(k)) {
                        j++;
                        k--;
                    }

                    // 是回文串，并且长度更长，更新坐标和长度
                    if (j >= k && (r - i + 1) > maxLength) {
                        left = i;
                        right = r;
                        maxLength = (right - left + 1);
                    }
                }
            }
        }

        if (maxLength > 0) {
            return new String(s.toCharArray(), left, right - left + 1);
        }

        return new String(s.toCharArray(), 0, 1);
    }



    public static String longestPalindrome2(String s) {
        boolean[][] p = new boolean[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    p[i][j] = true;
                } else {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (j == i + 1) {
                        p[i][j] = b;
                    } else {
                        p[i][j] = p[i + 1][j - 1] & b;
                    }
                }
            }
        }

        int maxLength = 0, left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (p[i][j] && (j - i + 1) > maxLength) {
                    maxLength = j - i + 1;
                    left = i;
                    right = j;
                }
            }
        }

        return new String(s.toCharArray(), left, right - left + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome2("babad"));
    }
}
