package com.gmy.leetcode.top100;

import com.gmy.leetcode.link.ListNode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 */
public class _0019_RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode hair = new ListNode(0, head) ,fast = hair, slow = hair;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return hair.next;
    }

    public static void main(String[] args) {
        _0019_RemoveNthFromEnd removeNthFromEnd = new _0019_RemoveNthFromEnd();
        ListNode result = removeNthFromEnd.removeNthFromEnd(ListNode.build(new int[]{1,2}), 1);
        System.out.println(result);
    }

}
