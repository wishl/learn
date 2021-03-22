package com.gmy.leetcode.top100;

import com.gmy.leetcode.link.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * todo review
 */
public class _0234_IsPalindrome {

    private int step = 0;

    public boolean isPalindrome(ListNode head) {
        ListNode mid = findMid(head);
        Deque<Integer> deque = new ArrayDeque<>();
        while (head != mid) {
            deque.push(head.val);
            head = head.next;
        }
        if (step % 2 == 1) {
            deque.push(head.val);
        }
        boolean result = true;
        while (deque.size() != 0 && head != null) {
            Integer pop = deque.pop();
            result = result && pop == head.val;
            head = head.next;
        }
        return result;
    }

    /**
     * 1 2 3 - > 2
     * 1 2 3 4 - > 3
     * @param head
     * @return
     */
    private ListNode findMid(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
            step++;
            if (fast != null) {
                fast = fast.next;
                step++;
            }
        }
        if (fast != null) {
            step++;
        }
        return slow;
    }

    public static void main(String[] args) {
        _0234_IsPalindrome isPalindrome = new _0234_IsPalindrome();
        boolean result = isPalindrome.isPalindrome(ListNode.build(new int[]{1, 2, 2, 1}));
        System.out.println(result);
    }

}
