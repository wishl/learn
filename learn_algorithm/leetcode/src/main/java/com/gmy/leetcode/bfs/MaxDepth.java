package com.gmy.leetcode.bfs;

import com.gmy.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        int result = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root != null) {
            deque.offer(root);
        }
        while (!deque.isEmpty()) {
            int size = deque.size();
            result++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
            }
        }
        return result;
    }

    public int maxDepth1(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int max) {
        if (root == null) {
            return max;
        }
        int leftMax = dfs(root.left, max + 1);
        int rightMax = dfs(root.right, max + 1);
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        MaxDepth maxDepth = new MaxDepth();
        int i = maxDepth.maxDepth1(TreeNode.build(new Integer[]{3, 9, 20, null, null, 15, 7}));
        System.out.println(i);
    }

}
