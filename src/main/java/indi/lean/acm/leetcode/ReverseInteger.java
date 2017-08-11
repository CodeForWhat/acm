package indi.lean.acm.leetcode;

public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println(new Solution().reverse(1534236469));
	}

}

interface Method {
	int reverse(int x);
}


class Solution implements Method {

	public int reverse(int x) {
		if(x == 0) {
			return x;
		}
		
		// keep track of the sign of x
		int sign = x > 0 ? 1 : -1;
		
		int result = 0;
		x = Math.abs(x);
		
		// higher precision variable to check whether 
		// overflow has occured
		long resultBak = 0;
		for(; x > 0; x = x / 10) {
			resultBak = (long)result * 10 + x % 10;
			
			result = result * 10 + x % 10;
			if(result != resultBak) {
				return 0;
			}
		}
		
		return result * sign;
	}
}
