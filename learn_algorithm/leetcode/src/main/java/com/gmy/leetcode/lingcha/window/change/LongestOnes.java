package com.gmy.leetcode.lingcha.window.change;

/**
 * 给定一个二进制数组 nums 和一个整数 k，假设最多可以翻转 k 个 0 ，则返回执行操作后 数组中连续 1 的最大个数 。
 *
 * https://leetcode.cn/problems/max-consecutive-ones-iii/description/
 */
public class LongestOnes {


    public int longestOnes(int[] nums, int k) {
        int left = 0, result = 0, count = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                count++;
            }
            while (count > k) {
                if (nums[left++] == 0) {
                    count--;
                }
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

}
