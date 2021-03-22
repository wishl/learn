package com.gmy.leetcode.doublepoint;

import com.gmy.leetcode.link.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReOrderListNode {

    public void reorderList(ListNode head) {
        ListNode tmp = head;
        List<ListNode> list = new ArrayList<>();
        while (tmp != null) {
            list.add(tmp);
            tmp = tmp.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            ListNode less = list.get(i++);
            ListNode more = list.get(j--);
            less.next = more;
            more.next = list.get(i);
            ListNode preMore = list.get(j);
            preMore.next = null;
        }
    }

    public void reorderList1(ListNode head) {
        ListNode midPre = findMidPre(head);
        ListNode midHead = midPre.next;
        if (midHead == null) {
            return;
        }
        midPre.next = null;
        midHead = revert(midHead, null);
        merge(head, midHead);
    }

    private ListNode findMidPre(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            if (fast == null) {
                return slow;
            }
            slow = slow.next;
        }
        return null;
    }

    private ListNode revert(ListNode node, ListNode before) {
        if (node.next == null) {
            node.next = before;
            return node;
        }
        ListNode revert = revert(node.next, node);
        node.next = before;
        return revert;
    }

    private void merge(ListNode lessNode, ListNode moreNode) {
        while (lessNode != null && moreNode != null) {
            ListNode moreNext = moreNode.next, lessNext = lessNode.next;
            lessNode.next = moreNode;
            moreNode.next = lessNext;
            moreNode = moreNext;
            lessNode = lessNext;
        }
    }

    private ListNode dfs(ListNode head, ListNode pre, ListNode end) {
        if (end == null) {
            return head;
        }
        ListNode h1 = dfs(head, pre.next, end.next);
        pre.next = null;
        if (h1 != end) {
            ListNode tmp = h1.next;
            end.next = null;
            h1.next = end;
            end.next = tmp;
            return tmp;
        }
        return head;
    }

    public static void main(String[] args) {
        ReOrderListNode reOrderListNode = new ReOrderListNode();
        ListNode listNode = ListNode.build(new int[]{1, 2, 3, 4});
//        ListNode mid = reOrderListNode.findMidPre(listNode);
//        System.out.println(mid);
//        ListNode revert = reOrderListNode.revert(listNode, null);
        reOrderListNode.reorderList1(listNode);
        System.out.println(listNode);

    }

}
