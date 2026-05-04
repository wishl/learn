package com.gmy.leetcode.lingcha.window.change;

import java.util.Arrays;

/**
 * 有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。
 * 假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。
 * 给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
 * 你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。
 * 请返回待替换子串的最小可能长度。
 * 如果原字符串自身就是一个平衡字符串，则返回 0。
 *
 *
 */
public class BalancedString {

    public int balancedString(String s) {
        char[] charArray = s.toCharArray();
        int result = Integer.MAX_VALUE, threshold = s.length() / 4, left = 0;
        int[] counts = new int[26];
        boolean[] needChange = new boolean[26];
        for (char c : charArray) {
            counts[c - 'A']++;
            needChange[c- 'A'] = counts[c - 'A'] > threshold;
        }
        if (checkChange(counts, needChange, threshold)) {
            return 0;
        }
        for (int right = 0; right < charArray.length; right++) {
            if (needChange[charArray[right] - 'A']) {
                counts[charArray[right] - 'A']--;
            }
            while (checkChange(counts, needChange, threshold)) {
                result = Math.min(result, right - left + 1);
                if (needChange[charArray[left] - 'A']) {
                    counts[charArray[left] - 'A']++;
                }
                left++;
            }
        }
        return result;
    }

    private boolean checkChange(int[] counts, boolean[] needChange, int threshold) {
        for (int index = 0; index < needChange.length; index++) {
            if (needChange[index] && counts[index] > threshold) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BalancedString balancedString = new BalancedString();
        int result = balancedString.balancedString("QQER");
        System.out.println(result);
    }

}
