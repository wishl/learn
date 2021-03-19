package com.gmy.leetcode.doublepoint;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口算法
 */
public class SplitWindow {

    // Minimum Window Substring
    public static String  minWindow(String source, String target) {
        if (source == null || source.length() == 0 || target == null || target.length() == 0) {
            return "";
        }
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> dataMap = new HashMap<>();
        int valid = 0, left = 0, right = 0, start = 0, end = Integer.MAX_VALUE;
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        while (right < source.length()) {
            char c = source.charAt(right);
            if (need.containsKey(c)) {
                dataMap.put(c, dataMap.getOrDefault(c, 0) + 1);
                if (dataMap.get(c) == need.get(c)) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                char d = source.charAt(left);
                if ((end - start) >= (right - left)) {
                    end = right;
                    start = left;
                }
                if (need.containsKey(d)) {
                    dataMap.put(d, dataMap.get(d) - 1);
                    if (dataMap.get(d) != need.get(d)) {
                        valid--;
                    }
                }
                left++;
            }
            right++;
        }
        // subString 不包含endIndex
        return end == Integer.MAX_VALUE ? "" : source.substring(start, end + 1);
    }


    public static boolean permutation(String source, String target) {
        if (source == null || source.length() == 0 || target == null || target.length() == 0) {
            return false;
        }
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int valid = 0, right = 0;
        Map<Character, Integer> dataMap = new HashMap<>();
        while (right < source.length()) {
            char c = source.charAt(right);
            if (need.containsKey(c)) {
                dataMap.put(c, dataMap.getOrDefault(c, 0) + 1);
                if (dataMap.get(c) == need.get(c)) {
                    valid++;
                }
            } else {
                valid = 0;
            }
            if (valid == need.size()) {
                return true;
            }
            right++;
        }
        return false;
    }

    public static void main(String[] args) {
//        String result = minWindow("ADOBECODEBANCEEABC", "CCC");
        boolean result = permutation("eibaooo", "boe");
        System.out.println(result);
    }

}
