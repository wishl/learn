package com.gmy.leetcode.lingcha.window.change;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
 * 返回 只删除一个 子数组可获得的 最大得分 。
 * 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
 */
public class MaximumUniqueSubarray {

    public int maximumUniqueSubarray(int[] nums) {
        int left = 0, result = 0, sum = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            countMap.merge(nums[right], 1, Integer::sum);
            while (countMap.size() < (right - left + 1) ) {
                countMap.put(nums[left], countMap.get(nums[left]) - 1);
                sum -= nums[left];
                if (countMap.get(nums[left]) == 0) {
                    countMap.remove(nums[left]);
                }
                left++;
            }
            result = Math.max(result, sum);
        }
        return result;
    }

}
