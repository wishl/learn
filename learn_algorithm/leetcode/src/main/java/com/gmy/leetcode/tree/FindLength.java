package com.gmy.leetcode.tree;

/**
 * 计算二叉树中两个点的距离
 */
public class FindLength {

    public int findLength(TreeNode treeNode, int left, int right) {
        TreeNode ancestor = findAncestor(treeNode, left, right);
        Integer length = calLength(ancestor, left, 0);
        return calLength(ancestor, right, length);
    }

    public TreeNode findDfs(TreeNode root, int i, int j) {
        if (root == null) {
            return null;
        }
        if (root.val == i || root.val == j) {
            return root;
        }
        TreeNode leftRoot = findDfs(root.left, i, j);
        TreeNode rightRoot = findDfs(root.right, i, j);
        if (leftRoot != null && rightRoot != null) {
            return root;
        }
        return leftRoot == null ? rightRoot : leftRoot;
    }

    public TreeNode findAncestor(TreeNode root, int i, int j) {
        if (root == null) {
            return null;
        }
        if (root.val == i || root.val == j)  {
            return root;
        }
        TreeNode left  = findAncestor(root.left,  i, j);
        TreeNode right = findAncestor(root.right, i, j);
        if (left != null && right != null) {
            return root;
        }
        return right == null ? left : right;
    }

    public Integer calLength(TreeNode root, int i, int length) {
        if (root == null) {
            return length;
        }
        if (root.val == i) {
            return length;
        }
        return calLength(root.left, i,length + 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.build(new Integer[] {1, 2, 3, 4, 5, null, null, 6, 7});
        FindLength findLength = new FindLength();
        int length = findLength.findLength(treeNode, 1, 6);
        System.out.println(length);
    }

}
