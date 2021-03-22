package com.gmy.leetcode.sliding_window;

/**
 * 给你一个字符串 S，找出所有长度为 K 且不含重复字符的子串，请你返回全部满足要求的子串的 数目。
 * 示例 1：
 *
 * 输入：S = "havefunonleetcode", K = 5
 * 输出：6
 * 解释：
 * 这里有 6 个满足题意的子串，分别是：'havef','avefu','vefun','efuno','etcod','tcode'。
 * 示例 2：
 *
 * 输入：S = "home", K = 5
 * 输出：0
 * 解释：
 * 注意：K 可能会大于 S 的长度。在这种情况下，就无法找到任何长度为 K 的子串。
 *
 */
public class NoDuplicateMaxKLength {

    public int noDuplicateMaxKLength(String s, int k) {
        int[] count = new int[26];
        int left = 0, right = 0, result = 0;
        while (right < s.length()) {
            char rc = s.charAt(right);
            count[rc - 'a']++;
            while (right - left + 1 > k || count[rc - 'a'] > 1) {
                char lc = s.charAt(left);
                count[lc - 'a']--;
                left++;
            }
            if (right - left + 1 == k) {
                result++;
            }
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        NoDuplicateMaxKLength noDuplicateMaxKLength = new NoDuplicateMaxKLength();
        int result = noDuplicateMaxKLength.noDuplicateMaxKLength("abcdefg", 2);
        System.out.println(result);
    }

}
