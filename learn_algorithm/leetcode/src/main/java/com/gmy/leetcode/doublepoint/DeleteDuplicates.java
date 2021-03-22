package com.gmy.leetcode.doublepoint;

import com.gmy.leetcode.link.ListNode;

/**
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode hair = new ListNode(Integer.MIN_VALUE, head);
        ListNode slow = head, fast = head, pre = hair;
        while (fast != null) {
            if (fast.next != null && fast.next.val == fast.val) {
                fast = fast.next;
                continue;
            }
            if (fast != slow) {
                slow = pre;
                fast = fast.next;
                slow.next = fast;
                slow = slow.next;
            } else {
                slow = slow.next;
                fast = fast.next;
                pre = pre.next;
            }
        }
        return hair.next;
    }

    public static void main(String[] args) {
        DeleteDuplicates duplicates = new DeleteDuplicates();
        ListNode listNode = duplicates.deleteDuplicates(ListNode.build(new int[]{1,2,3,3,4,4,5}));
        System.out.println(listNode);
    }

}
