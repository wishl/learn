package com.gmy.leetcode.half.answer;

/**
 * 给你一个按 非递减顺序 排列的数组 nums ，返回正整数数目和负整数数目中的最大值。
 * 换句话讲，如果 nums 中正整数的数目是 pos ，而负整数的数目是 neg ，返回 pos 和 neg二者中的最大值。
 * 注意：0 既不是正整数也不是负整数。
 *
 * https://leetcode.cn/problems/maximum-count-of-positive-integer-and-negative-integer/description/
 */
public class MaximumCount {

    public int maximumCount(int[] nums) {
        // 大于等于0的第一个index
        int neg = search(nums, 0);
        // 大于等于1的第一个index
        int pos = search(nums, 1);
        return Math.max(neg, nums.length - pos);
    }

    private int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // left 左边严格小于target 右边大于等于target
            // [left, right]
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
        MaximumCount maximumCount = new MaximumCount();
        int result = maximumCount.maximumCount(new int[]{-3,-2,-1,0,0,1,2});
        System.out.println(result);
    }

}
