package com.gmy.leetcode.top100;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class _0121_MaxProfit {

    public int maxProfit(int[] prices) {
        int result = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                result = Math.max(result, prices[i] - min);
            }
            min = Math.min(prices[i], min);
        }
        return result;
    }

    public static void main(String[] args) {
        _0121_MaxProfit maxProfit = new _0121_MaxProfit();
        int result = maxProfit.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(result);
    }

}
