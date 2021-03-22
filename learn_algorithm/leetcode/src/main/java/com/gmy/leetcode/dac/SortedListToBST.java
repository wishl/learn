package com.gmy.leetcode.dac;

import com.gmy.leetcode.link.ListNode;
import com.gmy.leetcode.tree.TreeNode;

import java.util.List;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortedListToBST {

    /**
     * 切分链表，然后创建二叉树
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        return build(head, null);
    }

    public TreeNode build(ListNode head, ListNode listNode) {
        if (head != listNode) {
            ListNode l1 = head;
            ListNode l2 = head;
            while (l1 != listNode && l1.next != listNode) {
                l1 = l1.next.next;
                l2 = l2.next;
            }
            TreeNode root = build(l2.val);
            TreeNode left = build(head, l2);
            TreeNode right = build(l2.next, listNode);
            root.left = left;
            root.right = right;
            return root;
        }
        return null;
    }

    private TreeNode build(int value) {
        return new TreeNode(value);
    }

    public static void main(String[] args) {
        SortedListToBST sortedListToBST = new SortedListToBST();
        TreeNode treeNode = sortedListToBST.sortedListToBST(ListNode.build(new int[]{-10, -3, 0, 5, 9}));
        System.out.println(treeNode);
    }


}
