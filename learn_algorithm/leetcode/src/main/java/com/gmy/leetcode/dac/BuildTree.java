package com.gmy.leetcode.dac;

import com.gmy.leetcode.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组preorder 和 inorder，其中preorder 是二叉树的先序遍历， inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuildTree {

    private Map<Integer, Integer> inorderIndexMap;

    private int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int left, int right) {
        if (right < 0 || left < 0 || index == inorder.length || left > right) {
            return null;
        }
        if (right == left) {
            index++;
            return build(inorder[left]);
        }
        int root = preorder[index++];
        Integer rootIndex = inorderIndexMap.get(root);
        TreeNode leftNode = build(preorder, inorder, left, rootIndex - 1);
        TreeNode rightNode = build(preorder, inorder, rootIndex + 1, right);
        TreeNode tree = build(inorder[rootIndex]);
        tree.left = leftNode;
        tree.right = rightNode;
        return tree;
    }

    private TreeNode build(int val) {
        return new TreeNode(val);
    }

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
//        TreeNode treeNode = buildTree.buildTree(new int[]{4, 1, 2, 3}, new int[]{1, 2, 3, 4});
        TreeNode treeNode = buildTree.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9,3,15,20,7});
//        TreeNode treeNode = buildTree.buildTree(new int[]{3,2,1,4}, new int[]{1,2,3,4});
        System.out.println(treeNode);
    }

}
