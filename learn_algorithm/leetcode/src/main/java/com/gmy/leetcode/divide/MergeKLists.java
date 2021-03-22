package com.gmy.leetcode.divide;

import com.gmy.leetcode.link.ListNode;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return new ListNode();
        }
        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = merge(result, lists[i]);
        }
        return result;
    }

    /**
     * 分治方法
     * @return
     */
    public ListNode mergeKList1(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return dfs(lists, 0, lists.length - 1);
    }

    public ListNode dfs(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = (left + right) / 2;
        ListNode leftNode = dfs(lists, left, mid);
        ListNode rightNode = dfs(lists, mid + 1, right);
        return merge(leftNode, rightNode);
    }

    private ListNode merge(ListNode listNode1, ListNode listNode2) {
        ListNode hair = new ListNode(), hairTmp = hair;
        ListNode tmp1 = listNode1, tmp2 = listNode2;
        while (tmp1 != null && tmp2 != null) {
            if (tmp1.val < tmp2.val) {
                hair.next = tmp1;
                tmp1 = tmp1.next;
            } else {
                hair.next = tmp2;
                tmp2 = tmp2.next;
            }
            hair = hair.next;
        }
        hair.next = (tmp1 == null ? tmp2 : tmp1);
        return hairTmp.next;
    }

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[] {new ListNode(1,4,5), new ListNode(1,3,4), new ListNode(2,6)};
        MergeKLists mergeKLists = new MergeKLists();
        ListNode merge = mergeKLists.mergeKList1(listNodes);
        System.out.println(merge);
    }

}
