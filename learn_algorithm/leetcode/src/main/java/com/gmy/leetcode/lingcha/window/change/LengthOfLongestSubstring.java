package com.gmy.leetcode.lingcha.window.change;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 *
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int left = 0, result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            addChar(c, map);
            while ((right - left + 1) > map.size()) {
                delChar(s.charAt(left++), map);
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    private void addChar(Character c, Map<Character, Integer> countMap) {
        countMap.merge(c, 1, Integer::sum);
    }

    private void delChar(Character c, Map<Character, Integer> countMap) {
        if (countMap.get(c) == 1) {
            countMap.remove(c);
        } else {
            countMap.put(c, countMap.get(c) - 1);
        }
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        int result = lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb");
        System.out.println(result);
    }

}
