package com.gmy.leetcode.week.contest.treeninefour;


/**
 * 给你一个字符串 word。如果 word 中同时存在某个字母的小写形式和大写形式，则称这个字母为 特殊字母 。
 *
 * 返回 word 中 特殊字母 的数量。
 */
public class NumberOfSpecialChars {

    public int numberOfSpecialChars(String word) {
        int[] charSet = new int[26];
        int[] lowerCharSet = new int[26];
        char[] charArray = word.toCharArray();
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            // 小写
            if (c - 'Z' > 0) {
                int index = c - 'a';
                if (charSet[index] > 0 && lowerCharSet[index] == 0) {
                    count++;
                }
                lowerCharSet[index]++;
            } else {
                // 大写
                int index = c - 'A';
                if (lowerCharSet[index] > 0 && charSet[index] == 0) {
                    count++;
                }
                charSet[index]++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfSpecialChars numberOfSpecialChars = new NumberOfSpecialChars();
        int result = numberOfSpecialChars.numberOfSpecialChars("AbBCab");
        System.out.println(result);
    }

}
