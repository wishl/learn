package com.gmy.leetcode.doublepoint;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口解决最小字符串子序列问题
 * https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/shou-ba-shou-shua-shu-zu-ti-mu/hua-dong-chuang-kou-ji-qiao-jin-jie
 */
public class MinSubString {

    public static String minSubstring(String source, String target) {
        if (source == null || target == null) {
            return null;
        }
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        // 初始化需要的字符数量
        for (int i = 0; i < target.length(); i++) {
            char key = target.charAt(i);
            need.put(key, need.getOrDefault(key, 0) + 1);
        }
        int left = 0, right = 0, start = 0, length = Integer.MAX_VALUE;
        while (right < source.length()) {
            // ADOBECODEBANCEE
            char c = source.charAt(right);
            // 记录数量
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
            }
            // 说明对应上了
            while (window.size() == need.size()) {
                if (right - left < length) {
                    start = left;
                    length = right - left;
                }
                // 移出窗口
                char d = source.charAt(left);
                if (need.containsKey(d)) {
                   window.put(d, window.get(d) - 1);
                   if (window.get(d) == 0) {
                       window.remove(d);
                   }
                }
                left++;
            }
            right++;
        }
        // substring不包含endIndex
        return length == Integer.MAX_VALUE ? "" : source.substring(start, start + length + 1);
    }

    public static void main(String[] args) {
        String s = minSubstring("ADOBECODEBANCEE", "ABC");
        System.out.println(s);
    }

}
