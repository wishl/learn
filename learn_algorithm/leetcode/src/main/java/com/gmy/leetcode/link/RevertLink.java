package com.gmy.leetcode.link;

/**
 * 递归反转链表
 */
public class RevertLink {


    public static ListNode revert(ListNode now, ListNode before) {
        if (now == null) {
            return null;
        }
        if (now.next == null) {
            now.next = before;
            return now;
        }
        ListNode revert = revert(now.next, now);
        now.next = before;
        return revert;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.setNext(2);
        listNode.next.setNext(3);
        ListNode revert = revert(listNode, null);
        System.out.println(revert);
    }

}
