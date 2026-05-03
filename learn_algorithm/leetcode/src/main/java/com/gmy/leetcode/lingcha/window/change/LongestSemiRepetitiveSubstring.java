package com.gmy.leetcode.lingcha.window.change;

/**
 *
 相关标签
 premium lock icon
 相关企业
 提示
 给你一个下标从 0 开始的字符串 s ，这个字符串只包含 0 到 9 的数字字符。
 如果一个字符串 t 中至多有一对相邻字符是相等的，那么称这个字符串 t 是 半重复的 。例如，"0010" 、"002020" 、"0123" 、"2002" 和 "54944" 是半重复字符串，而 "00101022" （相邻的相同数字对是 00 和 22）和 "1101234883" （相邻的相同数字对是 11 和 88）不是半重复字符串。
 请你返回 s 中最长 半重复 子字符串 的长度。

  翻译：
 在字符串中找一个最长的连续子串，这个子串里最多只有一对相邻的相同数字
 例如，原字符串为1123455，字串可以为112345或123455，最多只能有一对相邻的相同数字

 https://leetcode.cn/problems/find-the-longest-semi-repetitive-substring/description/
 */
public class LongestSemiRepetitiveSubstring {

    public int longestSemiRepetitiveSubstring(String s) {
        int left = 0, result = 0, count = 0;
        char[] charArray = s.toCharArray();
        for (int right = 0; right < charArray.length; right++) {
            if (right > 0 && charArray[right - 1] == charArray[right]) {
                count++;
            }
            while (count > 1) {
                if (charArray[left] == charArray[left + 1]) {
                    count--;
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

}
