package com.gmy.leetcode.week.contest.treeninetwo;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums 和一个 非负 整数 k 。一次操作中，你可以选择任一元素 加 1 或者减 1 。
 * 请你返回将 nums 中位数 变为 k 所需要的 最少 操作次数。
 * 一个数组的中位数指的是数组按非递减顺序排序后最中间的元素。如果数组长度为偶数，我们选择中间两个数的较大值为中位数。
 *
 * https://leetcode.cn/problems/minimum-operations-to-make-median-of-array-equal-to-k/description/
 *
 * 输入：nums = [2,5,6,8,5], k = 4
 *              2,5,5,6,8
 *              2 4 6 8 4
 *              2 4 4 6 8
 *
 *         1, 3, 5, 7, 9
 *         2
 * 输出：2
 * 
 * 1, 2, 6, 8
 *    4
 *    3
 * 1, 2, 4, 8
 *
 * 1, 3, 5, 8
 *
 * 1, 2, 9, 10
 *      5
 *      4
 * 1, 2, 6, 10
 *    4, 4
 * 1, 2, 4, 10
 *
 * 解释：我们将 nums[1] 和 nums[4] 减 1 得到 [2, 4, 6, 8, 4] 。现在数组的中位数等于 k 。
 *
 * 输入：nums = [1,2,3,4,5,6], k = 4
 * 输出：0
 *
 * 解释：数组中位数已经等于 k 了。
 */
public class MinOperationsToMakeMedianK {

    /**
     * 根据中位数的定理 只需要让中位数左边的数 都小于中位数 且 中位数右边的数都大于中位数即可
     * 因为如果为偶数 使用较大的为中位数 所以这里不需要向后考虑
     * 如果正常中位数 则如果是偶数计算到中位数的最后一位
     * 例如：1, 2, 6, 10 中位数修改为4 则 需要验证 1 2 要小于等于4 且 2, 6, 10 要大于等于4
     * @param nums
     * @param k
     * @return
     */
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        long ans = 0;
        int m = nums.length / 2;
        // 中位数大 则需要把中位数之前的都验证下是否大于k
        if (nums[m] > k) {
            for (int i = m; i >= 0 && nums[i] > k; i--) {
                ans += nums[i] - k;
            }
        } else {
            for (int i = m; i < nums.length && nums[i] < k; i++) {
                ans += k - nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MinOperationsToMakeMedianK minOperationsToMakeMedianK = new MinOperationsToMakeMedianK();
        long result = minOperationsToMakeMedianK.minOperationsToMakeMedianK(new int[]{1, 2, 6, 10}, 4);
        System.out.println(result);
    }
}
