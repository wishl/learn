package com.gmy.leetcode.bfs;

import com.gmy.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * https://leetcode-cn.com/problems/same-tree/solution/
 */
public class IsSameTree {

    private TreeNode EMPTY = new TreeNode(-1);

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (q == null && p == null) {
            return true;
        } else if (q == null || p == null) {
            return false;
        }
        Deque<TreeNode> peque = new ArrayDeque<>();
        peque.offer(p);
        Deque<TreeNode> qeque = new ArrayDeque<>();
        qeque.offer(q);
        while (!peque.isEmpty() && !peque.isEmpty()) {
            int size = peque.size();
            for (int i = 0; i < size; i++) {
                TreeNode pPoll = peque.poll();
                TreeNode qPoll = qeque.poll();
                if (pPoll.val != qPoll.val) {
                    return false;
                }
                if (pPoll != EMPTY) {
                    saveOffer(pPoll.left, peque);
                    saveOffer(pPoll.right, peque);
                }
                if (qPoll != EMPTY) {
                    saveOffer(qPoll.left, qeque);
                    saveOffer(qPoll.right, qeque);
                }
            }
        }
        return true;
    }

    public boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return dfs(p.left, q.left) && dfs(p.right, q.right);
        }
    }

    private void saveOffer(TreeNode treeNode, Deque<TreeNode> deque) {
        if (treeNode == null) {
            deque.offer(EMPTY);
            return;
        }
        deque.offer(treeNode);
    }

    public static void main(String[] args) {
        IsSameTree isSameTree = new IsSameTree();
        boolean sameTree = isSameTree.dfs(TreeNode.build(new Integer[]{1, 2}), TreeNode.build(new Integer[]{1, null, 2}));
        System.out.println(sameTree);
    }
}
