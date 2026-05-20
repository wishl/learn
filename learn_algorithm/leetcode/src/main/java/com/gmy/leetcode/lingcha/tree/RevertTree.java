package com.gmy.leetcode.lingcha.tree;

import com.gmy.leetcode.tree.TreeNode;

/**
 * 翻转二叉树
 * https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/description/
 */
public class RevertTree {

    public TreeNode flipTree(TreeNode root) {
        dfs(root);
        return root;
    }


    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        dfs(root.left);
        dfs(root.right);
    }


}
