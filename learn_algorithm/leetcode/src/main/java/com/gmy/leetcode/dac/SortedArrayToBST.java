package com.gmy.leetcode.dac;

import com.gmy.leetcode.tree.TreeNode;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
       return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left <= right && left >= 0 && right < nums.length) {
            int mid = (left + right) / 2;
            TreeNode root = build(nums[mid]);
            TreeNode leftNode = build(nums, left, mid - 1);
            TreeNode rightNode = build(nums, mid + 1, right);
            root.left = leftNode;
            root.right = rightNode;
            return root;
        }
        return null;
    }

    private TreeNode build(int value) {
        return new TreeNode(value);
    }

    public static void main(String[] args) {
        SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
        System.out.println(Arrays.toString(sortedArrayToBST.sortedArrayToBST(new int[] {-10,-3,0,5,9}).toArray()));
    }

}
