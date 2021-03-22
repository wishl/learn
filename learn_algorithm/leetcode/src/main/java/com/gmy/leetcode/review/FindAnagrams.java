package com.gmy.leetcode.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class FindAnagrams {

    /**
     * 固定窗口长度横移
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int start = 0, end = 0, diff = p.length();
        int[] cache = new int[26];
        Arrays.fill(cache, -1);
        for (char c : p.toCharArray()) {
            int index = c - 'a';
            if (cache[c - 'a'] == -1) {
                cache[index] = 1;
            } else {
                cache[index]++;
            }
        }
        while (end < s.length()) {
            while (end - start < p.length()) {
                int endIndex = s.charAt(end) - 'a';
                // 窗口增长到p.length
                if (cache[endIndex] > 0) {
                    cache[endIndex]--;
                    diff--;
                }
                end++;
            }
            if (diff == 0) {
                ans.add(start);
            }
            int startIndex = s.charAt(start) - 'a';
            int endIndex = s.charAt(end) - 'a';
            if (cache[startIndex] != -1 && end + 1 < s.length() - 1) {
                diff++;
                cache[startIndex]++;
            }
            if (cache[endIndex] > 0) {
                diff--;
                cache[endIndex]--;
            }
            start++;
            end++;
        }
        if (diff == 0) {
            ans.add(start);
        }
        return ans;
    }

    public static void main(String[] args) {
        FindAnagrams findAnagrams = new FindAnagrams();
        List<Integer> result = findAnagrams.findAnagrams("babacd", "abc");
        System.out.println(result);
    }

}
