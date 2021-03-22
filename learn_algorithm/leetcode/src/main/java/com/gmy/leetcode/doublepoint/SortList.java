package com.gmy.leetcode.doublepoint;

import com.gmy.leetcode.link.ListNode;

/**
 * 排序链表
 * https://leetcode.cn/problems/sort-list/
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        return sort(head);
    }

    private ListNode sort(ListNode begin) {
        if (begin.next != null) {
            ListNode midPre= findMid(begin);
            ListNode mid = midPre.next;
            midPre.next = null;
            ListNode node1 = sort(begin);
            ListNode node2 = sort(mid);
            return merge(node1, node2);
        }
        return begin;
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode hair = new ListNode();
        ListNode tmp = hair;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                tmp.next = node1;
                tmp = tmp.next;
                node1 = node1.next;
            } else {
                tmp.next = node2;
                tmp = tmp.next;
                node2 = node2.next;
            }
        }
        while (node1 != null) {
            tmp.next = node1;
            node1 = node1.next;
            tmp = tmp.next;
        }
        while (node2 != null) {
            tmp.next = node2;
            node2 = node2.next;
            tmp = tmp.next;
        }
        return hair.next;
    }

    private ListNode findMid(ListNode node) {
        ListNode fast = node, slow = node;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            if (fast == null) {
                return slow;
            }
            slow = slow.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.build(new int[] {-1,5,3,4,0});
        SortList sortList = new SortList();
        ListNode result = sortList.sortList(listNode);
        System.out.println(result);
    }

}
