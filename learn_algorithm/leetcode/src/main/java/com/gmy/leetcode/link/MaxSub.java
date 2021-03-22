package com.gmy.leetcode.link;

/**
 * 给定一个单链表，节点个数是偶数n，求 max(e[i]+e[n-1-i]), 比如 4-5-1-3-6-7,
 * 结果就是max(4+7,5+6,1+3) = 4+7 = 11, 但是题目要求是用o(n)时间复杂度，o(1)空间复杂度
 *
 * 作者：EDCTY
 * 链接：https://leetcode.cn/circle/discuss/7DwxxK/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaxSub {

    public int maxSub(ListNode listNode) {
        ListNode preMid = findMid(listNode);
        ListNode revert = revert(preMid.next);
        preMid.next = revert;
        ListNode node1 = listNode, node2 = preMid.next;
        int max = 0;
        while (node1 != preMid.next && node2 != null) {
            max = Math.max(max, node1.val + node2.val);
            node1 = node1.next;
            node2 = node2.next;
        }
        return max;
    }

    private ListNode revert(ListNode listNode, ListNode pre) {
        if (listNode.next == null) {
            listNode.next = pre;
            return listNode;
        }
        ListNode revert = revert(listNode.next, listNode);
        listNode.next = pre;
        return revert;
    }

    private ListNode revert(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = revert(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private ListNode findMid(ListNode listNode) {
        ListNode fast = listNode.next, slow = listNode;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode build = ListNode.build(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        MaxSub maxSub = new MaxSub();
        int i = maxSub.maxSub(build);
        System.out.println(i);
    }

}
