package indi.lean.acm.leetcode;

public class LongestPalindromicSubstring {
	
	// brute force algorithm
	public String longestPalindrome(String s) {
		String palindrome = s.charAt(0) + "";

		for (int i = 0; i < s.length(); i++) {
			for (int j = s.length() - 1; j > i; j--) {
				
				// the first char and last char of substring must be the same
				// if the substring is palindrome
				if (s.charAt(j) == s.charAt(i)) {
					String temp = s.substring(i, j + 1);
					if (isPalindrome(temp)) {
						palindrome = temp.length() > palindrome.length() ? temp : palindrome;
						break;
					}
				}
			}
		}
		return palindrome;
	}

	public boolean isPalindrome(String s) {
		char[] chars = s.toCharArray();

		int head = 0, tail = s.length() - 1;
		for (; head <= tail; head++, tail--) {
			if (chars[head] != chars[tail]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
//		Manacher lps = new Manacher();
		DynamicProgramming lps = new DynamicProgramming();
		System.out.println(lps.longestPalindrome("ccc"));
	}
}


// implementation of manacher algorithm
class Manacher {
	public String longestPalindrome(String s) {
		// preprocess
		StringBuilder ss = new StringBuilder();
		ss.append("$"); // sentinel
		for(char ch : s.toCharArray()) {
			ss.append("#").append(ch);
		}
		String uniformS = ss.append("#").toString();
		
		char[] chars = uniformS.toCharArray();
		
		// radius of palindrome strings
		int[] p = new int[chars.length];
		
		for(int i = 1; i < chars.length; i++) {
			p[i] = 1;
			
			for(int j = i + 1; j < chars.length; j++) {
				if(chars[2 * i - j] == '$' || chars[2 * i - j] != chars[j]) {
					break;
				}
				p[i]++;
			}
		}
		
		// find the maximum palindrome radius
		int maxRadius = 1, index = 1;
		for(int i = 1; i < chars.length; i++) {
			if(p[i] > maxRadius) {
				maxRadius = p[i];
				index = i;
			}
		}
		
		return uniformS.substring(index - p[index]  + 1, index + p[index]).replace("#", "");
	}
}

// dynamic programming solution
class DynamicProgramming {
	public String longestPalindrome(String s) {
		char[] chars = s.toCharArray();
		
		boolean[][] flags = new boolean[chars.length][chars.length];
		int maxLength = 1, start = 0;
		
		// basis of iteration flags[i][i] = true
		for(int i = 0; i < chars.length; i++) {
			flags[i][i] = true;
			
		}
		
		// basis of iteration flags[i][i+1] = S[i] == S[i+1]
		for(int i = 0; i < chars.length - 1; i++) {
			if(flags[i][i + 1] = (chars[i] == chars[i + 1])) {
				start = i;
				maxLength = 2;
			}
		}
		
		// dynamic programming
		for(int i = 3; i <= chars.length; i++) {
			for(int j = 0; j + i - 1 < chars.length; j++) {
				
				// flags[i][j] = flags[i+1][j-1] & (S[i+1] == S[j-1])
				flags[j][j + i - 1] = flags[j + 1][j + i - 1 - 1] & (chars[j] == chars[j + i - 1]);
				
				// update maxLength and the start of the palindrome
				if(flags[j][j + i - 1] && (i > maxLength)) {
					start = j;
					maxLength = i;
				}
			}
		}
		
		return s.substring(start, start + maxLength);
	}
}
