package com.gmy.leetcode.week.contest.treeninenine;

/**
 * 给你一个字符串 word，请你使用以下算法进行压缩：
 * 从空字符串 comp 开始。当 word 不为空 时，执行以下操作：
 * 移除 word 的最长单字符前缀，该前缀由单一字符 c 重复多次组成，且该前缀长度 最多 为 9 。
 * 将前缀的长度和字符 c 追加到 comp 。
 * 返回字符串 comp 。
 *
 * https://leetcode.cn/problems/string-compression-iii/description/
 */
public class CompressedString {

    public String compressedString(String word) {
        int start = 0, end = 0;
        char[] charArray = word.toCharArray();
        StringBuilder result = new StringBuilder();
        int count = 0;
        while (end < charArray.length) {
            if (charArray[end] != charArray[start] || count >= 9) {
                result.append(count);
                result.append(charArray[start]);
                count = 0;
                start = end;
            } else {
                count++;
                end++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        CompressedString compressedString = new CompressedString();
        String result = compressedString.compressedString("abcde");
        System.out.println(result);
    }

}
