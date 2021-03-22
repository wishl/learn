package com.gmy.leetcode.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 *
 * 子数组 是数组的一段连续部分。
 * https://leetcode.cn/problems/binary-subarrays-with-sum/
 */
public class NumSubarraysWithSum {

    public int numSubarraysWithSum1(int[] nums, int goal) {
        int count = 0, result = nums[0], left = 0, right = 1;
        while (right <= nums.length) {
            if (result == goal) {
                count++;
            }
            if (result > goal || right == nums.length) {
                left++;
                right = left;
                result = 0;
            }
            if (right < nums.length) {
                result += nums[right];
            }
            right++;
        }
        return count;
    }

    /**
     * 滑动窗口
     * @param nums
     * @param goal
     * @return
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int left1 = 0, left2 = 0, right = 0;
        int sum1 = 0, sum2 = 0;
        int ret = 0;
        while (right < n) {
            sum1 += nums[right];
            while (left1 <= right && sum1 > goal) {
                sum1 -= nums[left1];
                left1++;
            }
            sum2 += nums[right];
            while (left2 <= right && sum2 >= goal) {
                sum2 -= nums[left2];
                left2++;
            }
            ret += left2 - left1;
            right++;
        }
        return ret;
    }

    /**
     * hash表
     * @param nums
     * @param goal
     * @return
     */
    public int numSubarraysWithSum2(int[] nums, int goal) {
        int sum = 0;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        int ret = 0;
        for (int num : nums) {
            cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            sum += num;
            ret += cnt.getOrDefault(sum - goal, 0);
        }
        return ret;
    }


    public static void main(String[] args) {
        NumSubarraysWithSum numSubarraysWithSum = new NumSubarraysWithSum();
        // 0,0,0,0
        int count = numSubarraysWithSum.numSubarraysWithSum2(new int[]{0,0,0,0}, 0);
        System.out.println(count);
    }
}
