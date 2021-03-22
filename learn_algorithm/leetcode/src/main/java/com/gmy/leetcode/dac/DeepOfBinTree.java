package com.gmy.leetcode.dac;

import com.gmy.leetcode.tree.TreeNode;

/**
 * 二叉树的最大深度
 */
public class DeepOfBinTree {

    /**
     * 二叉树最大的深度
     * @param treeNode
     * @return
     */
    public int deepOfBinTree(TreeNode treeNode) {
        return dfs(treeNode, 1);
    }

    public int dfs(TreeNode treeNode, int max) {
        if (treeNode == null) {
            return max - 1;
        }
        int left = dfs(treeNode.left, max + 1);
        int right = dfs(treeNode.right, max + 1);
        return Math.max(left, right);
    }

    /**
     * 二叉树的最深路径
     * @param treeNode
     * @return
     */
    public int pathOfBinTree(TreeNode treeNode) {
        return dfs1(treeNode, 0);
    }

    public int dfs1(TreeNode treeNode, int max) {
        if (treeNode == null) {
            return max == 0 ? 0 : max - 1;
        }
        int left = dfs1(treeNode.left, max + 1);
        int right = dfs1(treeNode.right, max + 1);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        DeepOfBinTree binTree = new DeepOfBinTree();
        int result = binTree.deepOfBinTree(TreeNode.build(new Integer[] {1}));
        int result1 = binTree.pathOfBinTree(TreeNode.build(new Integer[] {1}));
//        int result = binTree.deepOfBinTree(null);
        System.out.println(result);
        System.out.println(result1);
    }

}
