package com.gmy.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 */
public class GetMinimumDifference {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 广度优先遍历
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        Queue<TreeNode> queue = new LinkedBlockingDeque<>();
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        while (queue.size() > 0) {
            TreeNode poll = queue.poll();
            list.add(poll.val);
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (Math.abs(list.get(j) - list.get(i)) < min) {
                    min = Math.abs(list.get(j) - list.get(i));
                }
            }
        }
        return min;
    }

    int pre;
    int ans;

    /**
     * 深度优先遍历
     */
    public int getMinimumDifference1(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != -1) {
            ans = Math.min(ans, root.val - pre);
        }
        pre = root.val;
        dfs(root.right);
    }

}
