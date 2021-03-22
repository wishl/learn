package com.gmy.leetcode.review.prefix;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子 k数组内所有元素的乘积严格小于 的连续子数组的数目。
 * https://leetcode.cn/problems/subarray-product-less-than-k/description/
 */
public class NumSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0, end = 0, result = 0, prod = 1;
        while (end < nums.length) {
            prod *= nums[end];
            while (start <= end && prod >= k) {
                prod = prod / nums[start++];
            }
            // 为什么是 result 要加上 (end - start + 1)
            // 因为end每多一个数 每个在 以index范围 [start, end) 为的子数字 开头的集合的组合都会 + 1 并且新增一个 单独的 end
            // 以 [1, 2, 3] 为例
            // 当 end 从 1 变为 2 时
            // 以 1 开头的组合 从 [1] [1, 2] 变为 [1] [1, 2] [1, 2, 3]
            // 以 2 开头的组合 从 [2] 变为 [2] [2, 3]
            // 同时 新增了个 [3]
            // 所以数字每次长度增加1 组合的个数 就增加新的数组长度个
            result += end - start + 1;
            end++;
        }
        return result;
    }

}
