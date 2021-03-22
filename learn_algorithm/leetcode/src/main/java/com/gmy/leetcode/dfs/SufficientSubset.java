package com.gmy.leetcode.dfs;

import com.gmy.leetcode.tree.TreeNode;

import java.util.Arrays;

/**
 * 给你二叉树的根节点 root 和一个整数 limit ，请你同时删除树中所有 不足节点 ，并返回最终二叉树的根节点。
 *
 * 假如通过节点 node 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 limit，则该节点被称之为 不足节点 ，需要被删除。
 *
 * 叶子节点，就是没有子节点的节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/insufficient-nodes-in-root-to-leaf-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SufficientSubset {

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        TreeNode treeNode = new TreeNode(0, root, null);
        dfs(treeNode, 0, limit);
        return treeNode.left;
    }

    private boolean dfs(TreeNode root, int sum, int total) {
        if (root == null) {
            return true;
        }
        if (root.left != null || root.right != null) {
            boolean deleteLeft = dfs(root.left, sum + root.val, total);
            boolean deleteRight = dfs(root.right, sum + root.val, total);
            if (deleteLeft) {
                root.left = null;
            }
            if (deleteRight) {
                root.right = null;
            }
            return deleteLeft && deleteRight;
        }
        return sum + root.val < total;
    }

    public static void main(String[] args) {
        SufficientSubset sufficientSubset = new SufficientSubset();
        TreeNode treeNode = sufficientSubset.sufficientSubset(TreeNode.build(new Integer[]{1, 2, 3, 4, -99, -99, 5}), 4);
        System.out.println(treeNode == null ? "[]" : Arrays.toString(treeNode.toArray()));
    }

}
