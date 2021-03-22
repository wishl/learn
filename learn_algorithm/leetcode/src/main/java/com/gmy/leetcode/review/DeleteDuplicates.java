package com.gmy.leetcode.review;

import com.gmy.leetcode.link.ListNode;
import lombok.val;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode hair = new ListNode(0, head);
        ListNode current = hair;
        while (current.next != null && current.next.next != null) {
            if (current.next.val == current.next.next.val) {
                int val = current.next.val;
                while (current.next != null && current.next.val == val) {
                    current.next = current.next.next;
                }
            } else {
                current = current.next;
            }
        }
        return hair.next;
    }

    /**
     * 滑动窗口
     * @param head
     * @return
     */
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode hair = new ListNode(Integer.MIN_VALUE);
        hair.next = head;
        Deque<ListNode> deque = new ArrayDeque<>();
        deque.push(hair);
        boolean delete = false;
        while (head != null) {
            while (deque.peek().val == head.val) {
                deque.pop();
                delete = true;
            }
            if (!delete) {
                deque.peek().next = head;
                deque.push(head);
                head = head.next;
            } else {
                deque.peek().next = head.next;
            }
            delete = false;
        }
        return hair.next;
    }

    public static void main(String[] args) {
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        ListNode result = deleteDuplicates.deleteDuplicates(ListNode.build(new int[]{1,2,3,3,4,5,5}));
        ListNode result1 = deleteDuplicates.deleteDuplicates1(ListNode.build(new int[]{1,2,3,3,3,4,5,5}));
        System.out.println(result);
        System.out.println(result1);
    }

}
