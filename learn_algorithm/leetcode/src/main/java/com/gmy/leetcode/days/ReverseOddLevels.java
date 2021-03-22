package com.gmy.leetcode.days;

import com.gmy.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给你一棵 完美 二叉树的根节点 root ，请你反转这棵树中每个 奇数 层的节点值。
 * 例如，假设第 3 层的节点值是 [2,1,3,4,7,11,29,18] ，那么反转后它应该变成 [18,29,11,7,4,3,1,2] 。
 * 反转后，返回树的根节点。
 * 完美 二叉树需满足：二叉树的所有父节点都有两个子节点，且所有叶子节点都在同一层。
 * 节点的 层数 等于该节点到根节点之间的边数。
 */
public class ReverseOddLevels {

    public TreeNode reverseOddLevels(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<TreeNode> list = new ArrayList<>();
        int level = 0, index = 0;
        deque.offer(root);
        while (!deque.isEmpty()) {
            if (index > 0) {

            }
        }
        return root;
    }

}
