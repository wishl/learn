package com.gmy.leetcode.monostone_stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof/
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        Deque<Integer> deque = new LinkedList<>();
        int max = 0;
        List<Integer> changeList = new ArrayList<>();
        for (int i = 0; i < prices.length; i++) {
            int result = 0;
            while (!deque.isEmpty() && prices[i] > prices[deque.peek()]) {
                Integer lastIndex = deque.pop();
                result = Math.max(result, prices[i] - prices[lastIndex] + changeList.get(lastIndex));
                max = Math.max(max, result);
            }
            changeList.add(result);
            deque.push(i);
        }
        return max;
    }

    public int maxProfit1(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0; i < prices.length; i++){
            min = Math.min(prices[i], min);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int result = maxProfit.maxProfit1(new int[]{2,1,4,5,2,9,7});
        System.out.println(result);
    }

}
