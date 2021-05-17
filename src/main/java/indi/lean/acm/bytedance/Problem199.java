package indi.lean.acm.bytedance;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem199 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.add(root);

        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            TreeNode remove = queue1.remove();
            if (remove.left != null) {
                queue2.offer(remove.left);
            }

            if (remove.right != null) {
                queue2.offer(remove.right);
            }
            if (queue1.isEmpty()) {
                result.add(remove.val);
                Queue<TreeNode> tmp = queue2;
                queue2 = queue1;
                queue1 = tmp;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, null, null);

        node1.left = node2;
        node1.right = node3;
        node2.right = node5;
        node3.right = node4;
        List<Integer> integers = rightSideView(node1);
        System.out.println(integers);
    }
}
