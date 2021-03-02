package com.gmy.leetcode.doublepoint;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串，判断s1是否包含s2
 */
public class SubString {

    // 判断是否有包含
    public static boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() < s2.length()) {
            return false;
        }
        Map<Integer, Character> needs = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            needs.put(i, s2.charAt(i));
        }
        int right = 0, index = 0;
        while (right < s1.length()) {
            char c = s1.charAt(right);
            if (needs.get(index) == c) {
                index++;
            } else {
                index = 0;
            }
            if (index == s2.length()) {
                return true;
            }
            right++;
        }
        return false;
    }

    // 判断是否包含其中一种序列
    public static boolean checkInclusionOne(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() < s2.length()) {
            return false;
        }
        Map<Character, Integer> needs = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        while (right < s1.length()) {
            char c = s1.charAt(right);
            if (needs.containsKey(c)) {
                valid++;
            }
            while (valid == s2.length()) {
                if (right - left > s2.length()) {
                    char c1 = s1.charAt(left);
                    left++;
                    if (needs.containsKey(c1)) {
                        valid--;
                    }
                } else {
                    return true;
                }
            }
            right++;
        }
        return false;
    }

    // 获取最长无重复子串
    public int longsetSubString(String s1) {
        if (s1 == null || s1.equals("")) {
            return 0;
        }
        Map<Character, Object> window = new HashMap<>();
        int left = 0, right = 0, length = 0;
        while (right < s1.length()) {
            char c = s1.charAt(right);
            if (window.containsKey(c)) {
                length = Math.max(length, right - left);
                char c1 = s1.charAt(left);
                window.remove(c1);
                left++;
            }
            right++;
        }
        return length;
    }

    // 给出包含的起始index, 不包含返回-1
    public static int subStringAt(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() < s2.length()) {
            return -1;
        }
        Map<Integer, Character> needs = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            needs.put(i, s2.charAt(i));
        }
        int left = 0, right = 0, index = 0;
        while (right < s1.length()) {
            char c = s1.charAt(right);
            if (needs.get(index) == c) {
                index++;
            } else {
                left = right + 1;
                index = 0;
            }
            if (index == s2.length()) {
                return left;
            }
            right++;
        }
        return -1;
    }

    public static void main(String[] args) {
        boolean b = checkInclusionOne("abdabcc", "cbc");
        System.out.println(b);
    }

}
