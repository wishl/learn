package com.gmy.leetcode.review;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 *
 * 子数组 是数组的一段连续部分。
 */
public class NumSubArraysWithSum {

    /**
     * 前缀和方法计算
     * 从左向右计算前缀和 满足条件的子数组[i, j]的前缀和的差一定是 goal
     * 所以通过map存储前缀和 并计数
     * @param nums
     * @param goal
     * @return
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int sum = 0, result = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);
            // 这里得是前缀和 不能包含自己 否则 sum = 2 nums = [1, 1, 1, 1] 这种情况 i = 0， j = 1 就计算不出来了 会少
            sum += num;
            result += countMap.getOrDefault(sum - goal, 0);
        }
        return result;
    }

    /**
     * 因为nums中只有 0 或 1 可以使用滑动窗口计算
     *
     * @param nums
     * @param goal
     * @return
     */
    public int numSubarraysWithSum2(int[] nums, int goal) {
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
     * 分治
     * @param nums
     * @param goal
     * @return
     */
    public int numSubarraysWithSum1(int[] nums, int goal) {
        int[][] cache = new int[nums.length][nums.length];
        int result = dfs(0, 0, 0, nums[0], goal, nums, cache);
        return result;
    }

    private int dfs(int count, int start, int end, int sum, int goal, int[] nums, int[][] cache) {
        if (sum == goal) {
            count++;
        }
        if (end + 1 < nums.length && start <= end && cache[start][end + 1] == 0) {
            cache[start][end + 1] = 1;
            count = dfs(count, start, end + 1, sum + nums[end + 1], goal, nums, cache);
        }
        if (end < nums.length && start + 1 <= end && cache[start + 1][end] == 0) {
            cache[start + 1][end] = 1;
            count = dfs(count, start + 1, end, sum - nums[start], goal, nums, cache);
        }
        return count;
    }

    public static void main(String[] args) {
        NumSubArraysWithSum numSubArraysWithSum = new NumSubArraysWithSum();
        int result = numSubArraysWithSum.numSubarraysWithSum(new int[]{0, 1, 0, 1, 1, 1}, 2);
        System.out.println(result);
    }
}
