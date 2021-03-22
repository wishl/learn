package com.gmy.leetcode.dac;

import com.gmy.leetcode.tree.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 */
public class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        return cal(root, 0, new HashMap<>());
    }

    int ans;
    public int diameterOfBinaryTree1(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }


    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L + R);
        return Math.max(L, R) + 1;
    }

    /**
     * 计算最大路径
     * @param treeNode
     * @param max
     * @return
     */
    private int cal(TreeNode treeNode, int max, Map<TreeNode, Integer> cache) {
        if (treeNode == null) {
            return max;
        }
        int leftPath = dfs(treeNode.left, 1, cache, 1);
        int rightPath = dfs(treeNode.right, 1, cache, 1);
        int left = cal(treeNode.left, Math.max(max, (leftPath + rightPath)), cache);
        int right = cal(treeNode.right, Math.max(max, (leftPath + rightPath)), cache);
        return Math.max(left, right);
    }

    /**
     * 计算treeNode的path
     * @param treeNode
     * @param max
     * @return
     */
    private int dfs(TreeNode treeNode, int max, Map<TreeNode, Integer> cache, int time) {
        if (treeNode == null) {
            return max == 0 ? 0 : max - 1;
        }
        if (cache.containsKey(treeNode)) {
            return cache.get(treeNode) + time;
        }
        int left = dfs(treeNode.left, max + 1, cache, time + 1);
//        cache.putIfAbsent(treeNode, left - time);
        int right = dfs(treeNode.right, max+ 1, cache, time + 1);
//        cache.putIfAbsent(treeNode, right - time);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        int i = diameterOfBinaryTree.diameterOfBinaryTree1(TreeNode.build(new Integer[]{1, 2, 3, 4, 5}));
//        int i = diameterOfBinaryTree.diameterOfBinaryTree1(TreeNode.build(new Integer[]{4,-7,-3,null,null,-9,-3,9,-7,-4}));
        System.out.println(i);
    }
}
