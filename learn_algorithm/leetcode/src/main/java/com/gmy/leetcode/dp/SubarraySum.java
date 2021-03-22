package com.gmy.leetcode.dp;

import java.util.HashMap;

/**
 * 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
 *
 * https://leetcode.cn/problems/QTMn0o/description/
 */
public class SubarraySum {

    public int subarraySum(int[] nums, int k) {
        int pre_sum = 0;
        int ret = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i : nums) {
            pre_sum += i;
            ret += map.getOrDefault(pre_sum - k, 0);
            map.put(pre_sum, map.getOrDefault(pre_sum, 0) + 1);
        }
        return ret;
    }

    public static void main(String[] args) {
        SubarraySum subarraySum = new SubarraySum();
        int result = subarraySum.subarraySum(new int[]{1, 2, 3, 2, 3}, 5);
        System.out.println(result);
    }

}
