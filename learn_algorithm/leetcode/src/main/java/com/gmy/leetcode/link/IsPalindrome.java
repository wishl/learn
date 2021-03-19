package com.gmy.leetcode.link;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 判断链表是否为回文链表
 * 1->2->2->1
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class IsPalindrome {

    private ListNode head;

    // 递归
    public boolean isPalindrome(ListNode listNode) {
        this.head = listNode;
        boolean valid = valid(listNode);
        return valid;
    }

    // 使用栈
    public boolean isPalindrome1(ListNode listNode) {
        Deque<ListNode> deque = new ArrayDeque<>();
        ListNode head = listNode;
        while (head != null) {
            deque.push(head);
            head = head.next;
        }
        head = listNode;
        while (deque.size() > 0) {
            ListNode pop = deque.pop();
            if (pop.val != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    private boolean valid(ListNode node) {
        if (node.next == null) {
            return node.val == head.val;
        }
        boolean flag = valid(node.next);
        head = head.next;
        return !flag ? false : node.val == head.val;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        ListNode listNode = new ListNode(1);
        listNode.setNext(2).setNext(2).setNext(1);
        boolean palindrome = isPalindrome.isPalindrome1(listNode);
        System.out.println(palindrome);
    }

}
