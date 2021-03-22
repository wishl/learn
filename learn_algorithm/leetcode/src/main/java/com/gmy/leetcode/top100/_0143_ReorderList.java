package com.gmy.leetcode.top100;

import com.gmy.leetcode.link.ListNode;
import lombok.val;

/**
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class _0143_ReorderList {

    public void reorderList(ListNode head) {
        ListNode midPre = findMidPre(head);
        ListNode next = midPre.next;
        midPre.next = null;
        ListNode revert = revert(next);
        merge(head, revert);
    }

    private static void merge(ListNode node1, ListNode node2) {
        ListNode node1Next, node2Next;
        while (node2 != null) {
            node1Next = node1.next;
            node2Next = node2.next;
            node1.next = node2;
            node2.next = node1Next;
            node1 = node1Next;
            node2 = node2Next;
        }
    }

    /**
     * null 1 2 3 -> 3 2 1
     * @param node
     */
    private static ListNode revert(ListNode node) {
        ListNode pre = null, tmp = node;
        while (tmp != null) {
            val next = tmp.next;
            tmp.next = pre;
            pre = tmp;
            tmp = next;
        }
        return pre;
    }

    /**
     * 1 2 3 4 - > 2
     * 1 2 3 -> 2
     * @param node
     * @return
     */
    private ListNode findMidPre(ListNode node) {
        ListNode fast = node, slow = node;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode build = ListNode.build(new int[]{1, 2, 3, 4, 5, 6});
        _0143_ReorderList reorderList = new _0143_ReorderList();
        reorderList.reorderList(build);
        System.out.println(build);
    }

}
