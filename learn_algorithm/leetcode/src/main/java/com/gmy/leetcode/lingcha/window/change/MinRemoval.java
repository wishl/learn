package com.gmy.leetcode.lingcha.window.change;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums 和一个整数 k。
 *
 * 如果一个数组的 最大 元素的值 至多 是其 最小 元素的 k 倍，则该数组被称为是 平衡 的。
 *
 * 你可以从 nums 中移除 任意 数量的元素，但不能使其变为 空 数组。
 *
 * 返回为了使剩余数组平衡，需要移除的元素的 最小 数量。
 *
 * 注意：大小为 1 的数组被认为是平衡的，因为其最大值和最小值相等，且条件总是成立。
 * https://leetcode.cn/problems/minimum-removals-to-balance-array/description/
 *
 */
public class MinRemoval {

    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        return dfs(nums, 0, nums.length - 1, 0, k);
    }

    private int dfs(int[] num, int start, int end, int count, int k) {
        if (num[start] * k < num[end]) {
            int deleteStart = dfs(num, start + 1, end, count + 1, k);
            int deleteEnd = dfs(num, start, end - 1, count + 1, k);
            return Math.min(deleteStart, deleteEnd);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0, 100, 500};
        System.out.println(new MinRemoval().minRemoval(nums, 3));
    }


}
