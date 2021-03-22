package com.gmy.leetcode.review;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * https://leetcode.cn/problems/minimum-size-subarray-sum/description/
 */
public class MinSubArrayLenReview {

    public int minSubArrayLen(int target, int[] nums) {
        int length = Integer.MAX_VALUE, sum = 0;
        int start = 0, end = 0;
        while (end < nums.length) {
            sum += nums[end++];
            while (sum >= target) {
                length = Math.min(length, end - start);
                sum -= nums[start++];
            }
        }
        return length == Integer.MAX_VALUE ? 0 : length;
    }

    public static void main(String[] args) {
        MinSubArrayLenReview minSubArrayLenReview = new MinSubArrayLenReview();
        int result = minSubArrayLenReview.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println(result);
    }

}
