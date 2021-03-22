package com.gmy.leetcode.dp.memery.grid;

import java.util.Arrays;

/**
 * 给你一个非负整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 * https://leetcode.cn/problems/target-sum/description/
 */
public class FindTargetSumWays {

    /**
     *  设  t = target s = sum(nums) p = 正数和 负数和 = s - t
     *      p - (s - p) = t
     *      2p - s = t
     *      p = (t + s) / 2
     *  所以问题转化为 寻找 一些数字的和为 (t - s) / 2
     */
    //
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        target += sum;
        if (target < 0 || target % 2 == 1) {
            return 0;
        }
        int[][] cache = new int[nums.length][target + 1];
        for (int i = 0; i < nums.length; i++)
            Arrays.fill(cache[i], -1); // -1 表示没用访问过
        int result = dfs(nums, target / 2, nums.length - 1, cache);
        return result;
    }

    private int dfs(int[] nums, int t, int index, int[][] cache) {
        if (index < 0) {
            // 如果t == 0 说明找到了满足 (t + s) / 2 的数
            return t == 0 ? 1 : 0;
        }
        if (cache[index][t] != -1) {
            return cache[index][t];
        }
        int result = dfs(nums, t, index - 1, cache) + dfs(nums, t - nums[index], index - 1, cache);
        cache[index][t] = result;
        return result;
    }

    /**
     * 递推法
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays1(int[] nums, int target) {
        for (int x : nums) target += x;
        if (target < 0 || target % 2 == 1) return 0;
        target /= 2;

        int n = nums.length;
        int[][] f = new int[n + 1][target + 1];
        f[0][0] = 1;
        for (int i = 0; i < n; ++i)
            for (int c = 0; c <= target; ++c)
                if (c < nums[i]) f[i + 1][c] = f[i][c];
                else f[i + 1][c] = f[i][c] + f[i][c - nums[i]];
        return f[n][target];
    }

    public static void main(String[] args) {
        FindTargetSumWays findTargetSumWays = new FindTargetSumWays();
        int result = findTargetSumWays.findTargetSumWays(new int[]{1,1,1,1,1}, 3);
        System.out.println(result);
    }

}
