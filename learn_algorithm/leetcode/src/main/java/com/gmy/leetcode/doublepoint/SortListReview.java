package com.gmy.leetcode.doublepoint;

import com.gmy.leetcode.link.ListNode;

public class SortListReview {

    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }

    private ListNode sort(ListNode begin, ListNode end) {
        if (begin != end) {
            ListNode mid = findMid(begin, end);
            ListNode next = mid.next;
            mid.next = null;
            ListNode node1 = sort(begin, mid);
            ListNode node2 = sort(next, end);
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

    public ListNode findMid(ListNode listNode, ListNode end) {
        ListNode fast = listNode, slow = listNode;
        while (fast != end) {
            fast = fast.next;
            if (fast != end) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.build(new int[] {4,3,2,1});
        SortListReview sortList = new SortListReview();
        ListNode result = sortList.sortList(listNode);
        System.out.println(result);
    }


}
