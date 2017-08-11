package indi.lean.acm.leetcode;

import java.util.Arrays;

public class TwoSum {
	
	public int[] twoSum(int[] nums, int target) {
		int[] indices = new int[2];
		for(int i = 0; i < nums.length; i++) {
			indices[0] = i;
			for(int j = i + 1; j < nums.length; j++) {
				if(nums[j] == target - nums[i]) {
					indices[1] = j;
					return indices;
				}
			}
		}
		
		return indices;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{3, 2, 4};
		
		int[] result = new TwoSum().twoSum(nums, 6);
		System.out.println(Arrays.toString(result));
	}

}
