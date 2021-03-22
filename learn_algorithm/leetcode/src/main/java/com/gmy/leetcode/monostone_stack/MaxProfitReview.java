package com.gmy.leetcode.monostone_stack;

public class MaxProfitReview {

    public int maxProfit(int[] prices) {
        int result = 0;
        int j = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            result = Math.max(result, price - j);
            j = Math.min(j, price);
        }
        return result;
    }

    public static void main(String[] args) {
        MaxProfitReview maxProfitReview = new MaxProfitReview();
        int result = maxProfitReview.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(result);
    }

}
