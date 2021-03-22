package com.gmy.leetcode.dfs;

import com.gmy.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSum {

    private List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        if (root == null) {
            return this.result;
        }
        dfs(root, targetSum - root.val, new ArrayList<>());
        return this.result;
    }

    private void dfs(TreeNode root, int targetSum, List<Integer> result) {
        result.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                this.result.add(new ArrayList<>(result));
            }
            return;
        }
        if (root.left != null) {
            dfs(root.left, targetSum - root.left.val, result);
            result.remove(result.size() - 1);
        }
        if (root.right != null) {
            dfs(root.right, targetSum - root.right.val, result);
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) {
        Integer[] is = {-2,null,-3};
        TreeNode build = TreeNode.build(is);
        PathSum pathSum = new PathSum();
        List<List<Integer>> lists = pathSum.pathSum(build, -5);
        System.out.println(lists);
    }
}
