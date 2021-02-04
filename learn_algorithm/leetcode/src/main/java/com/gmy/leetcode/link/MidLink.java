package com.gmy.leetcode.link;

/**
 * 寻找链表中点
 */
public class MidLink {

    public static ListNode findMid(ListNode head) {
        ListNode l1 = head;
        ListNode l2 = head;
        while (l2 != null && l2.next != null) {
            l1 = head.next;
            l2 = head.next.next;
        }
        return l1;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.setNext(2).setNext(3).setNext(4);
        System.out.println(listNode);
        ListNode revert = findMid(listNode);
        System.out.println(revert);
    }

}
