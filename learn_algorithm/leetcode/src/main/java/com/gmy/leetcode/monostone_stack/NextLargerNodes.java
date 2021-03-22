package com.gmy.leetcode.monostone_stack;

import com.gmy.leetcode.link.ListNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给定一个长度为 n 的链表 head
 *
 * 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。
 *
 * 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点，设置 answer[i] = 0 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/next-greater-node-in-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NextLargerNodes {

    public int[] nextLargerNodes(ListNode head) {
        ListNode copy = head;
        int length = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (copy != null) {
            map.put(length, copy.val);
            length++;
            copy = copy.next;
        }
        int[] result = new int[length];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            while (!deque.isEmpty() && head.val > map.get(deque.peek())) {
                Integer index = deque.pop();
                result[index] = head.val;
            }
            deque.push(i);
            head = head.next;
        }
        return result;
    }

    public static void main(String[] args) {
        NextLargerNodes nextLargerNodes = new NextLargerNodes();
        int[] ints = nextLargerNodes.nextLargerNodes(ListNode.build(new int[]{2,7,4,3,5}));
        System.out.println(Arrays.toString(ints));
    }

}
