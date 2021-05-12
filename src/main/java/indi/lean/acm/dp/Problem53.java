package indi.lean.acm.dp;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class Problem53 {
    public static int maxSubArray(int[] nums) {
        int[] f = new int[nums.length];

        int max = Integer.MIN_VALUE;
        f[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            f[i] = Math.max(f[i - 1] + nums[i], nums[i]);
            max = Math.max(f[i], max);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
