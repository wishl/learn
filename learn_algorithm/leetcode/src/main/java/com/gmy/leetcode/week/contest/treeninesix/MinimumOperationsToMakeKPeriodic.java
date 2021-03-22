package com.gmy.leetcode.week.contest.treeninesix;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个长度为 n 的字符串 word 和一个整数 k ，其中 k 是 n 的因数。
 * 在一次操作中，你可以选择任意两个下标 i 和 j，其中 0 <= i, j < n ，且这两个下标都可以被 k 整除，
 * 然后用从 j 开始的长度为 k 的子串替换从 i 开始的长度为 k 的子串。也就是说，将子串 word[i..i + k - 1]
 * 替换为子串 word[j..j + k - 1] 。
 * 返回使 word 成为 K 周期字符串 所需的 最少 操作次数。
 * 如果存在某个长度为 k 的字符串 s，使得 word 可以表示为任意次数连接 s ，
 * 则称字符串 word 是 K 周期字符串 。例如，如果 word == "ababab"，那么 word 就是 s = "ab" 时的 2 周期字符串 。
 *
 * https://leetcode.cn/problems/minimum-number-of-operations-to-make-word-k-periodic/description/
 *
 * 输入：word = "leetcodeleet", k = 4
 * 输出：1
 * 解释：可以选择 i = 4 和 j = 0 获得一个 4 周期字符串。这次操作后，word 变为 "leetleetleet" 。
 */
public class MinimumOperationsToMakeKPeriodic {

    /**
     * 把word切割为长度为k的子串 并记录次数 然后计算
     * @param word
     * @param k
     * @return
     */
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        Map<String, Integer> cache = new HashMap<>();
        for (int i = 0; i < word.length(); i += k) {
            cache.merge(word.substring(i, i + k), 1, (oldValue, value) -> oldValue + value);
        }
        Integer max = cache.entrySet().stream()
            .max(Comparator.comparingInt(Map.Entry::getValue))
            .map(Map.Entry::getValue)
            .orElse(0);
        return (word.length() - max * k) / k;
    }

    public static void main(String[] args) {
        MinimumOperationsToMakeKPeriodic minimumOperationsToMakeKPeriodic = new MinimumOperationsToMakeKPeriodic();
        int result = minimumOperationsToMakeKPeriodic.minimumOperationsToMakeKPeriodic("leetcoleet", 2);
        System.out.println(result);
    }
}
