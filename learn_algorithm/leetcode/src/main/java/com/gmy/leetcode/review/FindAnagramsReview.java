package com.gmy.leetcode.review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 */
public class FindAnagramsReview {

    public List<Integer> findAnagrams(String s, String p) {
        int start = 0, end = 0;
        List<Integer> result = new ArrayList();
        int[] cache = new int[26];
        for (int i = 0; i < p.length(); i++) {
            char charAt = p.charAt(i);
            cache[charAt - 'a']++;
        }
        while (end < s.length()) {
            char endCharAt = s.charAt(end++);
            cache[endCharAt - 'a']--;
            while (cache[endCharAt - 'a'] < 0) {
                char startCharAt = s.charAt(start++);
                cache[startCharAt - 'a']++;
            }
            if (end - start == p.length()) {
                result.add(start);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindAnagramsReview findAnagramsReview = new FindAnagramsReview();
        List<Integer> result = findAnagramsReview.findAnagrams("cbaebabacd", "abc");
        System.out.println(result);
    }
}
