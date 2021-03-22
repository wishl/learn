package com.gmy.leetcode.bfs;

import com.gmy.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 */
public class RightSideView {

    private Integer max;

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root != null) {
            deque.offer(root);
        }
        while (!deque.isEmpty()) {
            int size = deque.size();
            boolean added = false;
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (!added) {
                    result.add(poll.val);
                    added = true;
                }
            }
        }
        return result;
    }

    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        this.max = 0;
        dfs(root, res, 1);
        return res;
    }

    private void dfs(TreeNode treeNode, List<Integer> res, int deep) {
        if (deep > max) {
            res.add(treeNode.val);
            max++;
        }
        if (treeNode.right != null) {
            dfs(treeNode.right, res, deep + 1);
        }
        if (treeNode.left != null) {
            dfs(treeNode.left, res, deep + 1);
        }
    }

    public static void main(String[] args) {
        RightSideView rightSideView = new RightSideView();
        List<Integer> integers = rightSideView.rightSideView1(TreeNode.build(new Integer[]{1, 2, 3, 4, 5}));
        System.out.println(integers);
    }

}
