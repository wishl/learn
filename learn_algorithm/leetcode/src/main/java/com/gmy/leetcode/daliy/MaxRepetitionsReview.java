package com.gmy.leetcode.daliy;

import java.util.HashMap;
import java.util.Map;

/**
 * @see MaxRepetitions
 */
public class MaxRepetitionsReview {

    /**
     *
     * 对齐之后计算个数
     * @return
     */
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int s1Cnt = 0, s2Cnt = 0, index = 0;
        int[] pre = new int[2];
        int[] current = new int[2];
        Map<Integer, int[]> cache = new HashMap<>();
        while (true) {
            s1Cnt++;
            for (int i = 0; i < s1.length(); i++) {
                char s1Char = s1.charAt(i);
                char s2Char = s2.charAt(index);
                if (s1Char == s2Char) {
                    index++;
                    if (index == s2.length()) {
                        s2Cnt++;
                        index = 0;
                    }
                }
            }
            // 如果没出现循环就结束了
            if (s1Cnt == n1) {
                return s2Cnt / n2;
            }
            // 如果之前有过这个index 说明对齐了
            if (cache.containsKey(index)) {
                pre = cache.get(index);
                current = new int[] {s1Cnt - pre[0], s2Cnt - pre[1]};
                break;
            } else {
                cache.put(index, new int[] {s1Cnt, s2Cnt});
            }
        }
        // 计算循环中和循环前
        int ans = pre[1] + ((n1 - pre[0]) / current[0]) * current[1];
        // 计算剩下的数量
        int rest = (n1 - pre[0]) % current[0];
        for (int i = 0; i < rest; ++i) {
            for (int j = 0; j < s1.length(); ++j) {
                char ch = s1.charAt(j);
                if (ch == s2.charAt(index)) {
                    index++;
                    if (index == s2.length()) {
                        ans++;
                        index = 0;
                    }
                }
            }
        }
        return ans / n2;
    }

    public static void main(String[] args) {
        MaxRepetitionsReview maxRepetitions = new MaxRepetitionsReview();
        int result = maxRepetitions.getMaxRepetitions("baba",  11, "baab", 1);
        // abcabcabcabcabcabcabcabc
        // abca  abca  abca  abca
        System.out.println(result);
    }
}
