package indi.lean.acm.bytedance;

public class Problem04 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];

        int idx = 0;
        int idx1 = 0, idx2 = 0;
        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] <= nums2[idx2]) {
                nums[idx++] = nums1[idx1];
                idx1++;
            } else {
                nums[idx++] = nums2[idx2];
                idx2++;
            }
        }

        while (idx1 < nums1.length) {
            nums[idx++] = nums1[idx1++];
        }

        while (idx2 < nums2.length) {
            nums[idx++] = nums2[idx2++];
        }

        if (nums.length % 2 == 0) {
            return (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.0D;
        } else {
            return nums[nums.length / 2];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {}, nums2 = {0};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
