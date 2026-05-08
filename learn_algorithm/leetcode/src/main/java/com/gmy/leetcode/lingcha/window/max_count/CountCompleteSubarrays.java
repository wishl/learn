package com.gmy.leetcode.lingcha.window.max_count;

import java.util.*;

/**
 * 给你一个由 正 整数组成的数组 nums 。
 * 如果数组中的某个子数组满足下述条件，则称之为 完全子数组 ：
 * 子数组中 不同 元素的数目等于整个数组不同元素的数目。
 * 返回数组中 完全子数组 的数目。
 * 子数组 是数组中的一个连续非空序列。
 */
public class CountCompleteSubarrays {

    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int left = 0, result = 0, diffCount = set.size();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            countMap.merge(nums[right], 1, Integer::sum);
            while (countMap.size() == diffCount) {
                result += nums.length - right;
                Integer merge = countMap.merge(nums[left], -1, Integer::sum);
                if (merge == 0) {
                    countMap.remove(nums[left]);
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountCompleteSubarrays countCompleteSubarrays = new CountCompleteSubarrays();
        int result = countCompleteSubarrays.countCompleteSubarrays(new int[]{1, 3, 1, 2, 2});
        System.out.println(result);
    }

}
