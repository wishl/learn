package com.gmy.leetcode.dp.memery.simple;

import java.util.Arrays;

/**
 * 一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响小偷偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组 nums ，请计算 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * https://leetcode.cn/problems/Gu0c2T/description/
 */
public class Rob {

    /**
     * 递推法的空间复杂度优化 优化后空间复杂度o(1)
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        int n = nums.length;
        int v1 = 0, v2 = 0, value = 0;
        for (int i = 0; i < nums.length; i++) {
            value = Math.max(v1, v2 + nums[i]);
            v2 = v1;
            v1 = value;
        }
        return v1;
    }

    /**
     * 递推法 时间复杂度 o(n)
     * @param nums
     * @return
     */
    private int rob1(int[] nums) {
        int n = nums.length;
        int[] cache = new int[n + 2];
        for (int i = 0; i < nums.length; i++) {
            cache[i + 2] = Math.max(cache[i + 1], cache[i] + nums[i]);
        }
        return cache[n + 1];
    }

    /**
     * 记忆化dfs
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return dfs(nums, nums.length - 1, cache);
    }

    private int dfs(int[] nums, int index, int[] cache) {
        if (index < 0) {
            return 0;
        }
        if (cache[index] != -1) {
            return cache[index];
        }
        int max = Math.max(dfs(nums, index - 1, cache), dfs(nums, index - 2, cache) + nums[index]);
        cache[index] = max;
        return max;
    }

    public static void main(String[] args) {
        Rob rob = new Rob();
        int result = rob.rob(new int[]{2, 1});
        int result1 = rob.rob1(new int[]{2, 1});
        System.out.println(result);
        System.out.println(result1);
    }

}
