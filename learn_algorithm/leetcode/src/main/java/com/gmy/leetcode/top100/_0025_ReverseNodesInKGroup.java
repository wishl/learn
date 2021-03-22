package com.gmy.leetcode.top100;

import com.gmy.leetcode.link.ListNode;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/description/
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 *
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 */
public class _0025_ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0, head), pre = hair, node = head;
        int i = 0;
        // 先切分 再revert 然后合并
        while (node != null) {
            ListNode before = node, revert;
            while (i < k && node != null) {
                node = node.next;
                i++;
            }
            if (i == k) {
                revert = revert(before, node);
                i = 0;
            } else {
                revert = before;
            }
            pre.next = revert;
            pre = before;
        }
        return hair.next;
    }

    private ListNode revert(ListNode head, ListNode end) {
        // 1, 2, 3
        ListNode pre = null, next;
        while (head != end) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        _0025_ReverseNodesInKGroup reverseNodesInKGroup = new _0025_ReverseNodesInKGroup();
        ListNode result = reverseNodesInKGroup.reverseKGroup(ListNode.build(new int[]{1, 2, 3, 4, 5}), 3);
        System.out.println(result);
    }

}
