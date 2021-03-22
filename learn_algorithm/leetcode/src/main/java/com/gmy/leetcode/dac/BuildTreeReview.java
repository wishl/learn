package com.gmy.leetcode.dac;

import com.gmy.leetcode.tree.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/
 */
public class BuildTreeReview {

    private Map<Integer, Integer> indexMap;
    private int index;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int left, int right) {
        if (left > right) {
            return null;
        }
        int rootData = preorder[index++];
        Integer rootIndex = indexMap.get(rootData);
        TreeNode root = new TreeNode(rootData);
        TreeNode leftNode = build(preorder, inorder, left, rootIndex - 1);
        TreeNode rightNode = build(preorder, inorder, rootIndex + 1, right);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{-1};
        int[] inorder = new int[] {-1};
        BuildTreeReview review = new BuildTreeReview();
        TreeNode treeNode = review.buildTree(preorder, inorder);
        System.out.println(Arrays.toString(treeNode.toArray()));
    }

}
