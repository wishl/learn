package com.gmy.leetcode.string;

import com.gmy.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 前序恢复搜索树
 */
public class CodecReviewPreOrder {

    /**
     * 后序遍历在比较大小恢复
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        String s = list.toString();
        return s.substring(1, s.length() - 1);
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] split = data.split(",");
        Deque<Integer> deque = new ArrayDeque<>();
        for (String s : split) {
            deque.offer(Integer.parseInt(s.trim()));
        }
        return revertTreeNode(Integer.MAX_VALUE, Integer.MIN_VALUE, deque);
    }

    /**
     * 前序 根 左 右
     * @param root
     * @param list
     */
    private void preorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    private TreeNode revertTreeNode(int max, int min, Deque<Integer> deque) {
        if (deque.isEmpty() || deque.peek() >= max || deque.peek() <= min) {
            return null;
        }
        Integer poll = deque.poll();
        TreeNode root = new TreeNode(poll);
        TreeNode left = revertTreeNode(poll, min, deque);
        TreeNode right = revertTreeNode(max, poll, deque);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        CodecReviewPreOrder codec = new CodecReviewPreOrder();
//        TreeNode root = TreeNode.build(new Integer[]{5,3,6,2,4,null,null,1});
        TreeNode root = TreeNode.build(new Integer[]{5,3,6,2,4,null,null,1});
        String serialize = codec.serialize(root);
        TreeNode deserialize = codec.deserialize(serialize);
        System.out.println(Arrays.toString(deserialize.toArray()));
    }
}
