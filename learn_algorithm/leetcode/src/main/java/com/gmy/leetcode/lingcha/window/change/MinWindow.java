package com.gmy.leetcode.lingcha.window.change;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t，长度分别是 m 和 n，返回 s 中的 最短窗口 子串，使得该子串包含 t 中的每一个字符（包括重复字符）。如果没有这样的子串，返回空字符串 ""。
 *
 * 测试用例保证答案唯一。
 *
 * https://leetcode.cn/problems/minimum-window-substring/description/
 */
public class MinWindow {

    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        char[] charArray = s.toCharArray();
        int left = 0, tCount = t.length();
        String result = "";
        for (int right = 0; right < charArray.length; right++) {
            char c = charArray[right];
            if (map.containsKey(c)) {
                Integer lastCount = map.put(c, map.get(c) - 1);
                if (lastCount > 0) {
                    tCount--;
                }
            }
            while (tCount == 0) {
                if (result.isEmpty()) {
                    result = s.substring(left, right + 1);
                } else if (result.length() > (right - left + 1)) {
                    result = s.substring(left, right + 1);
                }
                if (map.containsKey(charArray[left])) {
                    int currentCount = map.get(charArray[left]) + 1;
                    map.put(charArray[left], currentCount);
                    if (currentCount > 0) {
                        tCount++;
                    }
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(new MinWindow().minWindow(s, t));
    }

}
