package com.gmy.leetcode.review;


/**
 * 给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
 * 在执行上述操作后，返回 包含相同字母的最长子字符串的长度。
 *
 * https://leetcode.cn/problems/longest-repeating-character-replacement/description/
 *
 * ABBB
 */
public class CharacterReplacementReview {

    /**
     * 维护最大窗口然后右移
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        int start = 0, end = 0, max = 0;
        // 窗口中的字符
        int[] cache = new int[26];
        while (end < s.length()) {
            int count = ++cache[s.charAt(end++) - 'A'];
            max = Math.max(max, count);
            if (end - start > max + k) {
                cache[s.charAt(start++) - 'A']--;
            }
        }
        return end - start;
    }

    public static void main(String[] args) {
        CharacterReplacementReview characterReplacementReview = new CharacterReplacementReview();
        int result = characterReplacementReview.characterReplacement("ABAAACDVA", 1);
        System.out.println(result);
    }
}
