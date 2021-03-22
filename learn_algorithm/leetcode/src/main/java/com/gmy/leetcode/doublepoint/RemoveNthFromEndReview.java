package com.gmy.leetcode.doublepoint;

import com.gmy.leetcode.link.ListNode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthFromEndReview {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode hair = new ListNode(0, head);
        ListNode fast = hair, slow = hair;
        while (fast.next != null) {
            if (n > 0) {
                fast = fast.next;
                n--;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        slow.next = slow.next.next;
        return hair.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        RemoveNthFromEndReview removeNthFromEndReview = new RemoveNthFromEndReview();
        ListNode result = removeNthFromEndReview.removeNthFromEnd(listNode, 1);
        System.out.println(result);
    }

}
