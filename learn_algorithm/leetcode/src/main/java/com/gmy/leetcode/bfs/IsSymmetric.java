package com.gmy.leetcode.bfs;

import com.gmy.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class IsSymmetric {

    private TreeNode EMPTY = new TreeNode(-200);

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        Deque<TreeNode> deque = new LinkedBlockingDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                result.add(poll.val);
                if (poll != EMPTY) {
                    saveOffer(poll.left, deque);
                    saveOffer(poll.right, deque);
                }
            }
            for (int i = 0; i < result.size(); i++) {
                if (result.get(i) != result.get(result.size() - i - 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void saveOffer(TreeNode treeNode, Deque<TreeNode> deque) {
        if (treeNode == null) {
            deque.offer(EMPTY);
            return;
        }
        deque.offer(treeNode);
    }

    public static void main(String[] args) {
        IsSymmetric isSymmetric = new IsSymmetric();
        boolean symmetric = isSymmetric.isSymmetric(TreeNode.build(new Integer[]{1,2,2,3,4,4,3}));
        System.out.println(symmetric);
    }
}
