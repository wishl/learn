package com.gmy.leetcode.review.window;

/**
 * 给你一个由字符 'a'、'b'、'c' 组成的字符串 s 和一个非负整数 k 。每分钟，你可以选择取走 s 最左侧 还是 最右侧 的那个字符。
 * 你必须取走每种字符 至少 k 个，返回需要的 最少 分钟数；如果无法取到，则返回 -1 。
 *
 * https://leetcode.cn/problems/take-k-of-each-character-from-left-and-right/description/
 */
public class TakeCharacters {

    public int takeCharacters(String s, int k) {
        int start = 0, end = 0, resultLength = 0;
        int[] cache = new int[3];
        char[] charArray = s.toCharArray();
        for (int i = 0; i <s.length(); i++) {
            cache[s.charAt(i) - 'a']++;
        }
        if (cache[0] < k || cache[1] < k || cache[2] < k) {
            return -1;
        }
        while (end < s.length()) {
            int index = charArray[end++] - 'a';
            cache[index]--;
            // 去除中间 剩下的是拿走的
            while (cache[index] < k) {
                int startIndex = charArray[start++] - 'a';
                cache[startIndex]++;
            }
            resultLength = Math.max(resultLength, end - start);
        }
        return s.length() - resultLength;
    }

    public static void main(String[] args) {
        TakeCharacters takeCharacters = new TakeCharacters();
        int result = takeCharacters.takeCharacters("aabbccc", 1);
        System.out.println(result);
    }

}
