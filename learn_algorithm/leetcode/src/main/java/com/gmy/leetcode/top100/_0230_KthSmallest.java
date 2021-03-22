package com.gmy.leetcode.top100;

import com.gmy.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
 */
public class _0230_KthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> path = new ArrayList<>();
        dfs(root, k, path);
        return path.get(k - 1);
    }

    private void dfs(TreeNode root, int k, List<Integer> path) {
        if (path.size() == k) {
            return;
        }
        if (root.left != null) {
            dfs(root.left, k, path);
        }
        path.add(root.val);
        if (root.right != null) {
            dfs(root.right, k, path);
        }
    }

}
