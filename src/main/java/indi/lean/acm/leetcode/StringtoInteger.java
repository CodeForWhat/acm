package indi.lean.acm.leetcode;

public class StringtoInteger {
	
	class Solution {
		public int safePlus(int operand, int addend) throws ArithmeticException {
			int bak = operand;
			if((operand = operand + addend) < bak) {
				throw new ArithmeticException();
			}
			return bak;
		}
		
		public int safeShift(int operand, int bits) throws ArithmeticException {
			int bak = operand;
			
			for(; bits > 0;bits--) {
				if((operand <<= 1) < bak) {
					throw new ArithmeticException();
				} else {
					bak = operand;
				}
			}
			
			return operand;
		}
		
		/* let N denote the number represented by the str then:
		 * 
		 * 1. N may be negative
		 * 2. N may be a decimal number
		 * 3. N may be denoted by the scientific notation
		 * 4. N may not be a valid number
		 */
		public int myAtoi(String str) {
//			char[] chars = 
			return 0;
		}
	}


	public static void main(String[] args) {

	}

}

