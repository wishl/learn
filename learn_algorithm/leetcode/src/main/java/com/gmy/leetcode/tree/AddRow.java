package com.gmy.leetcode.tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。
 *
 * 添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为 v 的左子树和右子树。
 *
 * 将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。
 *
 * 如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-one-row-to-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddRow {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        Queue<TreeNode> queue = new LinkedBlockingDeque<>();
        queue.offer(root);
        for (int i = 0; i < d; i++) {
            int size = queue.size();
            if (i > d - 1) {
                return root;
            }
            for (int j = 0; j < size; j++) {
                TreeNode parent = queue.poll();
                if (parent.left != null) {
                    queue.offer(parent.left);
                }
                if (parent.right != null) {
                    queue.offer(parent.right);
                }
                if (i == d - 2) {
                    TreeNode vLeft = new TreeNode(v);
                    vLeft.left = parent.left;
                    TreeNode vRight = new TreeNode(v);
                    vRight.right = parent.right;
                    parent.left = vLeft;
                    parent.right = vRight;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        root.left = left;
        TreeNode right = new TreeNode(6);
        root.right = right;
        TreeNode leftLeft = new TreeNode(3);
        left.left = leftLeft;
        TreeNode leftRight = new TreeNode(1);
        left.right = leftRight;
        TreeNode rightLeft = new TreeNode(5);
        right.left = rightLeft;
        addOneRow(root, 1, 2);
        System.out.println(root);
    }



}
