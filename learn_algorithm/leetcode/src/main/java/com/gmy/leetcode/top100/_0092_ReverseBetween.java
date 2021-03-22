package com.gmy.leetcode.top100;

import com.gmy.leetcode.link.ListNode;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
public class _0092_ReverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode hair = new ListNode();
        hair.next = head;
        ListNode start = getPre(hair, left - 1);
        ListNode end = getPre(hair, right + 1);
        ListNode revert = revert(start.next, end);
        start.next = revert;
        return hair.next;
    }


    private ListNode getPre(ListNode head, int index) {
        if (index <= 0) {
            return head;
        }
        while (index > 0) {
            head = head.next;
            index--;
        }
        return head;
    }

    private ListNode revert(ListNode listNode, ListNode end) {
        ListNode pre = end, tmp = listNode;
        while (tmp != end) {
            ListNode next = tmp.next;
            tmp.next = pre;
            pre = tmp;
            tmp = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        _0092_ReverseBetween reverseBetween = new _0092_ReverseBetween();
        ListNode result = reverseBetween.reverseBetween(ListNode.build(new int[]{1, 2, 3, 4, 5}), 1, 5);
        System.out.println(result);
    }

}
