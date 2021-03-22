package com.gmy.leetcode.week.contest.treeninetwo;

/**
 * 给你一个整数数组 nums 。
 *
 * 返回数组 nums 中
 * 严格递增
 *  或
 * 严格递减
 *  的最长非空子数组的长度。
 *
 * 输入：nums = [3,2,1]
 * 输出：3
 * 解释：
 * nums 中严格递增的子数组有 [3]、[2] 以及 [1] 。
 * nums 中严格递减的子数组有 [3]、[2]、[1]、[3,2]、[2,1] 以及 [3,2,1] 。
 *
 * 因此，返回 3
 */
public class LongestMonotonicSubarray {

    public int longestMonotonicSubarray(int[] nums) {
        int result = 1, up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up++;
                down = 1;
                result = Math.max(up, result);
            } else if (nums[i] < nums[i - 1]) {
                down++;
                up = 1;
                result = Math.max(down, result);
            } else {
                down = 1;
                up = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestMonotonicSubarray longestMonotonicSubarray = new LongestMonotonicSubarray();
        int result = longestMonotonicSubarray.longestMonotonicSubarray(new int[]{1, 2, 3});
        System.out.println(result);
    }

}
