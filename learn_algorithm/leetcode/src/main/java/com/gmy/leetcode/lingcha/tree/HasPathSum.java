package com.gmy.leetcode.lingcha.tree;

import com.gmy.leetcode.tree.TreeNode;

/**
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 * 叶子节点 是指没有子节点的节点。
 *
 * https://leetcode.cn/problems/path-sum/description/
 */
public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return find(root, targetSum, 0);
    }

    private boolean find(TreeNode root, int targetSum, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left != null || root.right != null) {
            return find(root.left, targetSum, sum + root.val) || find(root.right, targetSum, sum + root.val);
        } else {
            return sum + root.val == targetSum;
        }
    }
}
