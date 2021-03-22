package com.gmy.leetcode.link;

public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head), p0 = dummy;
        for (int i = 0; i < left - 1; ++i)
            p0 = p0.next;

        ListNode pre = null, cur = p0.next;
        for (int i = 0; i < right - left + 1; ++i) {
            ListNode nxt = cur.next;
            cur.next = pre; // 每次循环只修改一个 next，方便大家理解
            pre = cur;
            cur = nxt;
        }

        // p0.next.next  是翻转后的最后一个节点
        // cur 是 right后的第一个节点
        p0.next.next = cur;
        p0.next = pre;
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,2,3,4,5);
        ReverseBetween reverseBetween = new ReverseBetween();
        ListNode result = reverseBetween.reverseBetween(listNode, 2, 4);
        System.out.println(result);
    }

}
