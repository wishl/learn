package com.gmy.leetcode.lingcha.tree;

import com.gmy.leetcode.tree.TreeNode;

/**
 * @Author Guanmengyuan
 * @Date Created in 16:02 2026/5/18
 */
public class CalculateDepth {

    public int calculateDepth(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int left = dfs(root.left, depth + 1);
        int right = dfs(root.right, depth + 1);
        return Math.max(left, right);
    }

}
