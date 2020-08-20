package com.gmy.leetcode;

public class LastNNode {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode headCopy = head;
        ListNode result = head;
        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        boolean flag = true;
        while (head != null && head.next != null) {
            head = head.next;
            headCopy = headCopy.next;
            flag = false;
        }
        if (flag && head == null) {// flag 为true 说明当前删除是头
            return result.next;
        }
        if (headCopy.next != null) {
            headCopy.next = headCopy.next.next;
        } else {// headCopy.next == null 证明删除的是头
            result = result.next;
        }
        return result;
    }

//    1->2->3->4->5
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode copy = listNode;
        for (int i = 2; i <= 2; i++) {
            ListNode node = new ListNode(i);
            copy.next = node;
            copy = node;
        }
        System.out.println(listNode);
        ListNode listNode1 = removeNthFromEnd(listNode, 1);
        System.out.println(listNode1.val);
    }

}
