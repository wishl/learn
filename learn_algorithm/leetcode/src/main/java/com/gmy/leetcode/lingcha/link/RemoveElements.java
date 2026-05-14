package com.gmy.leetcode.lingcha.link;

import com.gmy.leetcode.link.ListNode;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 * https://leetcode.cn/problems/remove-linked-list-elements/description/
 */
public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode cur = hair;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return hair.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(7,7,7,7);
        RemoveElements removeElements = new RemoveElements();
        ListNode result = removeElements.removeElements(head, 7);
        System.out.println(result);
    }
}
