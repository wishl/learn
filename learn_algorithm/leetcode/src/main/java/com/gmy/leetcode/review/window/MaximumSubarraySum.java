package com.gmy.leetcode.review.window;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k 。请你从 nums 中满足下述条件的全部子数组中找出最大子数组和：
 * 子数组的长度是 k，且
 * 子数组中的所有元素 各不相同 。
 * 返回满足题面要求的最大子数组和。如果不存在子数组满足这些条件，返回 0 。
 *
 * 子数组 是数组中一段连续非空的元素序列。
 *
 *https://leetcode.cn/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
 *
 * 1,9,9,4,2,9,9,9
 */
public class MaximumSubarraySum {

    public long maximumSubarraySum(int[] nums, int k) {
        int start = 0, end = 0;
        long sum = 0, result = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        while (end < nums.length) {
            while (end - start < k) {
                int num = nums[end++];
                sum += num;
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
            if (countMap.size() == k) {
                result = Math.max(sum, result);
            }
            int startNum = nums[start++];
            sum -= startNum;
            Integer startCount = countMap.get(startNum);
            if (startCount == 1) {
                countMap.remove(startNum);
            } else {
                countMap.put(startNum, startCount - 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaximumSubarraySum maximumSubarraySum = new MaximumSubarraySum();
        long result = maximumSubarraySum.maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9, 8, 7}, 3);
        System.out.println(result);
    }

}
