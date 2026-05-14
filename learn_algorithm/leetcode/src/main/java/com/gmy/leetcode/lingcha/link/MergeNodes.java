package com.gmy.leetcode.lingcha.link;

import com.gmy.leetcode.link.ListNode;

/**
 * 给你一个链表的头节点 head ，该链表包含由 0 分隔开的一连串整数。链表的 开端 和 末尾 的节点都满足 Node.val == 0 。
 * 对于每两个相邻的 0 ，请你将它们之间的所有节点合并成一个节点，其值是所有已合并节点的值之和。然后将所有 0 移除，修改后的链表不应该含有任何 0 。
 *  返回修改后链表的头节点 head 。
 *
 *  https://leetcode.cn/problems/merge-nodes-in-between-zeros/description/
 */
public class MergeNodes {

    public ListNode mergeNodes(ListNode head) {
        ListNode hair = new ListNode();
        ListNode node = hair;
        head = head.next;
        int sum = 0;
        while (head != null) {
            if (head.val == 0) {
                node.next = new ListNode(sum);
                node = node.next;
                sum = 0;
            } else {
                sum += head.val;
            }
            head = head.next;
        }
        return hair.next;
    }

}
