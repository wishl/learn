package com.gmy.leetcode.top100;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class _0035_SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 左边小于target 右边大于等于target
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

    public static void main(String[] args) {
        _0035_SearchInsert searchInsert = new _0035_SearchInsert();
        int result = searchInsert.searchInsert(new int[]{1, 3, 5, 6}, 2);
        System.out.println(result);
    }

}
