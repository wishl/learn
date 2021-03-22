package com.gmy.leetcode.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 */
public class _0076_MinWindow {

    public String minWindow(String s, String t) {
        char[] charArray = t.toCharArray();
        Map<Character, Integer> cache = new HashMap<>();
        Map<Character, Integer> copy = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            cache.put(c, cache.getOrDefault(c, 0) + 1);
            copy.put(c, copy.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, count = 0, min = s.length();
        String result = "";
        while (right < s.length()) {
            char rc = s.charAt(right++);
            if (cache.containsKey(rc)) {
                cache.put(rc, cache.get(rc) - 1);
                if (cache.get(rc) >= 0) {
                    count++;
                }
            }
            while (count == t.length()) {
                if (right - left <= min) {
                    result = s.substring(left, right);
                    min = right - left;
                }
                char lc = s.charAt(left++);
                if (cache.containsKey(lc) && cache.get(lc) < copy.get(lc)) {
                    cache.put(lc, cache.get(lc) + 1);
                    if (cache.get(lc) > 0) {
                        count--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _0076_MinWindow minWindow = new _0076_MinWindow();
        String result = minWindow.minWindow("cwaefgcf", "cae");
        System.out.println(result);
    }

}
