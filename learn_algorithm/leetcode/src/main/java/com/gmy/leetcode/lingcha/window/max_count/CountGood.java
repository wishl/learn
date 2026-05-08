package com.gmy.leetcode.lingcha.window.max_count;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回 nums 中 好 子数组的数目。
 * 一个子数组 arr 如果有 至少 k 对下标 (i, j) 满足 i < j 且 arr[i] == arr[j] ，那么称它是一个 好 子数组。
 * 子数组 是原数组中一段连续 非空 的元素序列。
 *
 * https://leetcode.cn/problems/count-the-number-of-good-subarrays/
 */
public class CountGood {

    public long countGood(int[] nums, int k) {
        int left = 0, sameCount = 0;
        long result = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            Integer putResult = countMap.merge(nums[right], 1, Integer::sum);
            sameCount += putResult - 1;
            while (sameCount >= k) {
                result += nums.length - right;
                Integer subResult = countMap.merge(nums[left], -1, Integer::sum);
                sameCount -= subResult;
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountGood countGood = new CountGood();
        long resu = countGood.countGood(new int[]{3,1,4,3,2,2,4}, 2);
        System.out.println(resu);
    }

}
