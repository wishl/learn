package com.gmy.leetcode.top100;

import com.gmy.leetcode.link.ListNode;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class _0025_ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode();
        hair.next = head;
        ListNode pre = hair;
        ListNode nextPre = head;
        int count = k;
        while (head != null) {
            // 1, 2, 3
            while (count > 0 && head != null) {
                head = head.next;
                count--;
            }
            if (count == 0) {
                ListNode revert = revert(pre.next, head);
                pre.next = revert;
                pre = nextPre;
                nextPre = head;
                count = k;
            } else {
                break;
            }
        }
        return hair.next;
    }

    private ListNode revert(ListNode head, ListNode end) {
        ListNode pre = end, tmp = head;
        while (tmp != end) {
            ListNode next = tmp.next;
            tmp.next = pre;
            pre = tmp;
            tmp = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        _0025_ReverseKGroup reverseKGroup = new _0025_ReverseKGroup();
        ListNode result = reverseKGroup.reverseKGroup(ListNode.build(new int[]{1, 2, 3, 4, 5}), 5);
        System.out.println(result);
    }



}
