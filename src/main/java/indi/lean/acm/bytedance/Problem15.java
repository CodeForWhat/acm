package indi.lean.acm.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem15 {
    private static void threeSum(List<List<Integer>> answers, int[] nums, int[] layers, int target, int layer, int left) {
        if (layer == 2) {
            for (int i = left; i < nums.length; i++) {
                if (target == nums[i]) {
                    layers[layer] = nums[i];

                    List<Integer> answer = new ArrayList<>(3);
                    for (int num : layers) {
                        answer.add(num);
                    }

                    for (List<Integer> existAnswer : answers) {
                        if (answer.contains(existAnswer.get(0))
                                && answer.contains(existAnswer.get(1))
                                && answer.contains(existAnswer.get(2))
                                && existAnswer.contains(answer.get(0))
                                && existAnswer.contains(answer.get(1))
                                && existAnswer.contains(answer.get(2))) {
                            return;
                        }
                    }
                    answers.add(answer);
                }
            }
        }
        if (layer < 2) {
            for (int i = left; i < nums.length; i++) {
                layers[layer] = nums[i];
                threeSum(answers, nums, layers, target - nums[i], layer + 1, i + 1);
            }
        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();
        threeSum(answers, nums, new int[3], 0, 0, 0);
        return answers;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();

        for (int first = 0; first < nums.length; first++) {
            for (int second = first + 1; second < nums.length; second++) {
                for (int third = second + 1; third < nums.length; third++) {
                    if ((nums[first] + nums[second] + nums[third]) == 0) {

                    }
                }
            }
        }




        return answers;
    }

    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            while (i - 1 >= 0 && nums[i] == nums[i - 1] && i < nums.length - 1) {
                i++;
            }

            int j = i + 2;
            while (j < nums.length) {
                while (j + 1 < nums.length && nums[j + 1] == nums[j]) {
                    j++;
                }

                for (int k = j - 1; k > i; k--) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        answers.add(Arrays.asList(nums[i], nums[k], nums[j]));
                        break;
                    }
                }

                j++;
            }
        }
        return answers;
    }

    public static List<List<Integer>> threeSum4(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();

        Arrays.sort(nums);
        for (int first = 0; first < nums.length; first++) {
            while (first > 0 && nums[first] == nums[first - 1] && first < nums.length - 1) {
                first++;
            }

            int third = nums.length - 1, second = first + 1;
            while (second < third) {
                while (second > first + 1 && second < third && nums[second] == nums[second - 1]) {
                    second++;
                }

                if (second >= third) {
                    break;
                }

                if (nums[second] + nums[third] > -nums[first]) {
                    third--;
                } else if (nums[second] + nums[third] < -nums[first]) {
                    second++;
                } else {
                    answers.add(Arrays.asList(nums[first], nums[second], nums[third]));
                    second++;
                    third--;
                }

            }
        }
        return answers;
    }

    public static void main(String[] args) {
//        System.out.println(threeSum3(new int[] {-1,0,1,2,-1,-4}));
//        System.out.println(threeSum(new int[] {0, 0, 0}));
//        System.out.println(threeSum4(new int[] {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0}));
        System.out.println(threeSum4(new int[] {-1,0,1,2,-1,-4,-2,-3,3,0,4}));
    }
}
