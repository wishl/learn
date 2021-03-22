package com.gmy.leetcode.week.march.tree;

import java.util.HashMap;
import java.util.Map;

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
public class MinimumDeletionsReview {

    /**
     * 把每个字符出现次数当做做多 然后计算删除最少的次数
     * @param word
     * @param k
     * @return
     */
    public int minimumDeletions(String word, int k) {
        char[] charArray = word.toCharArray();
        Map<Character, Integer> countMap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (char c : charArray) {
            Integer count = countMap.getOrDefault(c, 0);
            countMap.put(c, count + 1);
        }
        for (char c : charArray) {
            Integer maxCount = countMap.get(c);
            int sumDelete = 0;
            for (int i = 0; i < 26; i++) {
                char c1 = (char) (i + 'a');
                Integer c1Count = countMap.getOrDefault(c1, 0);
                // 小于 maxCount - k 的全部不要
                if (c1Count < maxCount - k) {
                    sumDelete += c1Count;
                } else if (c1Count > maxCount) {
                    // 大于 maxCount + k 的大于部分不要
                    sumDelete += c1Count - maxCount;
                }
            }
            min = Math.min(min, sumDelete);
        }
        return min;
    }

    public static void main(String[] args) {
        MinimumDeletionsReview minimumDeletionsReview = new MinimumDeletionsReview();
        // dabdcbdcdcd
        // dddddbbccca
        int result = minimumDeletionsReview.minimumDeletions("hhhhhhaaaan", 1);
        System.out.println(result);
    }

}
