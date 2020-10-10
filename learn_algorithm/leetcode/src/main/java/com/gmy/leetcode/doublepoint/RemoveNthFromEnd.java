package com.gmy.leetcode.doublepoint;

import java.util.List;

public class RemoveNthFromEnd {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            String result = val + "";
            if (next != null) {
                result += "->" + next.toString();
            }
            return result;
        }
    }
    
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode n1 = dummy;
        ListNode n2 = dummy;// 待删除的节点
        int step = 0;
        // 获取倒数第n个节点
        while (n1 != null) {
            n1 = n1.next;
            step++;
            if (step > n + 1) {
                n2 = n2.next;
            }
        }
        n2.next = n2.next.next;
        return dummy.next;
    }

    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(5);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
        ListNode listNode = removeNthFromEnd(listNode1, 1);
        System.out.println(listNode);
    }

}
