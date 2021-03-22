package com.gmy.leetcode.dp.memery.simple;

import java.util.Arrays;

/**
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。请你计算并返回达到楼梯顶部的最低花费。
 *
 * https://leetcode.cn/problems/min-cost-climbing-stairs/description/
 */
public class MinCostClimbingStairs {


    /**
     * dfs方法 + 记忆化
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] cache = new int[cost.length];
        Arrays.fill(cache, -1);
        return dfs(cost, cost.length, cache);
    }

    private int dfs(int[] cost, int n, int[] cache) {
        // 因为 下标为 0 或下标为 1 的台阶开始爬楼梯 所以 n <= 1 的时候 cost 为0
        if (n <= 1) {
            return 0;
        }
        if (cache[n - 1] != -1) {
            return cache[n - 1];
        }
        int result = Math.min(dfs(cost, n - 1, cache) + cost[n - 1], dfs(cost, n - 2, cache) + cost[n - 2]);
        cache[n - 1] = result;
        return result;
    }

    /**
     * 递推法
     * @param args
     */
    public int minCostClimbingStairs1(int[] cost) {
        int[] cache = new int[cost.length + 1];
        for (int i = 2; i <= cost.length; i++) {
            cache[i] = Math.min(cache[i - 1] + cost[i - 1], cache[i - 2] + cost[i - 2]);
        }
        return cache[cost.length];
    }

    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int[] f = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            f[i] = Math.min(f[i - 1] + cost[i - 1], f[i - 2] + cost[i - 2]);
        }
        return f[n];
    }


    public static void main(String[] args) {
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        int result = minCostClimbingStairs.minCostClimbingStairs1(new int[]{1, 100});
        System.out.println(result);
    }



}
