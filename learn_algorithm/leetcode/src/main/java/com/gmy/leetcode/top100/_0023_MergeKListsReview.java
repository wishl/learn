package com.gmy.leetcode.top100;

import com.gmy.leetcode.link.ListNode;

import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class _0023_MergeKListsReview {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode hair = new ListNode();
        ListNode tmp = hair;
        Queue<ListNode> deque = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                deque.offer(lists[i]);
            }
        }
        while (!deque.isEmpty()) {
            ListNode min = deque.poll();
            tmp.next = min;
            min = min.next;
            if (min != null) {
                deque.offer(min);
            }
            tmp = tmp.next;
        }
        return hair.next;
    }

    public static void main(String[] args) {
        _0023_MergeKListsReview mergeKListsReview = new _0023_MergeKListsReview();
        // [[1,4,5],[1,3,4],[2,6]]
        ListNode[] nodes = new ListNode[2];
        nodes[0] = null;
        nodes[1] = ListNode.build(new int[] {1});
//        nodes[2] = ListNode.build(new int[] {2, 6});
        ListNode result = mergeKListsReview.mergeKLists(nodes);
        System.out.println(result);
    }

}
