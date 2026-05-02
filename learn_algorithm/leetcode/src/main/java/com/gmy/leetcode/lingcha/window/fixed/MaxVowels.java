package com.gmy.leetcode.lingcha.window.fixed;

/**
 * 给你字符串 s 和整数 k 。
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 * 英文中的 元音字母 为（a, e, i, o, u）。
 *
 * https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
 */
public class MaxVowels {

    public int maxVowels(String s, int k) {
        int left = 0, result = 0, count = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (isAeiou(c)) {
                count++;
            }
            while ((right - left + 1) > k) {
                if (isAeiou(s.charAt(left))) {
                    count--;
                }
                left++;
            }
            result = Math.max(result, count);
        }
        return result;
    }

    private boolean isAeiou(Character character) {
        return character == 'a' || character == 'e'
                || character == 'i' || character == 'o' || character == 'u';
    }

    public static void main(String[] args) {
        MaxVowels maxVowels = new MaxVowels();
        int result = maxVowels.maxVowels("abciiidef", 3);
        System.out.println(result);
    }
}
