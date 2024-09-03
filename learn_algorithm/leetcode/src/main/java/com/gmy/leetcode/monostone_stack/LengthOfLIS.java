package com.gmy.leetcode.monostone_stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的
 * 子序列。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 *
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 */
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = 1;
        int max = prefix[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    prefix[i] = Math.max(prefix[j], prefix[i]);
                }
            }
            max = Math.max(max, ++prefix[i]);
        }
        return max;
    }


    public int lengthOfLIS1(int[] nums) {
        List<Integer> g = new ArrayList<>();
        for (int x : nums) {
            int j = lowerBound(g, x);
            if (j == g.size()) {
                g.add(x); // >=x 的 g[j] 不存在
            } else {
                g.set(j, x);
            }
        }
        return g.size();
    }

    // 开区间写法
    private int lowerBound(List<Integer> g, int target) {
        int left = -1, right = g.size(); // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            // 循环不变量：
            // nums[left] < target
            // nums[right] >= target
            int mid = left + (right - left) / 2;
            if (g.get(mid) < target) {
                left = mid; // 范围缩小到 (mid, right)
            } else {
                right = mid; // 范围缩小到 (left, mid)
            }
        }
        return right; // 或者 left+1
    }

    public static void main(String[] args) {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        int result = lengthOfLIS.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        int result1 = lengthOfLIS.lengthOfLIS1(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        System.out.println(result);
        System.out.println(result1);
    }

}
