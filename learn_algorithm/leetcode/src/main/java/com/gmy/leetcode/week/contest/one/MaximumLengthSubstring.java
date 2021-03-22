package com.gmy.leetcode.week.contest.one;

/**
 * 给你一个字符串 s ，请找出满足每个字符最多出现两次的最长子字符串，并返回该子字符串的最大长度。
 * https://leetcode.cn/problems/maximum-length-substring-with-two-occurrences/description/
 */
public class MaximumLengthSubstring {

    public int maximumLengthSubstring(String s) {
        char[] charArray = s.toCharArray();
        int[] count = new int[26];
        int start = 0, end = 0, length = 0;
        while (end < charArray.length) {
            char endChar = charArray[end++];
            count[endChar - 'a']++;
            while (count[endChar - 'a'] > 2) {
                char startChar = charArray[start++];
                count[startChar - 'a']--;
            }
            length = Math.max(end - start, length);
        }
        return length;
    }

    public static void main(String[] args) {
        MaximumLengthSubstring maximumLengthSubstring = new MaximumLengthSubstring();
        int result = maximumLengthSubstring.maximumLengthSubstring("aaaa");
        System.out.println(result);
    }
}
