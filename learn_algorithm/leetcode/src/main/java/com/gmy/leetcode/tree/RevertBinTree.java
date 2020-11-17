package com.gmy.leetcode.tree;

/**
 * 反转二叉树
 */
public class RevertBinTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public static void revert(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode treeNode = root.left;
        root.left = root.right;
        root.right = treeNode;
        revert(root.left);
        revert(root.right);
    }

    public static void mid(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        mid(root.left);
        mid(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        TreeNode leftLeft = new TreeNode(4);
        TreeNode leftRight = new TreeNode(5);
        left.left = leftLeft;
        left.right = leftRight;
        TreeNode rightLeft = new TreeNode(6);
        TreeNode rightRight = new TreeNode(7);
        right.left = rightLeft;
        right.right = rightRight;
        mid(root);
        System.out.println("======");
        revert(root);
        System.out.println("======");
        mid(root);
    }


}
