package com.gmy.leetcode.dp;

import java.util.Arrays;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class CanPartition {

    public static boolean canPartition(int[] nums) {
        int total = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            total += nums[i];
        }
        if (total % 2 != 0) {
            return false;
        }
        return getResult(nums, nums[0], total, 1);
    }

    private static boolean getResult(int[] nums, int num, int total, int count) {
        if (total - num == num) {
            return true;
        }
        for (int i = count; i < nums.length; i++) {
            boolean result = getResult(nums, num + nums[i], total, i + 1);
            if (result) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = canPartition(new int[]{2, 2, 1, 1});
        System.out.println(b);
    }

}
