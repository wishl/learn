package com.gmy.leetcode.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的
 * 子序列。
 *
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 * 示例 2：
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 *
 * 示例 3：
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *
 * todo review
 */
public class _0300_LengthOfLIS {

    /**
     * 二分法解
     * 搞个list 维护递增窗口 然后每次通过二分法获取到当前数字应该插入的index 如果小于list.size 则set进入index 否则然后直接add
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 应该被插入的位置
            int index = findIndex(nums[i], list) + 1;
            if (index == list.size()) {
                list.add(nums[i]);
            } else {
                list.set(index, nums[i]);
            }
        }
        System.out.println(list);
        return list.size();
    }

    /**
     * 寻找<=num的最大的值所在index
     * @param num
     * @param list
     * @return
     */
    private int findIndex(int num, List<Integer> list) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            // mid > num
            if (list.get(mid) >= num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    /**
     * 动态规划解法
     * @param nums
     * @return
     */
    public int lengthOfLIS1(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(dp[i], result);
        }
        return result;
    }

    public static void main(String[] args) {
        _0300_LengthOfLIS lengthOfLIS = new _0300_LengthOfLIS();
        int result = lengthOfLIS.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7});
        System.out.println(result);
    }

}
