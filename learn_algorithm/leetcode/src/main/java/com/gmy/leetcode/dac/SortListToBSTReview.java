package com.gmy.leetcode.dac;

import com.gmy.leetcode.link.ListNode;
import com.gmy.leetcode.tree.TreeNode;

import java.util.Arrays;

/**
 * 给定一个单链表的头节点 head，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差不超过 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortListToBSTReview {

    public TreeNode sortedListToBST(ListNode head) {
        return build(head, null);
    }

    private TreeNode build(ListNode head, ListNode end) {
        if (head == end) {
            return null;
        }
        ListNode mid = findMid(head, end);
        TreeNode root = build(mid.val);
        TreeNode leftNode = build(head, mid);
        root.left = leftNode;
        TreeNode rightNode = build(mid.next, end);
        root.right = rightNode;
        return root;
    }

    private TreeNode build(int num) {
        return new TreeNode(num);
    }

    private static ListNode findMid(ListNode head, ListNode end) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != end && fast.next != end) {
            fast = fast.next;
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        SortListToBSTReview sortListToBSTReview = new SortListToBSTReview();
        TreeNode treeNode = sortListToBSTReview.sortedListToBST(ListNode.build(new int[]{-10, -3, 0, 5, 9}));
        System.out.println(Arrays.toString(treeNode.toArray()));
    }

//    public static void main(String[] args) {
//        ListNode build = ListNode.build(new int[]{-10, -3, 0, 5, 9});
//        ListNode mid1 = findMid1(build, build.next.next);
//        System.out.println(mid1);
//    }
}
