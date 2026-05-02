package com.gmy.leetcode.lingcha.window.change;

/**
 * 给你一个字符串 s ，请找出满足每个字符最多出现两次的最长子字符串，并返回该子字符串的 最大 长度。
 * https://leetcode.cn/problems/maximum-length-substring-with-two-occurrences/description/
 */
public class MaximumLengthSubstring {

    public int maximumLengthSubstring(String s) {
        int left = 0, result = 0;
        int[] cache = new int[26];
        char[] cs = s.toCharArray();
        for (int right = 0; right < cs.length; right++) {
            char c = cs[right];
            cache[c - 'a']++;
            while (cache[c - 'a'] > 2) {
                cache[cs[left++] - 'a']--;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        MaximumLengthSubstring maximumLengthSubstring = new MaximumLengthSubstring();
        int result = maximumLengthSubstring.maximumLengthSubstring("bcbbbcba");
        System.out.println(result);
    }
}
