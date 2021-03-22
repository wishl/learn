package com.gmy.leetcode.top100;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组
 * 是数组中的一个连续部分。
 */
public class _0053_MaxSubArray {

    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result = Math.max(result, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return result;
    }

    /**
     * 当前的前缀和 - 前面最小的前缀和
     * @param nums
     * @return
     */
    public int maxSubArrayPrefix(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int minPreSum = 0;
        int preSum = 0;
        for (int x : nums) {
            preSum += x; // 当前的前缀和
            ans = Math.max(ans, preSum - minPreSum); // 减去前缀和的最小值
            minPreSum = Math.min(minPreSum, preSum); // 维护前缀和的最小值
        }
        return ans;
    }

    /**
     * 动态规划做法
     * @param nums
     * @return
     */
    public int maxSubArrayDp(int[] nums) {
        int dp[] = new int[nums.length + 1], ans = Integer.MIN_VALUE;
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            // 最大前缀 + 自己
            dp[i + 1] = Math.max(dp[i], 0) + nums[i];
            ans = Math.max(dp[i + 1], ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        _0053_MaxSubArray maxSubArray = new _0053_MaxSubArray();
        int result = maxSubArray.maxSubArray(new int[]{1});
        System.out.println(result);
    }

}
