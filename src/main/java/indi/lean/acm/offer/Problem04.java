package indi.lean.acm.offer;

public class Problem04 {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length <= 0 || matrix[0].length <= 0) {
            return false;
        }

        if (matrix[0][0] > target || matrix[matrix.length - 1][matrix[0].length - 1] < target) {
            return false;
        }

        int rowIdx = 0;
        for (; rowIdx < matrix.length; rowIdx++) {
            if (matrix[rowIdx][0] >= target) {
                break;
            }
        }

        if (matrix[rowIdx][0] == target) {
            return true;
        }

        rowIdx--;

        int columnIdx = 0;
        for (; columnIdx < matrix[0].length; columnIdx++) {
            if (matrix[0][columnIdx] >= target) {
                break;
            }
        }

        if (matrix[rowIdx][columnIdx] == target) {
            return true;
        }

        for (int idx = rowIdx; idx >= 0; idx--) {
            if (matrix[idx][columnIdx] == target) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] array = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.println(findNumberIn2DArray(array, 8));
    }
}
