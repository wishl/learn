package com.gmy.leetcode.top100;

import com.gmy.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 */
public class _0094_InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            dfs(root.left, result);
        }
        result.add(root.val);
        if (root.right != null) {
            dfs(root.right, result);
        }
    }

    public static void main(String[] args) {
        _0094_InorderTraversal inorderTraversal = new _0094_InorderTraversal();
        List<Integer> result = inorderTraversal.inorderTraversal(TreeNode.build(new Integer[]{1, 4, 2, 3}));
        System.out.println(result);
    }

}
