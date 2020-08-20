package com.gmy.leetcode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class ListSort {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode listNode = new ListNode();
        ListNode listNode1 = listNode;
        if (l1.val > l2.val) {
            listNode.val = l2.val;
            l2 = l2.next;
        } else {
            listNode.val = l1.val;
            l1 = l1.next;
        }
        while (l1 != null || l2 != null) {
            ListNode node = new ListNode();
            if (l1 == null) {
                listNode.next = l2;
                return listNode1;
            }
            if (l2 == null) {
                listNode.next = l1;
                return listNode1;
            }
            if (l1.val > l2.val) {
                node.val = l2.val;
                listNode.next = node;
                listNode = node;
                l2 = l2.next;
            } else {
                node.val = l1.val;
                listNode.next = node;
                listNode = node;
                l1 = l1.next;
            }
        }
        return listNode1;
    }

    public static void main(String[] args) {
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        ListNode listNode = new ListNode();
        listNode.val = 1;
        node2.val = 3;
        node3.val = 4;
        node2.next = node3;
        listNode.next = node2;

        ListNode subNode2 = new ListNode();
        ListNode subNode3 = new ListNode();
        ListNode subNode = new ListNode();
        subNode2.val = 2;
        subNode3.val = 4;
        subNode.val = 1;
        subNode.next = subNode2;
        subNode2.next = subNode3;
        ListNode node = mergeTwoLists(listNode, subNode);
        System.out.println(node);
    }
}
