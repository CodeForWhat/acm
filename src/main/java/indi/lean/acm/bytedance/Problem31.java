package indi.lean.acm.bytedance;

import java.util.Arrays;

public class Problem31 {
    public static void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        int i;
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }

        if (i < 0) {
            for (int k = 0, m = nums.length - 1; k < m; k++, m--) {
                int tmp = nums[k];
                nums[k] = nums[m];
                nums[m] = tmp;
            }
            return;
        }

        int j;
        for (j = nums.length - 1; j > i; j--) {
            if (nums[i] < nums[j]) {
                break;
            }
        }

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;

        for (int k = i + 1, m = nums.length - 1; k < m; k++, m--) {
            tmp = nums[k];
            nums[k] = nums[m];
            nums[m] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {1,3,2};
        nextPermutation(array);
        System.out.println(Arrays.toString(array));
    }
}
