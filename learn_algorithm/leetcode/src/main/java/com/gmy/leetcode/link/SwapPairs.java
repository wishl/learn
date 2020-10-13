package com.gmy.leetcode.link;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class SwapPairs {

    public static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = new ListNode();
        node.next = head.next == null ? head : head.next;
        ListNode n1 = head;
        ListNode n2;
        ListNode n3 = null;
        while (n1 != null && n1.next != null) {
            n2 = n1.next;
            n1.next = n2.next;
            n2.next = n1;
            if (n3 != null) {
                n3.next = n2;
            }
            n3 = n1;
            n1 = n1.next;
        }
        return node.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode node = swapPairs(node1);
        System.out.println(node);
    }

}
