package com.gmy.leetcode.top100;

import java.util.Arrays;

/**
 * 给你一个非负整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 * todo review
 */
public class _0494_FindTargetSumWays {

    /**
     * 动态规划解
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        int s = 0;
        for (int x : nums) {
            s += x;
        }
        s -= Math.abs(target);
        if (s < 0 || s % 2 == 1) {
            return 0;
        }
        int m = s / 2; // 背包容量
        int n = nums.length;
        int[][] f = new int[n + 1][m + 1];
        f[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int c = 0; c <= m; c++) {
                if (c < nums[i]) {
                    f[i + 1][c] = f[i][c]; // 只能不选
                } else {
                    f[i + 1][c] = f[i][c] + f[i][c - nums[i]]; // 不选 + 选
                }
            }
        }
        return f[n][m];
    }


    /**
     * 问题转化为 从nums中选择一些值 使和 == target
     * 设 p 为选中的数字 s 为nums的和 可以转化为 0 1 背包问题
     * 未被选择的数字 = s - p
     * target = p - (s - p)
     * target = 2p - s
     * 2p = target + s
     * p = (target + s) / 2
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays1(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        target += sum;
        if (target < 0 || target % 2 == 1) {
            return 0;
        }
        Integer[][] cache = new Integer[target][nums.length];
        return dfs(nums, target / 2, nums.length - 1, cache);
    }

    /**
     * dfs 写法
     * @param nums
     * @param target
     * @param index
     * @return
     */
    private int dfs(int[] nums, int target, int index) {
        if (index < 0) {
            return target == 0 ? 1 : 0;
        }
        if (target < nums[index]) {
            return dfs(nums, target, index - 1);
        }
        return dfs(nums, target, index - 1) + dfs(nums, target - nums[index], index - 1);
    }

    /**
     * 记忆化搜索
     * @param nums
     * @param target
     * @param index
     * @param cache
     * @return
     */
    private int dfs(int[] nums, int target, int index, Integer[][] cache) {
        if (index < 0) {
            return target == 0 ? 1 : 0;
        }
        if (target < nums[index]) {
            return dfs(nums, target, index - 1, cache);
        }
        if (cache[target][index] != null) {
            return cache[target][index];
        }
        int result = dfs(nums, target, index - 1, cache) + dfs(nums, target - nums[index],
            index - 1, cache);
        cache[target][index] = result;
        return result;
    }

    public static void main(String[] args) {
        _0494_FindTargetSumWays findTargetSumWays = new _0494_FindTargetSumWays();
        int result = findTargetSumWays.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(result);
    }

}
