package com.gmy.leetcode.link;

/**
 * 给你链表的头节点 head 和一个整数 k 。
 *
 * 交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。
 */
public class SwapNodes {

    public ListNode swapNodes(ListNode head, int k) {
        ListNode hair = new ListNode();
        hair.next = head;
        ListNode node = findX(k, hair);
        ListNode last = findLast(k, hair);
        swap(node.next, last.next, node, last);
        return hair.next;
    }

    private ListNode findX(int count, ListNode node) {
        for (int i = 1; i < count; i++) {
            node = node.next;
        }
        return node;
    }

    private ListNode findLast(int count, ListNode node) {
        int gap = 0;
        ListNode result = node;
        while (node.next != null) {
            if (gap >= count) {
                result = result.next;
            }
            node = node.next;
            gap++;
        }
        return result;
    }

    private void swap(ListNode node, ListNode last, ListNode preNode, ListNode preLast) {
        ListNode tmp = node.next;
        if (last.next != node) {
            node.next = last.next;
        } else {
            node.next = last;
        }
        if (tmp != last) {
            last.next = tmp;
        } else {
            last.next = node;
        }
        if (preNode != null && preNode != last) {
            preNode.next = last;
        }
        if (preLast != null && preLast != node) {
            preLast.next = node;
        }
    }

    public static void main(String[] args) {
        ListNode hair = new ListNode();
        ListNode node = ListNode.build(new int[]{100, 90});
//        hair.next = node;
        SwapNodes swapNodes = new SwapNodes();
//        swapNodes.swap(hair.next.next, hair.next.next.next, hair.next, hair.next.next);
//        System.out.println(hair.next);
//        swapNodes.swap(hair.next, hair.next.next.next.next, hair, hair.next.next.next);
//        System.out.println(hair.next);
        ListNode node1 = swapNodes.swapNodes(node, 2);
        System.out.println(node1);
    }

}
