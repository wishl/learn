package com.gmy.leetcode.lingcha.window.max_count;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个正整数数组 nums和一个整数 k，返回 nums 中 「好子数组」 的数目。
 * 如果 nums 的某个子数组中不同整数的个数恰好为 k，则称 nums 的这个连续、不一定不同的子数组为 「好子数组 」。
 * 例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。
 * 子数组 是数组的 连续 部分。
 *
 * https://leetcode.cn/problems/subarrays-with-k-different-integers/description/
 */
public class SubarraysWithKDistinct {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return getGteCount(nums, k) - getGteCount(nums, k + 1);
    }

    private int getGteCount(int[] nums, int k) {
        int left = 0, result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            map.merge(nums[right], 1, Integer::sum);
            while (map.get(k) >= k) {
                result += nums.length - right;
                Integer merge = map.merge(nums[left], -1, Integer::sum);
                if (merge == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
        }
        return result;
    }

}
