package com.gmy.leetcode.dp.memery.simple;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组
 * 是数组中的一个连续部分。
 *
 * https://leetcode.cn/problems/maximum-subarray/description/
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int[] dp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i], 0) + nums[i];
            result = Math.max(dp[i + 1], result);
        }
        return result;
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int result = maxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(result);
    }
}
