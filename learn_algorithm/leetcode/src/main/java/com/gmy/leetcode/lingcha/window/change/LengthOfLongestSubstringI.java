package com.gmy.leetcode.lingcha.window.change;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
 * https://leetcode.cn/problems/wtcaE1/description/
 */
public class LengthOfLongestSubstringI {

    public int lengthOfLongestSubstring(String s) {
        int left = 0, max = 0;
        Map<Character, Integer> countMap = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (int right = 0; right < charArray.length; right++) {
            countMap.merge(charArray[right], 1, Integer::sum);
            while (countMap.get(charArray[right]) > 1) {
                countMap.merge(charArray[left], -1, Integer::sum);
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

}
