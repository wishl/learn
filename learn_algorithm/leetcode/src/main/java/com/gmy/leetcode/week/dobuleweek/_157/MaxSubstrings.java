package com.gmy.leetcode.week.dobuleweek._157;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个字符串 word。
 * 返回以 首尾字母相同 且 长度至少为 4 的 不相交子字符串 的最大数量。
 * 子字符串 是字符串中连续的 非空 字符序列。
 *
 * 示例 1：
 * 输入： word = "abcdeafdef"
 * 输出： 2
 * 解释：
 * 两个子字符串是 "abcdea" 和 "fdef"。
 */
public class MaxSubstrings {

    /**
     * 暴力解 超时
     * @param word
     * @return
     */
    public int maxSubstrings1(String word) {
        Map<Character, List<Integer>> map = new HashMap<>();
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            map.computeIfAbsent(charArray[i], k -> new ArrayList<>()).add(i);
        }
        return dfs(charArray, 0, map);
    }

    private int dfs(char[] chars, int left, Map<Character, List<Integer>> map) {
        if (left >= chars.length) {
            return 0;
        }
        int maxResult = 0;
        while (left < chars.length) {
            // 如果有相同的char
            char nowChar = chars[left];
            if (map.get(nowChar).size() > 1) {
                List<Integer> indexList = map.get(nowChar);
                for (Integer index : indexList) {
                    // 之前访问过
                    if (index <= left) {
                        continue;
                    }
                    if (index - left + 1 < 4) {
                        continue;
                    }
                    int result = dfs(chars, index + 1, map) + 1;
                    maxResult = Math.max(maxResult, result);
                }
            }
            left++;
        }
        return maxResult;
    }

    public int maxSubstrings(String word) {
        int[] dp = new int[word.length() + 1];
        // 满足条件之后 用前面的index的数量 + 1
        return 0;
    }

    public static void main(String[] args) {
        MaxSubstrings maxSubstrings = new MaxSubstrings();
        System.out.println(maxSubstrings.maxSubstrings1("abcdeafadef"));
    }

}
