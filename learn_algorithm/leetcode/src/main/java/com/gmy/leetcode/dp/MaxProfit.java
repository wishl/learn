package com.gmy.leetcode.dp;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 *
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int result = 0, pre = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < pre) {
                pre = prices[i];
            } else {
                result = Math.max(result, prices[i] - pre);
            }
        }
        return result;
    }

    //public int maxProfit(int[] prices) {
    //        int[][] dp = new int[prices.length][2];
    //        dp[0][0] = 0;
    //        dp[0][1] = -prices[0];
    //        for (int i = 1; i < prices.length; i++) {
    //            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
    //            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
    //        }
    //        return dp[prices.length - 1][0];
    //    }
}
