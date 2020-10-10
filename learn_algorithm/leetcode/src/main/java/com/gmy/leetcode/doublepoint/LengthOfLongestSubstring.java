package com.gmy.leetcode.doublepoint;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring {

    // 其实不需要clean set 就能做到
    public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = start + 1;
        char[] chars = s.toCharArray();
        int result = 0;
        while (start < s.length()) {
            Set<Character> set = new HashSet<>();
            set.add(chars[start]);
            while (end < s.length()) {
                if (!set.contains(chars[end])) {
                    set.add(chars[end]);
                    end++;
                } else {
                    break;
                }
            }
            if (result < (end - start)) {
                result = end - start;
            }
            start++;
            end = start + 1;
        }
        return result;
    }

    // 只需要去除最左边的，后面的可以复用
    public static int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        int result = 0;
        int rightPoint = -1;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (rightPoint + 1 < n && !set.contains(s.charAt(rightPoint + 1))) {
                set.add(s.charAt(rightPoint + 1));
                rightPoint++;
            }
            result = Math.max(result, rightPoint - i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int result = lengthOfLongestSubstring1("bbbbabcd");
        System.out.println(result);
    }
}
