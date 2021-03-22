package com.gmy.leetcode.link;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 */
public class Partition {

    public ListNode partition(ListNode head, int x) {
        ListNode hair = new ListNode();
        hair.next = head;
        ListNode left = hair, right = hair;
        while (right.next != null) {
            if (right.next.val < x) {
                swap(left, right);
                left = left.next;
            }
            right = right.next;
        }
        return hair.next;
    }

    private void swap(ListNode preLeft, ListNode preRight) {
        if (preLeft == preRight) {
            return;
        }
        ListNode tmp = preRight.next;
        ListNode left = preLeft.next;
        preRight.next = preRight.next.next;
        preLeft.next = tmp;
        tmp.next = left;
    }

    public static void main(String[] args) {
        Partition partition = new Partition();
        ListNode build = ListNode.build(new int[]{1, 4, 3, 2, 5, 2});
        ListNode result = partition.partition(ListNode.build(new int[]{1, 1, 1, 1, 1}), 3);
//        partition.swap(build, build);
        System.out.println(result);
    }

}
