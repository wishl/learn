package com.gmy.leetcode.dac;

import com.gmy.leetcode.tree.TreeNode;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortedArrayToBSTReview {


    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return build(nums[left]);
        }
        int mid = (left + right) / 2;
        TreeNode root = build(nums[mid]);
        TreeNode leftNode = build(nums, left, mid - 1);
        root.left = leftNode;
        TreeNode rightNode = build(nums, mid + 1, right);
        root.right = rightNode;
        return root;
    }

    private TreeNode build(int num) {
        return new TreeNode(num);
    }

    public static void main(String[] args) {
        SortedArrayToBSTReview review = new SortedArrayToBSTReview();
        TreeNode treeNode = review.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(Arrays.toString(treeNode.toArray()));
    }

}
