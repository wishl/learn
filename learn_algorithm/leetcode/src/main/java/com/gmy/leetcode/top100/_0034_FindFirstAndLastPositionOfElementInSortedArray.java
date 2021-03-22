package com.gmy.leetcode.top100;

import java.util.Arrays;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 */
public class _0034_FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int left = search(nums, target);
        if (left >= nums.length || nums[left] != target) {
            return new int[] {-1, -1};
        }
        int right = search(nums, target + 1);
        return new int[] {left, right - 1};
    }

    /**
     * 搜索大于等于target的最小值
     * @param nums
     * @param target
     * @return
     */
    private int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 左边小于等于 右边严格大于
        while (left <= right) {
            int mid = (left + right) / 2;
            int num = nums[mid];
            if (num >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        _0034_FindFirstAndLastPositionOfElementInSortedArray findFirstAndLastPositionOfElementInSortedArray = new _0034_FindFirstAndLastPositionOfElementInSortedArray();
        int[] result = findFirstAndLastPositionOfElementInSortedArray.searchRange(new int[]{5, 7, 7, 8, 8, 10}, -1);
        System.out.println(Arrays.toString(result));
    }

}
