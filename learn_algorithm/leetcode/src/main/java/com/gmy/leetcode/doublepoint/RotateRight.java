package com.gmy.leetcode.doublepoint;

import com.gmy.leetcode.link.ListNode;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * https://leetcode.cn/problems/rotate-list/
 */
public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode hair = new ListNode(0, head);
        ListNode fast = hair, slow = hair;
        ListNode h = head;
        int length = 0;
        while (h != null) {
            h = h.next;
            length++;
        }
        k = k % length;
        while (fast.next != null) {
            if (k > 0) {
                fast = fast.next;
                k--;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        fast.next = hair.next;
        hair.next = slow.next;
        slow.next = null;
        return hair.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0,1,2);
        RotateRight rotateRight = new RotateRight();
        ListNode listNode1 = rotateRight.rotateRight(listNode, 3);
        System.out.println(listNode1);
    }

}
