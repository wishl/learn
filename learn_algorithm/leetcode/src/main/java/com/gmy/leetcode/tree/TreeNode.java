package com.gmy.leetcode.tree;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

public class TreeNode {

    public Integer val;
    public TreeNode left;
    public TreeNode right;
    private TreeNode(Integer x) { val = x; }

    public static TreeNode build(Integer[] is) {
        Queue<TreeNode> queue = new LinkedBlockingDeque<>();
        TreeNode root = new TreeNode(is[0]);
        queue.offer(root);
        for (int i = 0; i < is.length; i++) {
            TreeNode poll = queue.poll();
            for (int j = 2 * i + 1; j < 2 * i + 3 && j < is.length; j++) {
                Integer num = is[j];
                if (num == null) {
                    continue;
                }
                TreeNode node = new TreeNode(num);
                queue.offer(node);
                if (j == 2 * i + 1 ) {
                    poll.left = node;
                } else {
                    poll.right = node;
                }
            }

        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] is = new Integer[] {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode build = TreeNode.build(is);
        System.out.println(build);
    }

}
