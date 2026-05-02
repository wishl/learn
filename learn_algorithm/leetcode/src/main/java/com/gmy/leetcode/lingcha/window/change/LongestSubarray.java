package com.gmy.leetcode.lingcha.window.change;

/**
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 * 如果不存在这样的子数组，请返回 0 。
 */
public class LongestSubarray {

    public int longestSubarray(int[] nums) {
        int left = 0, notZeroCount = 0, result = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 1) {
                notZeroCount++;
            }
            while (notZeroCount > 1) {
                if (nums[left] != 1) {
                    notZeroCount--;
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result - 1;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubarray().longestSubarray(new int[]{0,0,0}));
    }

}
