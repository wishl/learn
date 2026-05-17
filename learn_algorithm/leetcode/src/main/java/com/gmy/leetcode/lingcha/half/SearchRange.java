package com.gmy.leetcode.lingcha.half;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int left = find(nums, target);
        if (left == nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }
        int right = find(nums, target + 1) - 1;
        return new int[]{left, right};
    }

    /**
     * 找到大于等于targe的最小的index
     * 闭区间写法 [0, len(nums) - 1]
     * @return
     */
    private int find(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {// mid 小于等于 target
                right = mid - 1;
            }
        }
        return left;
    }
}
