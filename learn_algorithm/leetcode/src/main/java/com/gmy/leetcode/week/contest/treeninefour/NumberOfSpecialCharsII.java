package com.gmy.leetcode.week.contest.treeninefour;

/**
 * 给你一个字符串 word。如果 word 中同时出现某个字母 c 的小写形式和大写形式，
 * 并且 每个 小写形式的 c 都出现在第一个大写形式的 c 之前，则称字母 c 是一个 特殊字母 。
 *
 * 返回 word 中 特殊字母 的数量。
 */
public class NumberOfSpecialCharsII {

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
                // 每个小写字母都出现在大写字母之前
                if (lowerCharSet[index] > 0 && charSet[index] > 0) {
                    count--;
                    lowerCharSet[index] = 0;
                }
                if (charSet[index] == 0) {
                    lowerCharSet[index]++;
                }
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
        NumberOfSpecialCharsII numberOfSpecialChars = new NumberOfSpecialCharsII();
        int result = numberOfSpecialChars.numberOfSpecialChars("aaAbcBC");
        System.out.println(result);
    }
}
