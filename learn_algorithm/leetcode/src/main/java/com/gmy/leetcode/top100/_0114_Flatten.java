package com.gmy.leetcode.top100;

import com.gmy.leetcode.tree.TreeNode;

import java.util.Arrays;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * todo review
 */
public class _0114_Flatten {

    private TreeNode pre = null;


    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

    public static void main(String[] args) {
        _0114_Flatten flatten = new _0114_Flatten();
        TreeNode build = TreeNode.build(new Integer[]{1, 2, 5, 3, 4, null, 6});
        flatten.flatten(build);
        System.out.println(Arrays.toString(build.toArray()));
    }

}
