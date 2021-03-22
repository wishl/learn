package com.gmy.leetcode.monostone_stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 * https://leetcode.cn/problems/remove-k-digits/
 */
public class RemoveKdigits {

    public String removeKdigits(String num, int k) {
        if (num == null || k >= num.length()) {
            return "0";
        }
        // 从index == 0 开始 如果前面的值比后面的大 则去掉
        return doRemove(num, k);
    }

    private String doRemove(String num, int k) {
        char[] chars = num.toCharArray();
        Deque<Character> deque = new LinkedList<>();
        int removedCount = 0;
        for (int i = 0; i < chars.length; i++) {
            while (!deque.isEmpty() && chars[i] < deque.peek() && removedCount < k) {
                deque.pop();
                removedCount++;
            }
            deque.push(chars[i]);
        }
        while (removedCount < k) {
            deque.pop();
            removedCount++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!deque.isEmpty() && stringBuilder.length() < (num.length() - k)) {
            Character last = deque.pollLast();
            if (last == '0' && stringBuilder.length() == 0) {
                continue;
            }
            stringBuilder.append(last);
        }
        return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "10001";
        RemoveKdigits removeKdigits = new RemoveKdigits();
        String s1 = removeKdigits.removeKdigits(s, 4);
        System.out.println(s1);
    }
}
