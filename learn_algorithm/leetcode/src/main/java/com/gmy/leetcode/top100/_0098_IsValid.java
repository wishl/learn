package com.gmy.leetcode.top100;

import com.gmy.leetcode.tree.TreeNode;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树
 * 只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class _0098_IsValid {

    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean dfs(TreeNode root, long max, long min) {
        if (root == null) {
            return true;
        }
        if (root.val >= max || root.val <= min) {
            return false;
        }
        return dfs(root.left, root.val, min) && dfs(root.right, max, root.val);
    }

    public static void main(String[] args) {
        _0098_IsValid isValid = new _0098_IsValid();
        boolean result = isValid.isValidBST(TreeNode.build(new Integer[]{2147483647}));
        System.out.println(result);
    }

}
