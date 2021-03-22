package com.gmy.leetcode.review.dp;

import java.util.Arrays;

/**
 * 给定一个较长字符串big和一个包含较短字符串的数组smalls，设计一个方法，
 * 根据smalls中的每一个较短字符串，对big进行搜索。
 * 输出smalls中的字符串在big里出现的所有位置positions，其中positions[i]为smalls[i]出现的所有位置。
 *
 * https://leetcode.cn/problems/multi-search-lcci/description/
 */
public class MultiSearch {

    public int[][] multiSearch(String big, String[] smalls) {
        // 存储每个字母在big中的位置
        int[][] dp = new int[26][big.length() + 1];
        int[][] result = new int[smalls.length][];
        Arrays.fill(dp, smalls.length);
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < big.length(); j++) {
                if (big.charAt(i) - 'a' == i) {
                    dp[i][j] = j;
                }
            }
        }
        int tIndex = 0, lastIndex = 0;
        for (int index = 0; index < smalls.length; index++) {
            String small = smalls[index];
        }
        return null;
    }
}
