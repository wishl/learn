package com.gmy.leetcode.review;

/**
 * 给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
 * 在执行上述操作后，返回 包含相同字母的最长子字符串的长度。
 *
 * https://leetcode.cn/problems/longest-repeating-character-replacement/description/
 *
 * ABBB
 */
public class CharacterReplacement {

    /**
     * 滑动窗口解决
     * 思路：最长子串包括 Math.min(重复次数最多的字母重复的次数 + k, s.length)
     * 所以需要维护一个窗口 计算这个窗口的最大重复字母的次数，同时判断窗口中的子串长度是否 > 重复次数最多的字母重复的次数 + K
     * 大于：则需要缩小窗口 并把 之前窗口中的最左边的字母出现次数--（退出窗口）注意：重复次数不需要变化 因为这个窗口是当前计算出的最大长度
     * 小于：则需要扩大窗口 计算新进入窗口的字母出现的次数并更新重复次数最多的字母重复的次数 （Math.max(重复次数最多的字母重复的次数, 新字母出现次数)）
     * 为什么缩小窗口不需要重新计算 【重复次数最多的字母重复的次数】？
     * 算法逻辑是遍历字符串 并计算出符合条件的最大窗口 （窗口大小 = Math.min(重复次数最多的字母重复的次数 + k, s.length)）
     * 当不满足条件时 需要整体右移窗口 不能修改窗口大小
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        // 最多的重复字母数
        int maxCount = 0;
        int start = 0, end = 0;
        int[] cache = new int[26];
        while (end < s.length()) {
            char charAt = s.charAt(end);
            int index = charAt - 'A';
            cache[index]++;
            maxCount = Math.max(maxCount, cache[index]);
            // 不等于
            if ((end - start + 1) > (maxCount + k)) {
                // 退出窗口
                cache[s.charAt(start++) - 'A']--;
            }
            end++;
        }
        return end - start;
    }

    public static void main(String[] args) {
        CharacterReplacement characterReplacement = new CharacterReplacement();
        int result = characterReplacement.characterReplacement("BBCADERTY", 2);
        System.out.println(result);
    }

}
