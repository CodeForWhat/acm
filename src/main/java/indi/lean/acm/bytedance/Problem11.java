package indi.lean.acm.bytedance;

public class Problem11 {
    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return max;
    }

    public static int maxArea2(int[] height) {
        int max = 0;
        for (int window = 1; window <= height.length; window++) {
            for (int j = 0; j < height.length && j + window < height.length; j++) {
                max = Math.max(max, window * Math.min(height[j], height[j + window]));
            }
        }
        return max;
    }

    public static int maxArea3(int[] height) {
        int left = 0, right = height.length - 1;

        int max = 0;
        while (left < right) {
            max = Math.max((right - left) * Math.min(height[left], height[right]), max);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea3(new int[] {1,1}));
        System.out.println(maxArea3(new int[] {4,3,2,1,4}));
        System.out.println(maxArea3(new int[] {1,2,1}));
    }
}
