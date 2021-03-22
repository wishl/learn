package com.gmy.leetcode.review;

/**
 * 给你两个长度相同的字符串，s 和 t。
 * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
 * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 *
 * https://leetcode.cn/problems/get-equal-substrings-within-budget/
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "bcdf", maxCost = 3
 * 输出：3
 * 解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
 */
public class EqualSubstring {

    public int equalSubstring(String s, String t, int maxCost) {
        int start = 0, end = 0, change = 0, result = 0;
        while (end < s.length()) {
            change += Math.abs(s.charAt(end) - t.charAt(end));
            while (change > maxCost) {
                change -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }
            result = Math.max(result, end - start + 1);
            end++;
        }
        return result;
    }

    public static void main(String[] args) {
        EqualSubstring equalSubstring = new EqualSubstring();
        int result = equalSubstring.equalSubstring("pxezla", "loewbi", 25);
        System.out.println(result);
    }

}
