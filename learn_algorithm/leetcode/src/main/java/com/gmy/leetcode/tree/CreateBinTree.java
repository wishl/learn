package com.gmy.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 */
public class CreateBinTree {

    static int target = 0;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode node = buildTree(0, inorder.length - 1, preorder, inorder);
        return node;
    }

    private static TreeNode buildTree(int s, int e, int[] preorder, int[] inorder) {
        if (s > e) {
            return null;
        }
        TreeNode node = null;
        for (int i = s; i <= e; ++i) {
            if (inorder[i] == preorder[target]) {
                node = new TreeNode(preorder[target++]);
                // 前面左子树
                node.left = buildTree(s, i - 1, preorder, inorder);
                // 后面右子树
                node.right = buildTree(i + 1, e, preorder, inorder);
                break;
            }
        }
        return node;
    }

    private static TreeNode buildTreeMap(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(0, inorder.length - 1, preorder, inorder, map);
    }

    private static TreeNode buildTree(int s, int e, int[] preorder, int[] inorder, Map<Integer, Integer> map) {
        if (s > e) {
            return null;
        }
        Integer rootIndex = map.get(preorder[target++]);
        TreeNode treeNode = new TreeNode(inorder[rootIndex]);
        treeNode.left = buildTree(s, rootIndex - 1, preorder, inorder, map);
        treeNode.right = buildTree(rootIndex + 1, e, preorder, inorder, map);
        return treeNode;
    }

    public static void main(String[] args) {
        int[] preorder = new int[] {1,2,4,8,9,5,3,6,7};
        int[] inorder = new int[] {8,4,9,2,5,1,6,3,7};
        TreeNode node = buildTreeMap(preorder, inorder);
        System.out.println(node);
    }

}
