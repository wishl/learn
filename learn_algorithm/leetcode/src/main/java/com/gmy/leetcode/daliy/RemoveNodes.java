package com.gmy.leetcode.daliy;

import com.gmy.leetcode.link.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个链表的头节点 head 。
 * 移除每个右侧有一个更大数值的节点。
 * 返回修改后链表的头节点 head 。
 * https://leetcode.cn/problems/remove-nodes-from-linked-list/description/?envType=daily-question&envId=2024-01-03
 */
public class RemoveNodes {

    /**
     * 单调栈
     * @param head
     * @return
     */
    public ListNode removeNodes(ListNode head) {
        ListNode hair = new ListNode(Integer.MAX_VALUE);
        hair.next = head;
        Deque<ListNode> deque = new ArrayDeque<>();
        deque.push(hair);
        while (head != null) {
            int val = head.val;
            // 5,2,13,3,8
            while (val > deque.peek().val) {
                deque.pop();
                ListNode newPre = deque.peek();
                newPre.next = head;
            }
            deque.push(head);
            head = head.next;
        }
        return hair.next;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode removeNodes1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(Integer.MAX_VALUE);
        pre.next = head;
        ListNode dfs = dfs(pre, head, head.next);
        return dfs;
    }

    /**
     * 先反过来 然后拼接
     * @param pre
     * @param node
     */
    private ListNode dfs(ListNode prePre, ListNode pre, ListNode node) {
        ListNode listNode = node;
        if (node.next != null) {
            listNode = dfs(pre, node, node.next);
        }
        if (listNode.val > pre.val) {
            prePre.next = listNode;
        }
        return prePre.next;
    }

    public static void main(String[] args) {
        RemoveNodes removeNodes = new RemoveNodes();
//        ListNode listNode = removeNodes.removeNodes(ListNode.build(new int[]{1, 1, 1, 1}));
        ListNode listNode1 = removeNodes.removeNodes1(ListNode.build(new int[]{5,2,13,3,8}));
        ListNode listNode = removeNodes.removeNodes(ListNode.build(new int[]{5,2,13,3,8}));
        System.out.println(listNode);
        System.out.println(listNode1);
    }

}
