package com.gmy.leetcode.top100;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 */
public class _05_LongestPalindrome  {

    //动态规划求解。
    public String longestPalindrome(String s) {
        //定义一个表示字符长度
        int len = s.length();
        //如果字符小于2，直接返回
        if (len < 2) {
            return s;
        }
        //定义一个表示回文字符数量的变量
        int maxlen = 1;
        //回文字串的开始索引
        int begin = 0;
        //定义一个存储所有可能的结果，一个二维数组
        boolean[][] dp = new boolean[len][len];
        //单个字符本身就是回文串
        for (int i = 0; i< len; i++) {
            dp[i][i] = true;
        }
        //递归遍历，二维数组的对角线上方的所有元素
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < len - 1  && i < j; i++) {
                //如果两个字符不相等，就说明不是回文串
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    //当是回文串时，字符个数小于等于3个，就是回文串
                    if (j - i < 3) {
                        dp[i][j] =  true;
                    } else {
                        //递归判断当边界两边的字符相等时，继续判断内层的字符是否相等
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                //对比所有的回文串，取出长度最大的，回文串的起始位置
                if (dp[i][j] && j-i+1 > maxlen) {
                    maxlen = j-i+1;
                    begin = i;
                }
            }
        }
        //字符串的切割
        return s.substring(begin,begin+maxlen);
    }

}
