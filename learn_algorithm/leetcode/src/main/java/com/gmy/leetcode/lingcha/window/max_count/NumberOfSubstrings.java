package com.gmy.leetcode.lingcha.window.max_count;

/**
 * 给你一个字符串 s ，它只包含三种字符 a, b 和 c 。
 * 请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目
 *
 * https://leetcode.cn/problems/number-of-substrings-containing-all-three-characters/description/
 */
public class NumberOfSubstrings {

    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] cnt = new int[3];
        int left = 0, res = 0;
        for (int right = 0; right < n; right++) {
            cnt[s.charAt(right) - 'a']++;
            while (cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0) {
                res += n - right;
                cnt[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfSubstrings().numberOfSubstrings("abcabc"));

    }

}
