package com.gmy.leetcode.top100;

import com.gmy.leetcode.link.ListNode;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * hair 1 2 3
 *
 * pre node tmp tmp.next
 */
public class _0024_SwapPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode hair = new ListNode(0, head), pre = hair, node = head;
        while (node != null && node.next != null) {
            ListNode tmp = node.next;
            if (tmp != null) {
                pre.next = tmp;
                pre = node;
                node.next = tmp.next;
                tmp.next = node;
            }
            node = node.next;
        }
        return hair.next;
    }

    public static void main(String[] args) {
        _0024_SwapPairs swapPairs = new _0024_SwapPairs();
        ListNode result = swapPairs.swapPairs(ListNode.build(new int[]{1, 2, 3, 4}));
        System.out.println(result);
    }

}
