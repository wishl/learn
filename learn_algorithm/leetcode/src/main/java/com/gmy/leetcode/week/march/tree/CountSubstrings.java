package com.gmy.leetcode.week.march.tree;

/**
 * 给你一个字符串 s 和一个字符 c 。返回在字符串 s 中并且以 c 字符开头和结尾的
 * 非空子字符串的总数。
 *
 * 示例 1：
 *
 * 输入：s = "abada", c = "a"
 *
 * 输出：6
 *
 * 解释：以 "a" 开头和结尾的子字符串有： "abada"、"abada"、"abada"、"abada"、"abada"、"abada"。
 */
public class CountSubstrings {

    public long countSubstrings(String s, char c) {
        long n = 0, result = 0;
        for (char c1 : s.toCharArray()) {
            if (c1 == c) {
                n++;
                result += n;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountSubstrings countSubstrings = new CountSubstrings();
        long result = countSubstrings.countSubstrings("zzz", 'z');
        System.out.println(result);
    }

}
