package com.gmy.leetcode.top100;

import com.gmy.leetcode.link.ListNode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class _0206_ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null, tmp = head;
        while (tmp != null) {
            ListNode next = tmp.next;
            tmp.next = pre;
            pre = tmp;
            tmp = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        _0206_ReverseList reverseList = new _0206_ReverseList();
        ListNode result = reverseList.reverseList(ListNode.build(new int[]{1, 2, 3}));
        System.out.println(result);
    }

}
