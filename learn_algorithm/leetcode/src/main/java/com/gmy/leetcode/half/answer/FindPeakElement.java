package com.gmy.leetcode.half.answer;

/**
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 *
 * https://leetcode.cn/problems/find-peak-element/description/
 */
public class FindPeakElement {

    /**
     * nums数组的最后一个元素一定是峰值的右边
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        // [left, right]
        int left = 0, right = nums.length - 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            // 证明mid再峰值的右边或者 等于峰值
            if (nums[mid] > nums[mid + 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        FindPeakElement findPeakElement = new FindPeakElement();
        int result = findPeakElement.findPeakElement(new int[]{5, 6, 7, 0, 1, 2});
        System.out.println(result);
    }

}
