package com.gmy.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你 root1 和 root2 这两棵二叉搜索树。
 *
 * 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
 *
 * https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/
 */
public class TreeSort {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> before1 = new ArrayList<>();
        before(root1, before1);
        List<Integer> before2 = new ArrayList<>();
        before(root2, before2);
        return summary(before1, before2);
    }

    private static void before(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        before(root.left, list);
        list.add(root.val);
        before(root.right, list);
    }

    private static List<Integer> summary(List<Integer> before1, List<Integer> before2) {
        List<Integer> result = new ArrayList<>();
        int size1 = before1.size();
        int size2 = before2.size();
        int i = 0, j = 0;
        while (i < size1 || j < size2) {
            Integer i1 = null;
            if (i < size1) {
                i1 = before1.get(i);
            }
            Integer j1 = null;
            if (j < size2) {
                j1 = before2.get(j);
            }
            if (j1 == null) {
                result.add(i1);
                i++;
                continue;
            }
            if (i1 == null) {
                result.add(j1);
                j++;
                continue;
            }
            if (i1 < j1) {
                i++;
                result.add(i1);
            } else {
                j++;
                result.add(j1);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        root.left = left;
        TreeNode right = new TreeNode(6);
        root.right = right;
        TreeNode leftLeft = new TreeNode(1);
        left.left = leftLeft;
        TreeNode leftRight = new TreeNode(3);
        left.right = leftRight;
        TreeNode rightLeft = new TreeNode(5);
        right.left = rightLeft;
        List<Integer> list = getAllElements(root, root);
        System.out.println(list);
    }


}
