package com.gmy.leetcode;

import com.gmy.leetcode.link.ListNode;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 *
 * []
 *
 */
public class RevertLink {

    public ListNode revertLink(ListNode listNode, int k) {
        ListNode head = listNode;
        // 1. 获取倒数第k个
        ListNode fast = listNode, slow = listNode;
        int length = getLength(listNode);
        k = k % length;
        while (fast.next != null) {
            if (k > 0) {
                fast = fast.next;
                k--;
                continue;
            }
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        ListNode result = slow.next;
        slow.next = null;
        return result;
    }

    private int getLength(ListNode listNode) {
        int length = 0;
        while (listNode != null) {
            length++;
            listNode = listNode.next;
        }
        return length;
    }


    public static void main(String[] args) {
        RevertLink revertLink = new RevertLink();
        ListNode result = revertLink.revertLink(ListNode.build(new int[]{1, 2, 3, 4, 5}), 5);
        System.out.println(result);
    }
}
