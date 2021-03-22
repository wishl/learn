package com.gmy.leetcode.review;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0, length = 0, result = 0;
        Map<Character, Boolean> cache = new HashMap<>();
        while (end < s.length()) {
            char endChar = s.charAt(end);
            if (cache.containsKey(endChar)) {
                result = Math.max(result, length);
                cache.remove(s.charAt(start++));
                length--;
            } else {
                length++;
                end++;
                cache.put(endChar, true);
            }
        }
        return Math.max(result, length);
    }

    /**
     * 优化存储 使用ascii码
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        int start = 0, end = 0, result = 0;
        int[] cache = new int[128];
        while (end < s.length()) {
            char endChar = s.charAt(end);
            end++;
            cache[endChar]++;
            while (cache[endChar] > 1) {
                cache[s.charAt(start++)]--;
            }
            result = Math.max(result, end - start);
        }
        return result;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        int result = lengthOfLongestSubstring.lengthOfLongestSubstring("abcacbb");
        int result1 = lengthOfLongestSubstring.lengthOfLongestSubstring1("abcacbb");
        System.out.println(result);
        System.out.println(result1);
    }
}
