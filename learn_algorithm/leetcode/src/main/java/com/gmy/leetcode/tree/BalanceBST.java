package com.gmy.leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一棵二叉搜索树，请你返回一棵平衡后的二叉搜索树，
 * 新生成的树应该与原来的树有着相同的节点值。如果有多种构造方法，请你返回任意一种。
 *
 * 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是平衡的 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/balance-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BalanceBST {

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        middleTree(root, list);
        TreeNode balance = balance(list, 0, list.size() - 1);
        return balance;
    }

    private void middleTree(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            middleTree(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            middleTree(root.right, list);
        }
    }

    private TreeNode balance(List<Integer> list, int left, int right) {
        int middle = (left + right) / 2;
        TreeNode rootNode = new TreeNode(list.get(middle));
        if (left < middle) {
            TreeNode leftNode = balance(list, left, middle - 1);
            rootNode.left = leftNode;
        }
        if (right > middle) {
            TreeNode rightNode = balance(list, middle + 1, right);
            rootNode.right = rightNode;
        }
        return rootNode;
    }

    public static void main(String[] args) {
//        TreeNode treeNode = TreeNode.build(new Integer[] {1,null,2,null,3,null,4,null,null});
        TreeNode treeNode = TreeNode.build(new Integer[] {2, 1, 3});
        BalanceBST balanceBST = new BalanceBST();
        TreeNode treeNode1 = balanceBST.balanceBST(treeNode);
        System.out.println(Arrays.toString(treeNode1.toArray()));
    }

}
