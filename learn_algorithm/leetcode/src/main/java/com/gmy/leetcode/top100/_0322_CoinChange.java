package com.gmy.leetcode.top100;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 */
public class _0322_CoinChange {

    public int coinChange2(int[] coins, int amount) {
        int n = coins.length;
        int[][] f = new int[n + 1][amount + 1];
        Arrays.fill(f[0], Integer.MAX_VALUE / 2); // 除 2 防止下面 + 1 溢出
        f[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int c = 0; c <= amount; c++) {
                if (c < coins[i]) f[i + 1][c] = f[i][c];
                else f[i + 1][c] = Math.min(f[i][c], f[i + 1][c - coins[i]] + 1);
            }
        }
        int ans = f[n][amount];
        return ans < Integer.MAX_VALUE / 2 ? ans : -1;
    }

    /**
     * 1比1翻译递推
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[amount + 1][coins.length + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE / 2); // -1 表示没有访问过
        }
        dp[0][0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] > i) {
                    // 只能不选
                    dp[i][j + 1] = dp[i][j];
                } else {
                    dp[i][j + 1] = Math.min(dp[i][j], dp[i - coins[j]][j + 1] + 1);
                }
            }
        }
        return dp[amount][coins.length] >= Integer.MAX_VALUE / 2 ? -1 : dp[amount][coins.length];
    }

    /**
     * dfs + 记忆化
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange1(int[] coins, int amount) {
        int length = coins.length;
        int[][] cache = new int[amount + 1][length];
        for (int[] row : cache) {
            Arrays.fill(row, -1); // -1 表示没有访问过
        }
        int dfs = dfs(coins, amount, coins.length - 1, cache);
        return dfs >= Integer.MAX_VALUE / 2 ? -1 : dfs;
    }

    private int dfs(int[] coins, int amount, int index, int[][] cache) {
        if (index < 0) {
            return amount == 0 ? 0 : Integer.MAX_VALUE / 2; // 除 2 防止下面 + 1 溢出
        }
        if (amount < coins[index]) {
            return dfs(coins, amount, index - 1, cache);
        }
        if (cache[amount][index] != -1) {
            return cache[amount][index];
        }
        int min = Math.min(dfs(coins, amount, index - 1, cache),
            dfs(coins, amount - coins[index], index, cache) + 1);
        cache[amount][index] = min;
        return min;
    }


    public static void main(String[] args) {
        _0322_CoinChange coinChange = new _0322_CoinChange();
        int result = coinChange.coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(result);
    }

}
