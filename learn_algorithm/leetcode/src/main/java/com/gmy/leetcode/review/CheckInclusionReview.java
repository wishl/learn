package com.gmy.leetcode.review;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 *
 */
public class CheckInclusionReview {

    public boolean checkInclusion(String s1, String s2) {
        int start = 0, end = 0;
        Map<Character, Integer> cache = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char charAt = s1.charAt(i);
            cache.put(charAt, cache.getOrDefault(charAt, 0) + 1);
        }
        while (end < s2.length()) {
            char endCharAt = s2.charAt(end++);
            Integer count = cache.getOrDefault(endCharAt, 0);
            while (cache.get(endCharAt) < 0) {
                char startCharAt = s2.charAt(start++);
                cache.put(startCharAt, cache.get(startCharAt) + 1);
            }
            if (end - start == s1.length()) {
                return true;
            }
        }
        return end - start == s1.length();
    }
}
