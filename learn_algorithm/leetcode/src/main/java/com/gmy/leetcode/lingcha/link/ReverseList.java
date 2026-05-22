package com.gmy.leetcode.lingcha.link;

import com.gmy.leetcode.link.ListNode;

/**
 * 给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。
 */
public class ReverseList {

    /**
     *
     * null - 1 - 2 - 3
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
