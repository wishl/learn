package com.gmy.leetcode.lingcha.window.max_count;

/**
 * 给你一个整数数组 nums 和一个整数 k。如果某个连续子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * 请返回这个数组中 「优美子数组」 的数目。
 *
 * https://leetcode.cn/problems/count-number-of-nice-subarrays/description/
 */
public class NumberOfSubarrays {

    public int numberOfSubarrays(int[] nums, int k) {
        return getKCount(nums, k) - getKCount(nums, k + 1);
    }

    public int getKCount(int[] nums, int k) {
        int left = 0, result = 0, count = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 == 1) {
                count++;
            }
            while (count >= k) {
                result += nums.length - right;
                if (nums[left] % 2 == 1) {
                    count--;
                }
                left++;
            }
        }
        return result;
    }

}
