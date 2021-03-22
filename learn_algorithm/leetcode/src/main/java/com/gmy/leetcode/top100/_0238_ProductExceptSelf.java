package com.gmy.leetcode.top100;

/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class _0238_ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int[] prefix = new int[length];
        int[] suffix = new int[length];
        prefix[0] = 1;
        suffix[length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            int suffixIndex = length - 1 - i;
            suffix[suffixIndex] = suffix[suffixIndex + 1] * nums[suffixIndex + 1];
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        for (int i = 0; i < suffix.length; i++) {
            result[i] = suffix[i] * prefix[i];
        }
        return result;
    }

}
