package com.gmy.leetcode.review.window;

import org.checkerframework.checker.units.qual.C;

/**
 * 给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
 * 在执行上述操作后，返回 包含相同字母的最长子字符串的长度。
 *
 * https://leetcode.cn/problems/longest-repeating-character-replacement/description/
 *
 * 示例 1：
 *
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 * 示例 2：
 *
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 * 可能存在其他的方法来得到同样的结果。
 */
public class CharacterReplacementReview {

    /**
     * 需要维护窗口中重复的数字的最大值 然后窗口大小一定是这个最大值 + K
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        int maxCount = 0, start = 0, end = 0;
        int[] cache = new int[26];
        while (end < s.length()) {
            char endCharAt = s.charAt(end++);
            int count = ++cache[endCharAt - 'A'];
            maxCount = Math.max(maxCount, count);
            while (end - start > maxCount + k) {
                char startCharAt = s.charAt(start++);
                --cache[startCharAt - 'A'];
            }
        }
        return end - start;
    }

    public static void main(String[] args) {
        CharacterReplacementReview characterReplacementReview = new CharacterReplacementReview();
        int result = characterReplacementReview.characterReplacement("AABABBA", 1);
        System.out.println(result);
    }

}
