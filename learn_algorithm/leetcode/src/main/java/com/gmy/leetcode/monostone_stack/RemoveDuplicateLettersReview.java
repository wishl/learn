package com.gmy.leetcode.monostone_stack;

import javax.accessibility.AccessibleBundle;
import java.util.Deque;

/**
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * https://leetcode.cn/problems/remove-duplicate-letters/
 */
public class RemoveDuplicateLettersReview {

    public String removeDuplicateLetters(String s) {
        int[] nums = new int[26];
        boolean[] visited = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!visited[c - 'a']) {
                while (builder.length() > 0 && builder.charAt(builder.length() - 1) > c) {
                    if (nums[builder.charAt(builder.length() - 1) - 'a'] > 0) {
                        visited[builder.charAt(builder.length() - 1) - 'a'] = false;
                        builder.deleteCharAt(builder.length() - 1);
                    } else {
                        break;
                    }
                }
                visited[c - 'a'] = true;
                builder.append(c);
            }
            nums[c - 'a'] -= 1;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLettersReview removeDuplicateLetters = new RemoveDuplicateLettersReview();
        String result = removeDuplicateLetters.removeDuplicateLetters("dcbadcba");
        System.out.println(result);
    }

}
