package com.gmy.leetcode.lingcha.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Guanmengyuan
 * @Date Created in 17:13 2026/5/18
 */
public class PermuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int[] viewed = new int[nums.length];
        dfs(nums, new ArrayList<>(), res, viewed);
        return res;
    }

    private void dfs(int[] nums, List<Integer> innerRes, List<List<Integer>> result, int[] viewed) {
        if (innerRes.size() == nums.length) {
            result.add(new ArrayList<>(innerRes));
        }
        for (int i = 0; i < nums.length; i++) {
            // 如果相同的元素 前面那个没有访问 则这个也不访问 保证唯一
            if (i > 0 && nums[i] == nums[i - 1] && viewed[i - 1] == 0) {
                continue;
            }
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
