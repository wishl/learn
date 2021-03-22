package com.gmy.leetcode.review;

/**
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 */
public class MaxProfit2 {

    /**
     * 7,1,5,3,6,4,100
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // 第一位 代表天数 第二位代表是否持有股票 0 -> 不持有 1 -> 持有
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        MaxProfit2 maxProfit2 = new MaxProfit2();
        int result = maxProfit2.maxProfit(new int[]{7, 1, 5, 3, 6, 4, 100});
        System.out.println(result);
    }

}
