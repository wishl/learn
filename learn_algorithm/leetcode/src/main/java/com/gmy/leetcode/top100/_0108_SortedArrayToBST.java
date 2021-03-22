package com.gmy.leetcode.top100;

import com.gmy.leetcode.tree.TreeNode;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵平衡二叉搜索树。
 */
public class _0108_SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode();
        root.val = nums[mid];
        TreeNode left = build(nums, start, mid - 1);
        TreeNode right = build(nums, mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }

}
