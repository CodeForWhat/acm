package indi.lean.acm.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem46 {
    private static void doPermute(List<List<Integer>> result, int[] nums, boolean[] flag, List<Integer> permutation, int idx) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!flag[i]) {
                permutation.add(nums[i]);
                flag[i] = true;
                doPermute(result, nums, flag, permutation, idx + 1);
                permutation.remove((Integer) nums[i]);
                flag[i] = false;
            }
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        boolean[] flags = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        doPermute(result, nums, flags, new ArrayList<>(nums.length), 0);
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1});
        System.out.println(permute);
    }
}
