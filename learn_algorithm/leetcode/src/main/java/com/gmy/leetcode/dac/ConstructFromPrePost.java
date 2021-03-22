package com.gmy.leetcode.dac;

import com.gmy.leetcode.tree.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，
 * postorder 是同一棵树的后序遍历，重构并返回二叉树。
 * 如果存在多个答案，您可以返回其中 任何 一个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConstructFromPrePost {

    private int index = 0;

    private Map<Integer, Integer> indexMap;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.indexMap = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            indexMap.put(postorder[i], i);
        }
        return build(preorder, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] postorder, int begin, int end) {
        if (begin > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index++]);
        if (index == preorder.length) {
            return root;
        }
        int leftEnd = indexMap.get(preorder[index]);
        if (leftEnd >= begin && leftEnd < end) {
            TreeNode left = build(preorder, postorder, begin, leftEnd);
            root.left = left;
        }
        if (index == preorder.length) {
            return root;
        }
        int rightEnd = indexMap.get(preorder[index]);
        if (rightEnd >= begin && rightEnd < end) {
            TreeNode right = build(preorder, postorder, leftEnd + 1, rightEnd);
            root.right = right;
        }
        return root;
    }

    public static void main(String[] args) {
        ConstructFromPrePost buildTree = new ConstructFromPrePost();
        TreeNode treeNode = buildTree.constructFromPrePost(new int[]{2,1}, new int[]{1,2});
        System.out.println(Arrays.toString(treeNode.toArray()));
    }

}
