package com.gmy.leetcode.dfs;

import com.gmy.leetcode.tree.TreeNode;

/**
 * 给定一棵二叉树的根节点 root，请左右翻转这棵二叉树，并返回其根节点。
 *
 * https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/description/
 */
public class MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        dfs(root.left);
        dfs(root.right);
    }
}
