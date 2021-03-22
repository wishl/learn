package com.gmy.leetcode.divide;

import com.gmy.leetcode.link.ListNode;


public class SortListReview {

    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }

    public ListNode sort(ListNode head, ListNode tail) {
        if (head != tail) {
            ListNode mid = getMid(head, tail);
            ListNode next = mid.next;
            mid.next = null;
            ListNode sort = sort(head, mid);
            ListNode sort1 = sort(next, tail);
            return mergeListNode(sort, sort1);
        }
        return head;
    }

    public ListNode getMid(ListNode listNode, ListNode end) {
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

    public ListNode mergeListNode(ListNode node1, ListNode node2) {
        ListNode hair = new ListNode(), hairTmp = hair;
        ListNode tmp1 = node1, tmp2 = node2;
        while (tmp1 != null && tmp2 != null) {
            if (tmp1.val < tmp2.val) {
                hair.next = tmp1;
                tmp1 = tmp1.next;
            } else {
                hair.next = tmp2;
                tmp2 = tmp2.next;
            }
            hair = hair.next;
        }
        while (tmp1 != null) {
            hair.next = tmp1;
            tmp1 = tmp1.next;
            hair = hair.next;
        }
        while (tmp2 != null) {
            hair.next = tmp2;
            tmp2 = tmp2.next;
            hair = hair.next;
        }
        return hairTmp.next;
    }

    public static void main(String[] args) {
        SortListReview sortListReview = new SortListReview();
        ListNode listNode = new ListNode(4, 3, 2, 1);
        ListNode sort = sortListReview.sortList(listNode);
        System.out.println(sort);
    }

}
