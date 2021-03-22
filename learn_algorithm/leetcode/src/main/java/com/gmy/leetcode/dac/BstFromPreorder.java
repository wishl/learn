package com.gmy.leetcode.dac;

import com.gmy.leetcode.tree.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个整数数组，它表示BST(即 二叉搜索树 )的 先序遍历 ，构造树并返回其根。
 * 保证 对于给定的测试用例，总是有可能找到具有给定需求的二叉搜索树。
 * 二叉搜索树 是一棵二叉树，其中每个节点，Node.left的任何后代的值 严格小于 Node.val,Node.right的任何后代的值 严格大于 Node.val。
 * 二叉树的 前序遍历 首先显示节点的值，然后遍历Node.left，最后遍历Node.right。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/construct-binary-search-tree-from-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BstFromPreorder {

    private int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int max) {
        if (preorder.length <= index) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        if (preorder.length > (index + 1) && preorder[index + 1] < preorder[index]) {
            index++;
            TreeNode left = build(preorder, root.val);
            root.left = left;
        }
        if (preorder.length > (index + 1) && preorder[index + 1] > preorder[index] && preorder[index + 1] < max) {
            index++;
            TreeNode right = build(preorder, max);
            root.right = right;
        }
        return root;
    }

    private TreeNode build(int[] preorder) {
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode treeNode = new TreeNode(Integer.MAX_VALUE);
        deque.push(treeNode);
        for (int i = 0; i < preorder.length; i++) {
            TreeNode pre = deque.peek();
            while (preorder[i] > deque.peek().val) {
                pre = deque.pop();
            }
            TreeNode node = new TreeNode(preorder[i]);
            if (preorder[i] > pre.val) {
                pre.right = node;
            } else {
                pre.left = node;
            }
            deque.push(node);
        }
        return treeNode.left;
    }

    public static void main(String[] args) {
        BstFromPreorder bstFromPreorder = new BstFromPreorder();
//        TreeNode treeNode = bstFromPreorder.bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
        TreeNode treeNode1 = bstFromPreorder.build(new int[]{8, 5, 1, 7, 10, 12});
        System.out.println(Arrays.toString(treeNode1.toArray()));
    }


}
