package com.gmy.leetcode.review;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，
 * 单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 *
 * https://leetcode.cn/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class ReverseWords {

    public String reverseWords(String s) {
        Deque<String> deque = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                builder.append(c);
            } else if (builder.length() > 0) {
                builder.append(" ");
                deque.push(builder.toString());
                builder = new StringBuilder();
            }
        }
        while (!deque.isEmpty()) {
            String pop = deque.pop();
            builder.append(pop);
        }
        return builder.substring(0, builder.length() - 1);
    }

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        String result = reverseWords.reverseWords("  hello world");
        System.out.println(result);
    }

}
