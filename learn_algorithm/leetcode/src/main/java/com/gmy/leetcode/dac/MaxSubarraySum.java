package com.gmy.leetcode.dac;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * https://www.jianshu.com/p/3a38d523503b
 */
public class MaxSubarraySum {

    /**
     * 动态规划方式计算：如果 + 之前的sum为负 则 以当前为基准重新计算
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int max = nums[0];    // 全局最大值
        int subMax = nums[0];  // 前一个子组合的最大值
        for (int i = 1; i < nums.length; i++) {
            if (subMax > 0) {
                // 前一个子组合最大值大于0，正增益
                subMax = subMax + nums[i];
            } else {
                // 前一个子组合最大值小于0，抛弃前面的结果
                subMax = nums[i];
            }
            // 计算全局最大值
            max = Math.max(max, subMax);
        }
        return max;
    }

    public int kadane(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int sum = 0;
        int bestSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            bestSum = Math.max(sum, bestSum);
        }
        return bestSum;
    }

    public int kadane1(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int sum = nums[0];
        int bestSum = nums[0];
        int viewed = 1;
        int length = nums.length;
        for (int i = 1; viewed < length; i++) {
            if (bestSum < 0) {
                viewed = 1;
            }
            if (i == length && bestSum > 0) {
                i = 0;
            } else if (i == length) {
                return bestSum;
            }
            sum = Math.max(sum + nums[i], nums[i]);
            bestSum = Math.max(sum, bestSum);
            viewed++;
        }
        return bestSum;
    }

    public static void main(String[] args) {
        MaxSubarraySum maxSubarraySum = new MaxSubarraySum();
        int kadane = maxSubarraySum.kadane(new int[]{5, -3, 5});
        System.out.println(kadane);
    }

}
