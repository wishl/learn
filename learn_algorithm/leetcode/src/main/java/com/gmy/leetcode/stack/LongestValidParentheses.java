package com.gmy.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串
 * 的长度。
 *
 * 示例 1：
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 *
 *
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 *
 * 输入：s = "((()))"
 * 输出：6
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> rDeque = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        int result = 0, left = 0;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == '(') {
                deque.offer(i);
                // 不满足条件时
            } else if (c == ')' && !deque.isEmpty()) {
                deque.pollLast();
            } else if (c == ')' && deque.isEmpty()) {
                rDeque.offer(i);
            }
        }
        while (!deque.isEmpty() || !rDeque.isEmpty()) {
            int errorIndex;
            if (!deque.isEmpty() && !rDeque.isEmpty()) {
                boolean isLeft = deque.peek() < rDeque.peek();
                if (isLeft) {
                    errorIndex = deque.pop();
                } else {
                    errorIndex = rDeque.pop();
                }
            } else if (!deque.isEmpty()) {
                errorIndex = deque.pop();
            } else {
                errorIndex = rDeque.pop();
            }
            result = Math.max(errorIndex - left, result);
            left = errorIndex + 1;
        }
        result = Math.max(charArray.length - left, result);
        return result;
    }

    public int longestValidParentheses1(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        // (()()
        // ()(()
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        int result = longestValidParentheses.longestValidParentheses("()((())()");
        System.out.println(result);
    }

}
