package com.gmy.leetcode.link;

/**
 * 寻找链表中点
 */
public class MidLink {

    public static ListNode findMid(ListNode head, ListNode listNode) {
        ListNode l1 = head;
        ListNode l2 = head;
        while (l1 != listNode && l1.next != listNode) {
            l1 = l1.next.next;
            l2 = l2.next;
        }
        return l2;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.setNext(2).setNext(3).setNext(4).setNext(5);
        ListNode revert = findMid(listNode, listNode.next.next);
        System.out.println(revert.val);
    }

}
