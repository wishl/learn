package com.gmy.leetcode.lingcha.tree;

import com.gmy.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 *
 * https://leetcode.cn/problems/path-sum-ii/description/
 */
public class PathSum {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        find(root, targetSum, 0, new ArrayList<>(), res);
        return res;
    }

    private void find(TreeNode root, int targetSum, int sum, List<Integer> innerRes, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (root.left != null || root.right != null) {
            innerRes.add(root.val);
            find(root.left, targetSum, sum + root.val, innerRes, res);
            find(root.right, targetSum, sum + root.val, innerRes, res);
            innerRes.remove(innerRes.size() - 1);
        } else if (sum + root.val == targetSum) {
            innerRes.add(root.val);
            res.add(new ArrayList<>(innerRes));
            innerRes.remove(innerRes.size() - 1);
        }
    }

    public static void main(String[] args) {
        PathSum pathSum = new PathSum();
        List<List<Integer>> result = pathSum.pathSum(TreeNode.build(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}), 22);
        System.out.println(result);
    }
}
