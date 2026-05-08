package com.gmy.leetcode.lingcha.window.max_count;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums 和一个 正整数 k 。
 * 请你统计有多少满足 「 nums 中的 最大 元素」至少出现 k 次的子数组，并返回满足这一条件的子数组的数目。
 * 子数组是数组中的一个连续元素序列。
 *
 * https://leetcode.cn/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/
 */
public class CountSubarraysMax {

    public long countSubarrays(int[] nums, int k) {
        int left = 0, count = 0, max = Arrays.stream(nums).max().getAsInt();
        long result = 0L;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == max) {
                count++;
            }
            while (count >= k) {
                result += nums.length - right;
                if (nums[left++] == max) {
                    count--;
                }
            }
        }
        return result;
    }

}
