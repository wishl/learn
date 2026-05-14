package com.gmy.leetcode.lingcha.tree;

import com.gmy.leetcode.tree.TreeNode;

/**
 * 给你一个有根节点 root 的二叉树，返回它 最深的叶节点的最近公共祖先 。
 * 回想一下：
 * 叶节点 是二叉树中没有子节点的节点
 * 树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1
 * 如果我们假定 A 是一组节点 S 的 最近公共祖先，S 中的每个节点都在以 A 为根节点的子树中，且 A 的深度达到此条件下可能的最大值。
 */
public class LcaDeepestLeaves {

    private int max = 0;
    private TreeNode result = null;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    private int dfs(TreeNode root, int path) {
        if (root == null) {
            max = Math.max(max, path);
            return path;
        }
        int leftPath = dfs(root.left, path + 1);
        int rightPath = dfs(root.right, path + 1);
        if (leftPath == rightPath && leftPath == max) {
            result = root;
        }
        return Math.max(leftPath, rightPath);
    }

    public static void main(String[] args) {
        LcaDeepestLeaves lcaDeepestLeaves = new LcaDeepestLeaves();
        TreeNode treeNode = lcaDeepestLeaves.lcaDeepestLeaves(TreeNode.build(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}));
        System.out.println(treeNode.val);
    }

}
