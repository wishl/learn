package com.gmy.leetcode.top100;

import com.gmy.leetcode.link.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class _0021_MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
        _0021_MergeTwoLists mergeTwoLists = new _0021_MergeTwoLists();
        ListNode result = mergeTwoLists.mergeTwoLists(ListNode.build(new int[]{1, 2, 4}), ListNode.build(new int[]{1, 3, 4}));
        System.out.println(result);
    }

}
