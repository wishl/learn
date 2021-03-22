package com.gmy.leetcode.review;

import java.util.Arrays;
import java.util.List;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * 致谢：
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 */
public class IsSubsequence {

    /**
     * 双指针解法
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int left = 0, right = 0;
        while (left < s.length() && right < t.length()) {
            if (s.charAt(left) == t.charAt(right)) {
                left++;
            }
            right++;
        }
        return left == s.length();
    }

    /**
     * 动态规划的解法
     * 主要思想：
     * 1. 去除重复的寻找s[i] 在 t中位置的计算
     * 2. 设置二位数字 dp[i][j] 代表 字母 j 在字符i之后的首次出现位置 如果没有就设置值为 t.length
     * 3. 从后往前设置dp数组
     * @param sList
     * @param t
     * @return
     */
    public boolean isSubsequence1(String s, String t) {
        int tLength = t.length();
        // t字符串中 某个位置之后
        int[][] dp = new int[tLength + 1][26];
        // 填充默认最后一位
        for (int i = 0; i < 26; i++) {
            dp[tLength][i] = tLength;
        }
        // 填充真实
        for (int i = tLength - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == 'a' + j) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        // 实际计算
        int tIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (dp[tIndex][s.charAt(i) - 'a'] == tLength) {
                return false;
            } else {
                // 如果有的话 下一个得在 命中的之后寻找
                // 例如 a 在dp中的值是 2 tIndex 就得从3开始继续寻找
                tIndex = dp[tIndex][s.charAt(i) - 'a'] + 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        boolean result = isSubsequence.isSubsequence1("acb", "ahbgdc");
        System.out.println(result);
    }

}
