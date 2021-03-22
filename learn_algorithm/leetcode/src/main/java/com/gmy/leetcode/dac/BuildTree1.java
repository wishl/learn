package com.gmy.leetcode.dac;

import com.gmy.leetcode.tree.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗二叉树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuildTree1 {

    private Map<Integer, Integer> indexMap = new HashMap<>();

    private int index;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        index = inorder.length - 1;
        return build(inorder, postorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder, int left, int right) {
        if (left < 0 || right < 0 || left > right || index < 0) {
            return null;
        }
        if (right == left) {
            index--;
            return build(inorder[left]);
        }
        int rootValue = postorder[index--];
        Integer rootIndex = indexMap.get(rootValue);
        TreeNode root = build(rootValue);
        TreeNode rightNode = build(inorder, postorder, rootIndex + 1, right);
        TreeNode leftNode = build(inorder, postorder, left, rootIndex - 1);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    private TreeNode build(int val) {
        return new TreeNode(val);
    }

    public static void main(String[] args) {
        BuildTree1 buildTree1 = new BuildTree1();
        TreeNode treeNode = buildTree1.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(Arrays.toString(treeNode.toArray()));
    }

}
