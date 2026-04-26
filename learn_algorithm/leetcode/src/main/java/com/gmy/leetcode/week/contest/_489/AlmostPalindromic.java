package com.gmy.leetcode.week.contest._489;

/**
 * 给你一个由小写英文字母组成的字符串 s。
 * 如果一个子字符串在删除 恰好 一个字符后变成回文字符串，那么这个子字符串就是 准回文串（almost-palindromic）。
 * 返回一个整数，表示字符串 s 中最长的 准回文串 的长度。
 * 子字符串是字符串中任意连续的、非空 字符序列。
 * 回文串是一个 非空 字符串，正着读和反着读都相同。
 *
 * https://leetcode.cn/problems/longest-almost-palindromic-substring/description/
 *
 * 示例 1：
 *
 * 输入： s = "abca"
 * 输出： 4
 * 解释：
 * 选择子字符串 "abca"。
 * 删除 "abca" 中的 c。
 * 字符串变为 "aba"，它是一个回文串。
 * 因此，"abca" 是准回文串。
 *
 * 示例 2：
 * 输入： s = "abba"
 * 输出： 4
 * 解释：
 * 选择子字符串 "abba"。
 * 删除 "abba" 中的 b。
 * 字符串变为 "aba"，它是一个回文串。
 * 因此，"abba" 是准回文串。
 *
 * 示例 3：
 * 输入： s = "zzabba"
 * 输出： 5
 * 解释：
 * 选择子字符串 "zzabba"。
 * 删除 "zabba" 中的 z。
 * 字符串变为 "abba"，它是一个回文串。
 * 因此，"zabba" 是准回文串。
 */
public class AlmostPalindromic {

    /**
     * 如果当前是个回文字
     * aba abba 删除最中间的一个字母一定还是回文字符串
     *
     * @param s
     * @return
     */
//    public int almostPalindromic(String s) {
//
//    }

}
