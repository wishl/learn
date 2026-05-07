package com.gmy.leetcode.lingcha.window.max_count;

/**
 * 给你一个 二进制 字符串 s 和一个整数 k。
 * 如果一个 二进制字符串 满足以下任一条件，则认为该字符串满足 k 约束：
 * 字符串中 0 的数量最多为 k。
 * 字符串中 1 的数量最多为 k。
 * 返回一个整数，表示 s 的所有满足 k 约束 的子字符串的数量。
 *
 * https://leetcode.cn/problems/count-substrings-that-satisfy-k-constraint-i/description/
 */
public class CountKConstraintSubstrings {

    public int countKConstraintSubstrings(String s, int k) {
        int left = 0, result = 0, count0 = 0, count1 = 0;
        char[] charArray = s.toCharArray();
        for (int right = 0; right < charArray.length; right++) {
            if (charArray[right] == '0') {
                count0++;
            } else {
                count1++;
            }
            while (count0 > k && count1 > k) {
                if (charArray[left] == '0') {
                    count0--;
                } else {
                    count1--;
                }
                left++;
            }
            result += (right - left + 1);
        }
        return result;
    }

}
