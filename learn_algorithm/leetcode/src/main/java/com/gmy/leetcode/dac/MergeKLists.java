package com.gmy.leetcode.dac;

import com.gmy.leetcode.link.ListNode;

/**
 * 给定一个链表数组，每个链表都已经按升序排列。
 * 请将所有链表合并到一个升序链表中，返回合并后的链表。
 * https://leetcode.cn/problems/vvXgSW/
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return lists[left];
        }
        int mid = (left + right) / 2;
        ListNode mergeLift = merge(lists, left, mid);
        ListNode mergeRight = merge(lists, mid + 1, right);
        ListNode merge = merge(mergeLift, mergeRight);
        return merge;
    }

    private ListNode merge(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) {
            return listNode2;
        }
        if (listNode2 == null) {
            return listNode1;
        }
        ListNode hair = new ListNode();
        ListNode temp = hair;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val < listNode2.val) {
                temp.next = listNode1;
                listNode1 = listNode1.next;
            } else {
                temp.next = listNode2;
                listNode2 = listNode2.next;
            }
            temp = temp.next;
        }
        while (listNode1 != null) {
            temp.next = listNode1;
            listNode1 = listNode1.next;
            temp = temp.next;
        }
        while (listNode2 != null) {
            temp.next = listNode2;
            listNode2 = listNode2.next;
            temp = temp.next;
        }
        return hair.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.build(new int[] {1,4,5});
        ListNode listNode2 = ListNode.build(new int[] {1,3,4});
        ListNode listNode3 = ListNode.build(new int[] {2,6});
        ListNode listNode4 = ListNode.build(new int[] {2,6,7});
        MergeKLists mergeKLists = new MergeKLists();
        ListNode result = mergeKLists.mergeKLists(new ListNode[]{listNode, listNode2, listNode3, listNode4});
        System.out.println(result);
    }

}
