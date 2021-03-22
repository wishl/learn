package com.gmy.leetcode.week.march.tree;

import java.util.Arrays;

/**
 * 给你一个字符串 word 和一个整数 k。
 * 如果 |freq(word[i]) - freq(word[j])| <= k 对于字符串中所有下标 i 和 j  都成立，则认为 word 是 k 特殊字符串。
 * 此处，freq(x) 表示字符 x 在 word 中的
 * 出现频率，而 |y| 表示 y 的绝对值。返回使 word 成为 k 特殊字符串 需要删除的字符的最小数
 *
 * https://leetcode.cn/problems/minimum-deletions-to-make-string-k-special/description/
 *
 * aaaaacaaaaa
 * aabcaba
 */
public class MinimumDeletions {

    /**
     * 结论中每个字母重复的此时区间为 [n, m]
     * 搞个数据结构 存储出现M次的字母总量
     * 然后遍历把每个字母的出现次数当做n, m = n + k
     * 然后遍历结算
     * 1. 如果word中的字母i重复的次数 >= n 则最多留下 min(count(i), n + k)
     * 2. 如果word中的字母i重复次数 < n 则一个也不能留
     * 计算最多留下的字母数 N
     * 记过为 length - N
     *
     * @param word
     * @return
     */
    public int minimumDeletions(String word, int k) {
        int maxSave = 0;
        char[] charArray = word.toCharArray();
        int[] countArray = new int[26];
        for (char c : charArray) {
            countArray[c - 'a']++;
        }
        Arrays.sort(countArray);
        for (int i = 0; i < 26; i++) {
            int sum = 0;
            // 小于的都不要
            for (int j = i; j < 26; j++) {
                sum += Math.min(countArray[j], countArray[i] + k);
            }
            maxSave = Math.max(sum, maxSave);
        }
        return word.length() - maxSave;
    }

    public static void main(String[] args) {
        MinimumDeletions minimumDeletions = new MinimumDeletions();
        int result = minimumDeletions.minimumDeletions("aaaacaaaa", 2);
        System.out.println(result);
    }

}
