package com.gmy.leetcode.week.dobuleweek.onetwoseven;

/**
 * 给你一个 非负 整数数组 nums 和一个整数 k 。
 * 如果一个数组中所有元素的按位或运算 OR 的值 至少 为 k ，那么我们称这个数组是 特别的 。
 * 请你返回 nums 中 最短特别非空
 * 子数组
 * 的长度，如果特别子数组不存在，那么返回 -1 。
 * 示例 1：
 * 输入：nums = [1,2,3], k = 2
 * 输出：1
 * 解释：
 *
 * 子数组 [3] 的按位 OR 值为 3 ，所以我们返回 1 。
 *
 * 示例 2：
 *
 * 输入：nums = [2,1,8], k = 10
 *
 * 输出：3
 *
 * 解释：
 *
 * 子数组 [2,1,8] 的按位 OR 值为 11 ，所以我们返回 3 。
 *
 * 示例 3：
 *
 * 输入：nums = [1,2], k = 0
 *
 * 输出：1
 *
 * 解释：
 *
 * 子数组 [1] 的按位 OR 值为 1 ，所以我们返回 1 。
 */
public class MinimumSubarrayLengthII {

    /**
     * 解题
     * https://leetcode.cn/problems/smallest-subarrays-with-maximum-bitwise-or/solutions/1830911/by-endlesscheng-zai1/
     * @param nums
     * @param k
     * @return
     */
    public int minimumSubarrayLength(int[] nums, int k) {
        int start = 0, end = 0, min = Integer.MAX_VALUE, result = 0;
        while (end < nums.length) {
            result = result | nums[end];
            while (result >= k && start <= end) {
                min = Math.min(end - start + 1, min);
                start++;
                result = or(nums, start, end);
            }
            end++;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int or(int[] nums, int start, int right) {
        int result = 0;
        for (int i = start; i <= right; i++) {
            result = result | nums[i];
        }
        return result;
    }
}
