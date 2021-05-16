package indi.lean.acm.bytedance;

public class Problem41 {
    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                int tmp = nums[i];
                do {
                    if (tmp >= 1 && tmp <= nums.length) {
                        int ttmp = nums[tmp - 1];
                        nums[tmp - 1] = tmp;
                        tmp = ttmp;
                    }
                } while (tmp >= 1 && tmp <= nums.length && nums[tmp - 1] != tmp);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                return (i + 1);
            }
        }

        return nums.length + 1;
    }

    public static void main(String[] args) {
//        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
//        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
//        System.out.println(firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        System.out.println(firstMissingPositive(new int[]{2147483647, 2147483646, 2147483645, 3, 2, 1, -1, 0, -2147483648}));
    }
}
