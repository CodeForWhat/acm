package indi.lean.acm.leetcode;

public class LongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		// the head and tail cursor of substring
		int sh = 0, st = 0, maxLength = 0;
		
		char[] chars = s.toCharArray();
		for(; st < chars.length; st++) {
			int index = -1;
			
			// check if the substring contains the next character
			if((index = s.substring(sh, st).indexOf(chars[st])) != -1) {
				maxLength = (st - sh) > maxLength ? (st - sh) : maxLength;
				
				// move the head cursor of substring to the second 
				// occurency of the repeating character
				sh += (index + 1);
			}
		}
		
		// the longest substring may be suffix of string s
		maxLength = (st - sh) > maxLength ? (st - sh) : maxLength;
		
		return maxLength;
	}
	
	public static void main(String[] args) {
		LongestSubstring ls = new LongestSubstring();
		System.out.println(ls.lengthOfLongestSubstring("abcabcbb"));
	}

}
