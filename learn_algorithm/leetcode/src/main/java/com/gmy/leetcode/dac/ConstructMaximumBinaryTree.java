package com.gmy.leetcode.dac;

import com.gmy.leetcode.tree.TreeNode;

import java.util.Arrays;

/**
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 *
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int partition = partition(nums, left, right);
        TreeNode treeNode = new TreeNode(nums[partition]);
        treeNode.left = dfs(nums, left, partition - 1);
        treeNode.right = dfs(nums, partition + 1, right);
        return treeNode;
    }

    private int partition(int[] nums, int left, int right) {
        int prov = left;
        for (int i = prov + 1; i <= right; i++) {
            if (nums[prov] < nums[i]) {
                prov = i;
            }
        }
        return prov;
    }

    public static void main(String[] args) {
        int[] ints = new int[] {3,2,1,6,0,5};
        ConstructMaximumBinaryTree constructMaximumBinaryTree = new ConstructMaximumBinaryTree();
        TreeNode treeNode = constructMaximumBinaryTree.constructMaximumBinaryTree(ints);
        System.out.println(Arrays.toString(treeNode.toArray()));
    }

}
