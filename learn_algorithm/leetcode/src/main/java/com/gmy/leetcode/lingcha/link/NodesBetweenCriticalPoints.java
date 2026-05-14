package com.gmy.leetcode.lingcha.link;

import com.gmy.leetcode.link.ListNode;

import java.util.Arrays;

/**
 * 链表中的 临界点 定义为一个 局部极大值点 或 局部极小值点 。
 * 如果当前节点的值 严格大于 前一个节点和后一个节点，那么这个节点就是一个  局部极大值点 。
 * 如果当前节点的值 严格小于 前一个节点和后一个节点，那么这个节点就是一个  局部极小值点 。
 * 注意：节点只有在同时存在前一个节点和后一个节点的情况下，才能成为一个 局部极大值点 / 极小值点 。
 * 给你一个链表 head ，返回一个长度为 2 的数组 [minDistance, maxDistance] ，其中 minDistance 是任意两个不同临界点之间的最小距离，maxDistance 是任意两个不同临界点之间的最大距离。如果临界点少于两个，则返回 [-1，-1] 。
 * https://leetcode.cn/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/description/
 */
public class NodesBetweenCriticalPoints {

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int firstIndex = -1, lastIndex = -1, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, index = 1;
        if (head == null || head.next == null) {
            return new int[] {-1, -1};
        }
        ListNode node = head.next, pre = node.next;
        while (pre != null) {
            if ((node.val > head.val && node.val > pre.val) || (node.val < head.val && node.val < pre.val)) {
                if (firstIndex == -1) {
                    firstIndex = index;
                } else {
                    min = Math.min(index - lastIndex, min);
                    max = Math.max(index - firstIndex, max);
                }
                lastIndex = index;
            }
            node = node.next;
            head = head.next;
            pre = pre.next;
            index++;
        }
        return new int[] {min == Integer.MAX_VALUE ? -1 : min, max == Integer.MIN_VALUE ? -1 : max};
    }

    public static void main(String[] args) {
        NodesBetweenCriticalPoints nodesBetweenCriticalPoints = new NodesBetweenCriticalPoints();
        int[] result = nodesBetweenCriticalPoints.nodesBetweenCriticalPoints(new ListNode(5, 3, 1, 2, 5, 1, 2));
        System.out.println(Arrays.toString(result));
    }
}
