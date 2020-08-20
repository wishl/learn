package com.gmy.leetcode;


/**
 * 合并 k 个排序链表，
 * 返回合并后的排序链表。
 * 请分析和描述算法的复杂度。
 */
public class KLinkList {

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

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        ListNode result = new ListNode(0);
        ListNode node = result;
        while (true) {
            Integer index = -1;
            Integer min = null;
            for (int i = 0; i < lists.length; i++) {
                ListNode listNode = lists[i];
                if (listNode != null && (min == null || listNode.val < min)) {
                    min = listNode.val;
                    index = i;
                }
            }
            if (index == -1) {
                break;
            }
            lists[index] = lists[index].next;
            ListNode listNode = new ListNode(min);
            node.next = listNode;
            node = node.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(4);
        node.next.next = new ListNode(5);
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(4);
        ListNode node2 = new ListNode(2);
        node2.next = new ListNode(6);
        ListNode[] list = {node, node1, node2};
        ListNode listNode = mergeKLists(list);
        System.out.println(listNode);
    }


}
