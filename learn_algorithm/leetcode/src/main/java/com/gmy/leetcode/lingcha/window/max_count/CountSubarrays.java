package com.gmy.leetcode.lingcha.window.max_count;

/**
 * 一个数组的 分数 定义为数组之和 乘以 数组的长度。
 * 比方说，[1, 2, 3, 4, 5] 的分数为 (1 + 2 + 3 + 4 + 5) * 5 = 75 。
 * 给你一个正整数数组 nums 和一个整数 k ，请你返回 nums 中分数 严格小于 k 的 非空整数子数组数目。
 * 子数组 是数组中的一个连续元素序列。
 *
 * https://leetcode.cn/problems/count-subarrays-with-score-less-than-k/description/
 */
public class CountSubarrays {

    public long countSubarrays(int[] nums, long k) {
        int left = 0;
        long sum = 0L, result = 0L;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while ((sum * (right - left + 1)) >= k) {
                sum -= nums[left];
                left++;
            }
            result += (right - left + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        CountSubarrays countSubarrays = new CountSubarrays();
        long result = countSubarrays.countSubarrays(new int[]{2, 1, 4, 3, 5}, 10);
        System.out.println(result);
    }

}
