package com.gmy.leetcode.top100;

import com.gmy.leetcode.tree.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组 preorder 和 inorder ，
 * 其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 *
 * todo review
 */
public class _0105_BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> cache = new HashMap<>();
        Map<Integer, Integer> inorderCache = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            cache.put(inorder[i], i);
        }
        TreeNode result = dfs(preorder, inorder, 0, inorder.length - 1, 0, cache);
        return result;
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int start, int end, int i, Map<Integer, Integer> cache) {
        if (i < 0 || i >= inorder.length) {
            return null;
        }
        int val = preorder[i];
        Integer index = cache.get(val);
        if (index < start || index > end) {
            return null;
        }
        TreeNode treeNode = new TreeNode();
        treeNode.val = val;
        if (index - 1 <= start) {
            TreeNode left = dfs(preorder, inorder, start, index - 1, ++i, cache);
            treeNode.left = left;
        }
        if (index + 1 >= start && index + 1 <= end) {
            TreeNode right = dfs(preorder, inorder, index + 1, end, ++i, cache);
            treeNode.right = right;
        }
        return treeNode;
    }

    public static void main(String[] args) {
        _0105_BuildTree buildTree = new _0105_BuildTree();
        TreeNode result = buildTree.buildTree(new int[]{1,2}, new int[]{1, 2});
        System.out.println(Arrays.toString(result.toArray()));
    }

}
