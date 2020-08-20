package com.gmy.leetcode;

/**
 * 反转链表
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class SwapNode {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = head.next;
        ListNode lastHead = null;
        while (head != null) {
            ListNode tmp = head.next;
            if (tmp == null) {
                break;
            }
            head.next = head.next.next;
            tmp.next = head;
            if (lastHead != null) {
                lastHead.next = tmp;
            }
            lastHead = head;
            head = head.next;
        }
        return result;
    }

    // 递归解法
    public static ListNode swapPairsRecurrence(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        // 获取head的next，因为递归保存了上一个head
        // 返回了后面排序好的node，所以直接放在head的next上在交换就不会断开链表
        head.next = swapPairsRecurrence(next.next);
        next.next = head;
        return next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode.next = listNode2;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(5);
        listNode4.next = listNode5;
        ListNode result = swapPairs(listNode);
        System.out.println(result);
    }

}
