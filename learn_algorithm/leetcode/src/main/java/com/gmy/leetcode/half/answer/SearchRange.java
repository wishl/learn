package com.gmy.leetcode.half.answer;

import java.util.Arrays;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class SearchRange {

    /**
     * 获取大于等于target的最小值
     * @param nums
     * @param target
     * @return
     */
    public int lowerBound(int[] nums, int target) {
        // [left, right]
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int[] searchRange(int[] nums, int target) {
        // 1. 先获取 >= target 的最小值的index
        int start = lowerBound(nums, target);
        // 2. 如果不存在 >= target 的值 或 这个值不等于 target 则返回 -1 -1
        if (start == nums.length || nums[start] != target) {
            return new int[] {-1, -1};
        }
        // 3. 计算 >= target + 1 的最小值的index 并 index - 1
        int end = lowerBound(nums, target + 1) - 1;
        return new int[] {start, end};
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        int[] result = searchRange.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(Arrays.toString(result));
    }

}
