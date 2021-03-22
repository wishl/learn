package com.gmy.leetcode.dac;

import com.gmy.leetcode.link.ListNode;

import java.util.List;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * https://leetcode.cn/problems/sort-list/
 */
public class SortListReview {

    /**
     * 使用归并排序
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }

    private ListNode sort(ListNode listNode, ListNode end) {
        ListNode merge = listNode;
        if (listNode != end) {
            ListNode mid = findMid(listNode, end);
            ListNode next = mid.next;
            mid.next = null;
            ListNode sort = sort(listNode, mid);
            ListNode sort1 = sort(next, end);
            merge = merge(sort, sort1);
        }
        return merge;
    }

    private ListNode merge(ListNode listNode, ListNode listNode1) {
        ListNode hair = new ListNode(), tmp = hair;
        while (listNode != null && listNode1 != null) {
            if (listNode.val < listNode1.val) {
                ListNode node = listNode;
                tmp.next = node;
                listNode = listNode.next;
            } else {
                ListNode node = listNode1;
                tmp.next = node;
                listNode1 = listNode1.next;
            }
            tmp = tmp.next;
        }
        while (listNode != null) {
            tmp.next = listNode;
            tmp = tmp.next;
            listNode = listNode.next;
        }
        while (listNode1 != null) {
            tmp.next = listNode1;
            tmp = tmp.next;
            listNode1 = listNode1.next;
        }
        return hair.next;
    }

    private ListNode findMid(ListNode listNode, ListNode end) {
        ListNode fast = listNode;
        ListNode slow = listNode;
        while (fast != end && fast.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.build(new int[] {-1,5,3,4,0});
        SortListReview sortListReview = new SortListReview();
        ListNode sorted = sortListReview.sortList(listNode);
        System.out.println(sorted.toString());
    }

}
