package indi.lean.acm.dp;

public class Problem303 {

}


class NumArray {
    private final int[] sumResult;

    public NumArray(int[] nums) {
        sumResult = new int[nums.length];
        sumResult[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sumResult[i] = sumResult[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return sumResult[right];
        }
        return sumResult[right] - sumResult[left - 1];
    }

    public static void main(String[] args) {
        int[] array = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(array);
        System.out.println(numArray.sumRange(0, 2));
    }
}

class NumArray2 {
    private final int[][] sumResult;

    public NumArray2(int[] nums) {
        sumResult = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            sumResult[i][i] = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sumResult[i][j] = Integer.MIN_VALUE;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sumResult[i][j] = sumResult[i][j - 1] + nums[j];
            }
        }
    }

    public int sumRange(int left, int right) {
        return sumResult[left][right];
    }

    public static void main(String[] args) {
        int[] array = {-2, 0, 3, -5, 2, -1};
        NumArray2 numArray = new NumArray2(array);
        System.out.println(numArray.sumRange(0, 2));
    }
}