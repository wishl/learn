package com.gmy.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class BuildAvl {

    private Map<TreeNode, Integer> highMap = new HashMap<>();

    private TreeNode root = null;

    private TreeNode insert(TreeNode node, int val) {
        if (node == null) {
            node = new TreeNode(val);
            highMap.put(node, 1);
            return node;
        }
        // 插入左子树
        if (node.val < val) {
            TreeNode insert = insert(node.left, val);
            node.left = insert;
            // 判断当前node 左右子数差距是否 > 1 当前插入左子树 肯定是左边大于右边
            if (highMap.getOrDefault(node.left, 0) - highMap.getOrDefault(node.right, 0) > 1) {
                // 新加入节点为 node.left 的右孩子， height(node.left) - height(node.right) > 1 。
                // 这时候要先对node.left左旋，调整为1的情况，再进行右旋。
                if (val > node.left.val) {
                    TreeNode treeNode = leftRotate(node.left);
                    node.left = treeNode;
                }
                // 新加入节点为 node.left 的左孩子， height(node.left) - height(node.right) > 1 。直接对node节点右旋。
                node = rightRotate(node.left);
            }
        } else if (node.val > val) {

        } else {
            return node;
        }
        int curNodeNewHeight = getCurNodeNewHeight(node);
        highMap.put(node, curNodeNewHeight);
        return node;
    }

    /**
     * 左旋
     * @return
     */
    private TreeNode leftRotate(TreeNode treeNode) {
        TreeNode node = treeNode;
        TreeNode right = treeNode.right;
        if (right == null) {
            throw new IllegalArgumentException();
        }
        node.right = right.left;
        right.left = node;
        //
        return right;
    }

    /**
     * 右旋
     * @param args
     */
    private TreeNode rightRotate(TreeNode treeNode) {
        TreeNode node = treeNode;
        TreeNode left = treeNode.left;
        if (left == null) {
            throw new IllegalArgumentException();
        }
        node.left = left.right;
        left.right = node;
        return left;
    }

    private int getCurNodeNewHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(highMap.getOrDefault(node.left, 0), highMap.getOrDefault(node.right, 0)) + 1;
    }

}
