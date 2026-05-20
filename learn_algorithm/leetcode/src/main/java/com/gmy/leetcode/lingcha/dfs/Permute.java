package com.gmy.leetcode.lingcha.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。
 *
 * https://leetcode.cn/problems/VvJkup/description/
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] viewed = new int[nums.length];
        dfs(nums, new ArrayList<>(), result, viewed);
        return result;
    }

    private void dfs(int[] nums, List<Integer> innerRes, List<List<Integer>> result, int[] viewed) {
        if (innerRes.size() == nums.length) {
            result.add(new ArrayList<>(innerRes));
        }
        for (int i = 0; i < nums.length; i++) {
            if (viewed[i] == 0) {
                innerRes.add(nums[i]);
                viewed[i] = 1;
                dfs(nums, innerRes, result, viewed);
                innerRes.remove(innerRes.size() - 1);
                viewed[i] = 0;
            }
        }
    }
}
