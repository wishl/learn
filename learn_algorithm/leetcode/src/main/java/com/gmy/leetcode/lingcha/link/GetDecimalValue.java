package com.gmy.leetcode.lingcha.link;

import com.gmy.leetcode.link.ListNode;

/**
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * 请你返回该链表所表示数字的 十进制值 。
 * 最高位 在链表的头部。
 * https://leetcode.cn/problems/convert-binary-number-in-a-linked-list-to-integer/description/
 */
public class GetDecimalValue {

    public int getDecimalValue(ListNode head) {
        int result = 0;
        while (head != null) {
            result = result | head.val;
            if (head.next != null) {
                result = result << 1;
            }
            head = head.next;
        }
        return result;
    }

    public static void main(String[] args) {
        GetDecimalValue getDecimalValue = new GetDecimalValue();
        int result = getDecimalValue.getDecimalValue(new ListNode(1, 0, 1));
        System.out.println(result);
    }

}
