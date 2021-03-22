package com.gmy.leetcode.review;

import com.gmy.leetcode.link.ListNode;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * https://leetcode.cn/problems/rotate-list/description/
 */
public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int n = calLength(head);
        k = k % n;
        if (k == 0) {
            return head;
        }
        ListNode listNode = calListNode(head, k);
        ListNode next = listNode.next;
        listNode.next = null;
        ListNode end = getEnd(next);
        end.next = head;
        return next;
    }

    private ListNode getEnd(ListNode node) {
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    private int calLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    private ListNode calListNode(ListNode listNode, int k) {
        ListNode fast = listNode, slow = listNode;
        while (fast != null && fast.next != null) {
            while (k > 0) {
                fast = fast.next;
                k--;
            }
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        RotateRight rotateRight = new RotateRight();
        ListNode build = ListNode.build(new int[]{1, 2, 3, 4, 5});
        ListNode listNode = rotateRight.rotateRight(build, 1);
        System.out.println(listNode);
    }
}
