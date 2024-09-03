package com.gmy.leetcode.week.dobuleweek.onetwosix;

/**
 * 给你一个字符串 s 。s[i] 要么是小写英文字母，要么是问号 '?' 。
 * 对于长度为 m 且 只 含有小写英文字母的字符串 t ，我们定义函数 cost(i) 为下标 i 之前（也就是范围 [0, i - 1] 中）出现过与 t[i] 相同 字符出现的次数。
 * 字符串 t 的 分数 为所有下标 i 的 cost(i) 之 和 。
 * 比方说，字符串 t = "aab" ：
 * cost(0) = 0
 * cost(1) = 1
 * cost(2) = 0
 * 所以，字符串 "aab" 的分数为 0 + 1 + 0 = 1 。
 * 你的任务是用小写英文字母 替换 s 中 所有 问号，使 s 的 分数最小 。
 *
 * 请你返回替换所有问号 '?' 之后且分数最小的字符串。如果有多个字符串的 分数最小 ，那么返回字典序最小的一个。
 *
 * 示例 1：
 *
 * 输入：s = "???"
 * 输出： "abc"
 * 解释：这个例子中，我们将 s 中的问号 '?' 替换得到 "abc" 。
 * 对于字符串 "abc" ，cost(0) = 0 ，cost(1) = 0 和 cost(2) = 0 。
 * "abc" 的分数为 0 。
 * 其他修改 s 得到分数 0 的字符串为 "cba" ，"abz" 和 "hey" 。
 * 这些字符串中，我们返回字典序最小的。
 *
 * 输入： s = "a?a?"
 * 输出： "abac"
 * 解释：这个例子中，我们将 s 中的问号 '?' 替换得到 "abac" 。
 * 对于字符串 "abac" ，cost(0) = 0 ，cost(1) = 0 ，cost(2) = 1 和 cost(3) = 0 。
 *
 * "abac" 的分数为 1 。
 */
public class MinimizeStringValue {

    public String minimizeStringValue(String s) {
        int[] cache = new int[26];
        int score = 0;
        char[] charArray = s.toCharArray();
        // 填上已有
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c != '?' && cache[c - 'a'] == 0) {
                cache[c - 'a'] = 1;
            } else if (c != '?' && cache[c - 'a'] == 1) {
                score++;
            }
        }
        // 填上未知
        if (s.length() > 26) {
            // 如果s的长度大于26 则一定有重复 此时 只需从a开始填写即可
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i] == '?') {
                    charArray[i] = (char) (( 'a') % 26);
                }
            }
        } else {
            // 如果
        }
        return "";
    }

}
