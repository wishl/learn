package com.gmy.leetcode.doublepoint;

import com.gmy.leetcode.link.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 */
public class PartitionNode {

    public ListNode partition(ListNode head, int x) {
        ListNode hair = new ListNode(Integer.MIN_VALUE, head), p = head, pre = hair;
        ListNode moreHead = null, moreEnd = null, lessHead = null, lessEnd = null;
        while (p != null) {
            while (p != null && p.val < x) {
                if (lessHead == null) {
                    lessHead = p;
                }
                lessEnd = p;
                p = p.next;
            }
            while (p != null && p.val >= x) {
                if (moreHead == null) {
                    moreHead = p;
                }
                moreEnd = p;
                p = p.next;
            }
            if (moreHead != null && lessHead != null) {
                swap(moreHead, moreEnd, lessHead, lessEnd, pre);
                pre = lessEnd;
                p = moreEnd.next;
                moreHead = null;
                moreEnd = null;
                lessHead = null;
                lessEnd = null;
            }
        }
        return hair.next;
    }

    private static void swap(ListNode moreHead, ListNode moreEnd, ListNode lessHead, ListNode lessEnd, ListNode pre) {
//        pre.next = moreHead;
//        lessEnd.next = moreEnd.next;
//        moreEnd.next = lessHead;
        if (pre.next != lessHead) {
            pre.next = lessHead;
            moreEnd.next = lessEnd.next;
            lessEnd.next = moreHead;
        }
    }

    public static void main(String[] args) {
        PartitionNode partitionNode = new PartitionNode();
        ListNode partition = partitionNode.partition(ListNode.build(new int[]{1, 4, 3, 2, 5, 2}), 3);
        System.out.println(partition);
    }
}
