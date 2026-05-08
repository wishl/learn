package com.gmy.leetcode.lingcha.window.max_count;

/**
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 * 子数组 是数组的一段连续部分。
 *
 * https://leetcode.cn/problems/binary-subarrays-with-sum/description/
 */
public class NumSubarraysWithSum {

    public int numSubarraysWithSum(int[] nums, int goal) {
        return getGte(nums, goal) - getGte(nums, goal + 1);
    }

    public int getGte(int[] nums, int goal) {
        int left = 0, result = 0, sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= goal && left <= right) {
                result += nums.length - right;
                sum -= nums[left];
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NumSubarraysWithSum numSubarraysWithSum = new NumSubarraysWithSum();
        System.out.println(numSubarraysWithSum.numSubarraysWithSum(new int[] {0,0,0,0,0}, 0));
    }

}
