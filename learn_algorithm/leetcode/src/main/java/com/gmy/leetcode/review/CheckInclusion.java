package com.gmy.leetcode.review;

/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 
 */
public class CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {
        int[] cache = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            cache[s1.charAt(i) - 'a']++;
        }
        int start = 0, end = 0;
        while (end < s2.length()) {
            char endCharAt = s2.charAt(end++);
            cache[endCharAt - 'a']--;
            while (cache[endCharAt - 'a'] < 0) {
                char startCharAt = s2.charAt(start++);
                cache[startCharAt - 'a']++;
            }
            if (end - start == s1.length()) {
                return true;
            }
        }
        return end - start == s1.length();
    }

    public static void main(String[] args) {
        CheckInclusion checkInclusion = new CheckInclusion();
        boolean result = checkInclusion.checkInclusion("ab", "edbaoo");
        System.out.println(result);
    }

}
