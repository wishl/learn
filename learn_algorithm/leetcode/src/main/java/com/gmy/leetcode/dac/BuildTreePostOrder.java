package com.gmy.leetcode.dac;

import com.gmy.leetcode.tree.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历，
 * postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuildTreePostOrder {

    private Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int l1, int r1, int l2, int r2) {
        if (l1 > r1) {
            return null;
        }
        if (l1 == r1) {
            return build(inorder[l1]);
        }
        int rootValue = postorder[r2];
        Integer rootIndex = indexMap.get(rootValue);
        TreeNode root = build(rootValue);
        int leftCount = rootIndex - l1 - 1;
        TreeNode leftNode = build(inorder, postorder, l1, rootIndex - 1, l2, l2 + leftCount);
        root.left = leftNode;
        TreeNode rightNode = build(inorder, postorder, rootIndex + 1, r1, l2 + leftCount + 1, r2 - 1);
        root.right = rightNode;
        return root;
    }

    private TreeNode build(int data) {
        TreeNode treeNode = new TreeNode(data);
        return treeNode;
    }

    public static void main(String[] args) {
        BuildTreePostOrder build = new BuildTreePostOrder();
        TreeNode treeNode = build.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(Arrays.toString(treeNode.toArray()));
    }
}
