package com.gmy.leetcode.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 *
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 */
public class _03_LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0, result = 0;
        Map<Character, Integer> cache = new HashMap<>();
        char[] charArray = s.toCharArray();
        while (end < s.length()) {
            char endChar = charArray[end];
            Integer count = cache.getOrDefault(endChar, 0);
            cache.put(endChar, count + 1);
            while (cache.get(endChar) > 1) {
                char startChar = charArray[start];
                cache.put(startChar, cache.get(startChar) - 1);
                start++;
            }
            result = Math.max(end - start + 1, result);
            end++;
        }
        return result;
    }

    public static void main(String[] args) {
        _03_LengthOfLongestSubstring lengthOfLongestSubstring = new _03_LengthOfLongestSubstring();
        int result = lengthOfLongestSubstring.lengthOfLongestSubstring("bbbbbbbb");
        System.out.println(result);
    }

}
