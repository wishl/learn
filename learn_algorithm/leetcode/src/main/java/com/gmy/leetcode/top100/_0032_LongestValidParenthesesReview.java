package com.gmy.leetcode.top100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class _0032_LongestValidParenthesesReview {

    public int longestValidParentheses(String s) {
        char[] charArray = s.toCharArray();
        int max = 0;
        Deque<Integer> rDeque = new ArrayDeque<>();
        Deque<Integer> lDeque = new ArrayDeque<>();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                lDeque.offer(i);
            } else if (charArray[i] == ')' && !lDeque.isEmpty()) {
                lDeque.pop();
            } else {
                rDeque.offer(i);
            }
        }
        int left = 0;
        while (!rDeque.isEmpty() || !lDeque.isEmpty()) {
            int errorIndex;
            if (!rDeque.isEmpty() && !lDeque.isEmpty()) {
                boolean isLeft = rDeque.peek() < lDeque.peek();
                if (isLeft) {
                    errorIndex = lDeque.pop();
                } else {
                    errorIndex = rDeque.pop();
                }
            } else if (!rDeque.isEmpty()) {
                errorIndex = rDeque.pop();
            } else {
                errorIndex = lDeque.pop();
            }
            max = Math.max(max, errorIndex - left);
            left = errorIndex + 1;
        }
        max = Math.max(charArray.length - left, max);
        return max;
    }

    public static void main(String[] args) {
        _0032_LongestValidParenthesesReview longestValidParenthesesReview = new _0032_LongestValidParenthesesReview();
        int result = longestValidParenthesesReview.longestValidParentheses(")()())");
        System.out.println(result);
    }

}
