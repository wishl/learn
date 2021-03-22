package com.gmy.leetcode.bfs;

import com.gmy.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        Deque<TreeNode> deque1 = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            deque.offer(root);
        }
        // 偶数层从左往右，奇数层从右往左
        int n = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> inner = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll;
                if (n % 2 == 0) {
                    poll = deque.poll();
                    if (poll.left != null) {
                        deque1.offer(poll.left);
                    }
                    if (poll.right != null) {
                        deque1.offer(poll.right);
                    }
                } else {
                    poll = deque.pollLast();
                    if (poll.right != null) {
                        deque1.offerFirst(poll.right);
                    }
                    if (poll.left != null) {
                        deque1.offerFirst(poll.left);
                    }
                }
                inner.add(poll.val);
            }
            res.add(inner);
            deque = deque1;
            deque1 = new ArrayDeque<>();
            n++;
        }
        return res;
    }

    public static void main(String[] args) {
        ZigzagLevelOrder zigzagLevelOrder = new ZigzagLevelOrder();
        List<List<Integer>> lists = zigzagLevelOrder.zigzagLevelOrder(TreeNode.build(new Integer[]{3, 9, 20, 6, 8, 15, 7}));
        System.out.println(lists);
    }

}
