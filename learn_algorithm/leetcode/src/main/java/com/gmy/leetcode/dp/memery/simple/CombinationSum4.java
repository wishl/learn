package com.gmy.leetcode.dp.memery.simple;

import org.checkerframework.checker.units.qual.C;

import java.util.Arrays;
import java.util.EnumMap;

/**
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * 题目数据保证答案符合 32 位整数范围。
 *
 * https://leetcode.cn/problems/combination-sum-iv/description/
 */
public class CombinationSum4 {

    public int combinationSum4(int[] nums, int target) {
        int[] cache = new int[target + 1];
        Arrays.fill(cache, -1);
        int result = dfs(target, nums, cache);
        return result;
    }

    private int dfs(int i, int[] nums, int[] memo) {
        if (i == 0) { // 爬完了
            return 1;
        }
        if (memo[i] != -1) { // 之前计算过
            return memo[i];
        }
        int res = 0;
        for (int x : nums) { // 枚举所有可以爬的台阶数
            if (x <= i) {
                res += dfs(i - x, nums, memo);
            }
        }
        return memo[i] = res; // 记忆化
    }

    public static void main(String[] args) {
        CombinationSum4 combinationSum4 = new CombinationSum4();
        int result = combinationSum4.combinationSum4(new int[]{2}, 5);
        System.out.println(result);
    }

}
