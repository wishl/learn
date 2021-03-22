package com.gmy.leetcode.week.contest.treeninesix;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s ，它由某个字符串 t 和若干 t  的 同位字符串 连接而成。
 * 请你返回字符串 t 的 最小 可能长度。
 * 同位字符串 指的是重新排列一个单词得到的另外一个字符串，原来字符串中的每个字符在新字符串中都恰好只使用一次。
 *
 * https://leetcode.cn/problems/minimum-length-of-anagram-concatenation/description/
 *
 * abbabb
 */
public class MinAnagramLength {


    public int minAnagramLength(String s) {
        int[] cache = new int[26];
        int length = s.length();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            cache[charArray[i] - 'a']++;
            int start = i + 1, end = start, windowLength = start;
            if (length % start != 0) {
                continue;
            }
            while (end < s.length()) {
                char endChar = charArray[end];
                // 当前窗口满足条件 找下一个窗口
                if (end - start >= windowLength) {
                    exit(start, end - 1, cache, charArray);
                    start = end;
                }
                if (cache[endChar - 'a'] > 0) {
                    cache[endChar - 'a']--;
                } else {
                    // 当前窗口不满足条件 全部退出
                    exit(start, end - 1, cache, charArray);
                    break;
                }
                end++;
            }
            if (end == s.length()) {
                return i + 1;
            }
        }
        return s.length();
    }

    private void exit(int start, int end, int[] cache, char[] charArray) {
        while (start <= end) {
            cache[charArray[start] - 'a']++;
            start++;
        }
    }

    public static void main(String[] args) {
        MinAnagramLength minAnagramLength = new MinAnagramLength();
        int result = minAnagramLength.minAnagramLength("abbabb");
        System.out.println(result);
    }
}
