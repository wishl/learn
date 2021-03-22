package com.gmy.leetcode.review;

import java.beans.PropertyEditorSupport;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class MaxProfit {

    /**
     * 7,1,5,3,6,4
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int start = Integer.MAX_VALUE, result = 0;
        for (int i = 0; i < prices.length; i++) {
            result = Math.max(prices[i] - start, result);
            start = Math.min(start, prices[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int result = maxProfit.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(result);
    }
}
