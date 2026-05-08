package com.gmy.leetcode.lingcha.window.max_count;

/**
 * 给你一个字符串 s 和一个整数 k，在 s 的所有子字符串中，请你统计并返回 至少有一个 字符 至少出现 k 次的子字符串总数。
 * 子字符串 是字符串中的一个连续、 非空 的字符序列
 *
 * https://leetcode.cn/problems/count-substrings-with-k-frequency-characters-i/description/
 */
public class NumberOfSubstringsI {

    public int numberOfSubstrings(String s, int k) {
        int left = 0, result = 0;
        int[] counts = new int[26];
        char[] charArray = s.toCharArray();
        for (int right = 0; right < s.length(); right++) {
            counts[charArray[right] - 'a']++;
            while (counts[charArray[right] - 'a'] >= k) {
                result += charArray.length - right;
                counts[charArray[left] - 'a']--;
                left++;
            }
        }
        return result;
    }

}
