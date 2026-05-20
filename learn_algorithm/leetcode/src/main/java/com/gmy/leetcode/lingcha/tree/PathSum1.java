package com.gmy.leetcode.lingcha.tree;

import com.gmy.leetcode.tree.TreeNode;

/**
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * https://leetcode.cn/problems/6eUYwP/description/
 * todo 解决
 */
public class PathSum1 {

    private int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        find(root, targetSum, 0);
        return count;
    }

    private int find(TreeNode root, int targetSum, int sum) {
        if (root == null) {
            return sum;
        }
        int sumLeft = find(root.left, targetSum, sum + root.val);
        int sumRight = find(root.right, targetSum, sum + root.val);
        if (sumRight == targetSum) {
            count++;
        }
        if (sumLeft == targetSum) {
            count++;
        }
        if (sumLeft - sum == targetSum) {
            count++;
        }
        if (sumRight - sum == targetSum) {
            count++;
        }
        return sum + root.val;
    }


    public static void main(String[] args) {
        PathSum1 pathSum = new PathSum1();
        int result = pathSum.pathSum(TreeNode.build(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1}), 8);
        System.out.println(result);
    }
}
