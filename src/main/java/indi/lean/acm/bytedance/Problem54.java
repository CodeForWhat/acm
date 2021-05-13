package indi.lean.acm.bytedance;

import com.sun.org.apache.bcel.internal.generic.POP;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Problem54 {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private final static Move[] directions = new Move[] {
            // move right
            (point) -> new Point(point.x, point.y + 1),

            // move down
            (point) -> new Point(point.x + 1, point.y),

            // move left
            (point) -> new Point(point.x, point.y - 1),

            // move up
            (point) -> new Point(point.x - 1, point.y)
    };

    private interface Move {
        Point move(Point point);
    }

    private static boolean isPointValid(Point start, Point end, Point point) {
        return point.x >= start.x && point.x <= end.x && point.y >= start.y && point.y <= end.y;
    }

    private static void print(int[][] matrix, Point start, Point end, List<Integer> result) {
        int direction = 0;
        Point nextPoint = new Point(start.x, start.y);

        do {
            result.add(matrix[nextPoint.x][nextPoint.y]);
            Point point = directions[direction].move(nextPoint);
            if (!isPointValid(start, end, point)) {
                direction = (direction + 1) % directions.length;
                nextPoint = directions[direction].move(nextPoint);
            } else {
                nextPoint = point;
            }

            if (start.equals(nextPoint)) {
                break;
            }
        } while (isPointValid(start, end, nextPoint));

        if (start.x + 1 <= end.x - 1 && start.y + 1 <= end.y - 1) {
            print(matrix, new Point(start.x + 1, start.y + 1), new Point(end.x - 1, end.y - 1), result);
        }
    }



    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>(matrix.length * matrix[0].length);
        print(matrix, new Point(0, 0), new Point(matrix.length - 1, matrix[0].length - 1), result);
        return result;
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][] {
//                {1,2,3,4},
//                {5,6,7,8},
//                {9,10,11,12}
//        };

        int[][] matrix = new int[][] {
                {1,2,3},{4,5,6},{7,8,9}
        };
        System.out.println(spiralOrder(matrix));
    }
}
