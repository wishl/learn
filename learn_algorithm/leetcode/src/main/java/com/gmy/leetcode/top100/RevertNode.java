package com.gmy.leetcode.top100;

import com.gmy.leetcode.link.ListNode;

/**
 * 翻转链表
 */
public class RevertNode {

    public static ListNode revert(ListNode node) {
        ListNode tmp = node, pre = null;
        while (tmp != null) {
            ListNode next = tmp.next;
            tmp.next = pre;
            pre = tmp;
            tmp = next;
        }
        return pre;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.build(new int[] {1, 2, 3, 4, 5});
        ListNode revert = revert(node);
        System.out.println(revert);
    }
}
