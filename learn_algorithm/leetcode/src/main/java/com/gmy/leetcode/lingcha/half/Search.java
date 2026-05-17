package com.gmy.leetcode.lingcha.half;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果 target 存在返回下标，否则返回 -1。
 * 你必须编写一个具有 O(log n) 时间复杂度的算法。
 *
 * https://leetcode.cn/problems/binary-search/description/
 */
public class Search {

    public int search(int[] nums, int target) {
        int result = find(nums, target);
        return result == nums.length || nums[result] != target ? -1 : result;
    }

    /**
     * 获取大于等于target的最大值
     * @param nums
     * @param target
     * @return
     */
    private int find(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}
