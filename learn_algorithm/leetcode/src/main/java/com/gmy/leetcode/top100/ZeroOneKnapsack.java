package com.gmy.leetcode.top100;

import java.util.List;

/**
 * 0 - 1 背包问题
 */
public class ZeroOneKnapsack {

    public int zeroOneKnapsack(int capacity, List<Integer> weight, List<Integer> values) {
        return dfs(capacity, weight, values, weight.size() - 1);
    }

    private int dfs(int capacity, List<Integer> weight, List<Integer> values, int i) {
        if (i < 0) {
            return 0;
        }
        if (weight.get(i) > capacity) {
            return dfs(capacity, weight, values, i - 1);
        }
        return Math.max(dfs(capacity, weight, values, i - 1),
            dfs(capacity - weight.get(i), weight, values, i - 1) + values.get(i));
    }

}
