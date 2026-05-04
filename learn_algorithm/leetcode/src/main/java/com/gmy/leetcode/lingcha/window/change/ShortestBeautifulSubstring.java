package com.gmy.leetcode.lingcha.window.change;

/**
 * 给你一个二进制字符串 s 和一个正整数 k 。
 * 如果 s 的某个子字符串中 1 的个数恰好等于 k ，则称这个子字符串是一个 美丽子字符串 。
 * 令 len 等于 最短 美丽子字符串的长度。
 * 返回长度等于 len 且字典序 最小 的美丽子字符串。如果 s 中不含美丽子字符串，则返回一个 空 字符串。
 * 对于相同长度的两个字符串 a 和 b ，如果在 a 和 b 出现不同的第一个位置上，a 中该位置上的字符严格大于 b 中的对应字符，则认为字符串 a 字典序 大于 字符串 b 。
 * 例如，"abcd" 的字典序大于 "abcc" ，因为两个字符串出现不同的第一个位置对应第四个字符，而 d 大于 c 。
 *
 * https://leetcode.cn/problems/shortest-and-lexicographically-smallest-beautiful-string/description/
 */
public class ShortestBeautifulSubstring {

    public String shortestBeautifulSubstring(String s, int k) {
        char[] charArray = s.toCharArray();
        int left = 0, count = 0;
        String result = "";
        for (int right = 0; right < charArray.length; right++) {
            if (charArray[right] == '1') {
                count++;
            }
            while (count == k) {
                String substring = s.substring(left, right + 1);
                if (result.isEmpty()) {
                    result = substring;
                } else if (substring.length() < result.length() || (substring.length() == result.length() && substring.compareTo(result) < 0)) {
                    result = substring;
                }
                if (charArray[left] == '1') {
                    count--;
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ShortestBeautifulSubstring shortestBeautifulSubstring = new ShortestBeautifulSubstring();
        String result = shortestBeautifulSubstring.shortestBeautifulSubstring("100011001", 3);
        System.out.println(result);
    }

}
