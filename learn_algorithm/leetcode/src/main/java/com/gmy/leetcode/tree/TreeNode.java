package com.gmy.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

public class TreeNode {

    public Integer val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(Integer x) { val = x; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public TreeNode() {}

    public static TreeNode build(Integer[] is) {
        Queue<TreeNode> queue = new LinkedBlockingDeque<>();
        TreeNode root = new TreeNode(is[0]);
        queue.offer(root);
        for (int i = 0; i < is.length; i++) {
            TreeNode poll = queue.poll();
            for (int j = 2 * i + 1; j < 2 * i + 3 && j < is.length; j++) {
                Integer num = is[j];
                if (num == null) {
                    continue;
                }
                TreeNode node = new TreeNode(num);
                queue.offer(node);
                if (j == 2 * i + 1 ) {
                    poll.left = node;
                } else {
                    poll.right = node;
                }
            }

        }
        return root;
    }

    public Integer[] toArray() {
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode node = this;
        deque.offer(node);
        List<Integer> list = new ArrayList();
        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            list.add(poll.val);
            if (poll.val != null) {
                saveOffer(poll.left, deque);
                saveOffer(poll.right, deque);
            }
        }
        Integer[] is = new Integer[list.size()];
        return list.toArray(is);
    }

    private void saveOffer(TreeNode treeNode, Deque deque) {
        if (treeNode == null) {
            deque.offer(new TreeNode());
            return;
        }
        deque.offer(treeNode);
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    public void postOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.val);
    }

//    @Override
//    public String toString() {
//        return Arrays.toString(toArray());
//    }

    public static void main(String[] args) {
        Integer[] is = new Integer[] {1, null, 2, null, 3, null, 4};
        TreeNode build = TreeNode.build(is);
        List<Integer> res = new ArrayList<>();
        build.postOrder(build, res);
        System.out.println(res);
    }


}
