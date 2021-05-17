package indi.lean.acm.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem56 {
    public static int[][] merge(int[][] intervals) {
        sortByFirstElement(intervals);

        List<int[]> list = new ArrayList<>();

        int intervalStart = intervals[0][0], intervalEnd = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] > intervalEnd) {
                list.add(new int[]{intervalStart, intervalEnd});
                intervalStart = interval[0];
                intervalEnd = interval[1];
            } else {
                intervalEnd = Math.max(intervalEnd, interval[1]);
            }
        }

        list.add(new int[] {intervalStart, intervalEnd});

        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    private static void sortByFirstElement(int[][] intervals) {
        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < intervals.length - i; j++) {
                if (intervals[j][0] > intervals[j + 1][0]) {
                    int[] tmp = intervals[j];
                    intervals[j] = intervals[j + 1];
                    intervals[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[][] intervals = {
//                {1,3},
//                {2,6},
//                {8,10},
//                {15,18}
//        };
        int[][] intervals = {
                {1,4},
                {2,3}
        };

//        sortByFirstElement(intervals);

        int[][] merge = merge(intervals);

        for (int[] interval : merge) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
