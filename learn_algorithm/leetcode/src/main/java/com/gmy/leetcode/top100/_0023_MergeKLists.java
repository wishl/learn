package com.gmy.leetcode.top100;

import com.gmy.leetcode.link.ListNode;
import com.gmy.leetcode.link.MergeInBetween;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/
 */
public class _0023_MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode listNode = new ListNode();
        if (lists.length == 0) {
            return listNode.next;
        }
        ListNode pre = lists[0];
        for (int i = 1; i < lists.length; i++) {
            pre = merge(pre, lists[i]);
        }
        return pre;
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode hair = new ListNode(), node = hair;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                node.next = list2;
                break;
            }
            if (list2 == null) {
                node.next = list1;
                break;
            }
            if (list1.val < list2.val) {
                node.next = list1;
                node = node.next;
                list1 = list1.next;
            } else {
                node.next = list2;
                node = node.next;
                list2 = list2.next;
            }
            node.next = null;
        }
        return hair.next;
    }

    public static void main(String[] args) {
        _0023_MergeKLists mergeKLists = new _0023_MergeKLists();
        ListNode[] listNodes = {ListNode.build(new int[]{1, 4, 5}),
            ListNode.build(new int[]{1, 3, 4}), ListNode.build(new int[]{2, 6})};
        ListNode result = mergeKLists.mergeKLists(new ListNode[0]);
        System.out.println(result);
    }

}
