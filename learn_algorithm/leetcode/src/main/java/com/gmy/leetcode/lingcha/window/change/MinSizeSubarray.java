package com.gmy.leetcode.lingcha.window.change;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个下标从 0 开始的数组 nums 和一个整数 target 。
 * 下标从 0 开始的数组 infinite_nums 是通过无限地将 nums 的元素追加到自己之后生成的。
 * 请你从 infinite_nums 中找出满足 元素和 等于 target 的 最短 子数组，并返回该子数组的长度。如果不存在满足条件的子数组，返回 -1 。
 *
 * https://leetcode.cn/problems/minimum-size-subarray-in-infinite-array/description/
 */
public class MinSizeSubarray {

    /**
     * 解题：https://leetcode.cn/problems/minimum-size-subarray-in-infinite-array/
     * 思路： result = K * sum(nums) + target % sum(nums)
     * 所以问题就转化成了 找到最小的sum ==  target % sum(nums)
     * 结果是 K * len(nums) + length
     * @param nums
     * @param target
     * @return
     */
    public int minSizeSubarray(int[] nums, int target) {
        int total = Arrays.stream(nums).sum(), k = target / total, left = 0, result = Integer.MAX_VALUE, sum = 0, length = nums.length;
        for (int right = 0; right < 2 * nums.length; right++) {
            sum += nums[right % length];
            while (sum >= target % total) {
                if (sum == target % total) {
                    result = Math.min(result, right - left + 1);
                }
                sum -= nums[left % length];
                left++;
            }
        }
        return result == Integer.MAX_VALUE ? -1 : k * length + result;
    }

    public static void main(String[] args) {
        MinSizeSubarray minSizeSubarray = new MinSizeSubarray();
        int result = minSizeSubarray.minSizeSubarray(new int[]{2, 1, 5, 7, 7, 1, 6, 3}, 39);
        System.out.println(result);
    }

}
