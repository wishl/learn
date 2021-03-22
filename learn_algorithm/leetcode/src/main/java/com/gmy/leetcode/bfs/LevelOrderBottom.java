package com.gmy.leetcode.bfs;

import com.gmy.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 */
public class LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<List<Integer>> inner = new ArrayDeque<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root != null) {
            deque.offer(root);
        }
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> innerList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                innerList.add(poll.val);
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
            }
            inner.offerFirst(innerList);
        }
        return new ArrayList<>(inner);
    }

    public static void main(String[] args) {
        LevelOrderBottom levelOrderBottom = new LevelOrderBottom();
        List<List<Integer>> lists = levelOrderBottom.levelOrderBottom(TreeNode.build(new Integer[]{3, 9, 20, null, null, 15, 7}));
        System.out.println(lists);
    }

}
