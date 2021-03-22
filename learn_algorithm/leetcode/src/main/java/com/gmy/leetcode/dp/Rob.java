package com.gmy.leetcode.dp;

import com.gmy.leetcode.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连
 * 。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 *
 * https://leetcode.cn/problems/house-robber-iii/?envType=daily-question&envId=2023-09-18
 */
public class Rob {

    public int rob(TreeNode root) {
        Map<TreeNode, Integer> fMap = new HashMap<>();
        Map<TreeNode, Integer> gMap = new HashMap<>();
        dfs(root, fMap, gMap);
        return Math.max(fMap.getOrDefault(root, 0), gMap.getOrDefault(root, 0));
    }

    private void dfs(TreeNode root, Map<TreeNode, Integer> fMap, Map<TreeNode, Integer> gMap) {
        if (root == null) {
            return;
        }
        dfs(root.left, fMap, gMap);
        dfs(root.right, fMap, gMap);
        fMap.put(root, root.val + gMap.getOrDefault(root.left, 0) + gMap.getOrDefault(root.right, 0));
        gMap.put(root, Math.max(gMap.getOrDefault(root.left, 0), fMap.getOrDefault(root.left, 0)
                + Math.max(fMap.getOrDefault(root.right, 0), gMap.getOrDefault(root.right, 0))));
    }


    public void dfs1(TreeNode root, Map<TreeNode, Integer> fMap, Map<TreeNode, Integer> gMap) {
        if (root == null) {
            return;
        }
        dfs1(root.left, fMap, gMap);
        dfs1(root.right, fMap, gMap);
        fMap.put(root, root.val + gMap.getOrDefault(root.left, 0) + gMap.getOrDefault(root.right, 0));
        gMap.put(root, Math.max(fMap.getOrDefault(root.left, 0), gMap.getOrDefault(root.left, 0))
                + Math.max(fMap.getOrDefault(root.right, 0), gMap.getOrDefault(root.right, 0)));
    }


}
