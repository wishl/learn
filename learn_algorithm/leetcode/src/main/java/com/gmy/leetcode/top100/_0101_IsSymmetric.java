package com.gmy.leetcode.top100;

import com.gmy.leetcode.tree.TreeNode;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * todo review
 */
public class _0101_IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        boolean result = dfs(root.left, root.right);
        return result;
    }


    private boolean dfs(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            // 两个都是空
            return t1 == t2;
        }
        return t1.val == t2.val && dfs(t1.left, t2.right) && dfs(t1.right, t2.left);
    }

    public static void main(String[] args) {
        _0101_IsSymmetric isSymmetric = new _0101_IsSymmetric();
        boolean result = isSymmetric.isSymmetric(TreeNode.build(new Integer[]{1, 2, 2, 3, 4, 4, 3}));
        System.out.println(result);
    }




}
