package com.gmy.leetcode;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class BinTreeMin {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getResult(null, root, 1);
    }

    public static int getResult(Integer min, TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            if (min == null || min > depth) {
                min = depth;
            }
            return min;
        }
        if (root.left != null) {
            min = getResult(min, root.left, depth + 1);
        }
        if (root.right != null) {
            min = getResult(min, root.right, depth + 1);
        }
        return min;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.right.left = new TreeNode(5);
        int result = minDepth(root);
        System.out.println(result);
    }



}
