package com.gmy.leetcode.lingcha.window.change;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k 。
 *
 * 一个元素 x 在数组中的 频率 指的是它在数组中的出现次数。
 *
 * 如果一个数组中所有元素的频率都 小于等于 k ，那么我们称这个数组是 好 数组。
 *
 * 请你返回 nums 中 最长好 子数组的长度。
 *
 * 子数组 指的是一个数组中一段连续非空的元素序列。
 */
public class MaxSubarrayLength {

    public int maxSubarrayLength(int[] nums, int k) {
        int left = 0, result = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            countMap.merge(nums[right], 1, Integer::sum);
            while (countMap.get(nums[right]) > k) {
                countMap.put(nums[left], countMap.get(nums[left]) - 1);
                left++;
            }
            result = Math.max(result, (right - left + 1));
        }
        return result;
    }

}
