package com.gmy.leetcode.top100;

import com.gmy.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class _0102_LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode pop = deque.pop();
                res.add(pop.val);
                if (pop.left != null) {
                    deque.offer(pop.left);
                }
                if (pop.right != null){
                    deque.offer(pop.right);
                }
            }
            result.add(res);
        }
        return result;
    }

    public static void main(String[] args) {
        _0102_LevelOrder levelOrder = new _0102_LevelOrder();
        List<List<Integer>> result = levelOrder.levelOrder(TreeNode.build(new Integer[]{3, 9, 20, null, null, 15, 7}));
        System.out.println(result);
    }

}
