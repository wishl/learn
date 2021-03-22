package com.gmy.leetcode.top100;

import com.gmy.leetcode.tree.TreeNode;

/**
 * 给定一个二叉树 root ，返回其最大深度。
 *
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 */
public class _0104_MaxDepth {

    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int deep) {
        if (root == null) {
            return deep;
        }
        return Math.max(dfs(root.left, deep + 1), dfs(root.right, deep + 1));
    }

    public static void main(String[] args) {
        _0104_MaxDepth maxDepth = new _0104_MaxDepth();
        int result = maxDepth.maxDepth(TreeNode.build(new Integer[]{3, 9, 20, null, null, 15, 7}));
        System.out.println(result);
    }

}
