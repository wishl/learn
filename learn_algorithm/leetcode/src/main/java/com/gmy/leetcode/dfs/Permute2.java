package com.gmy.leetcode.dfs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 地址：https://leetcode-cn.com/problems/permutations-ii/
 */
public class Permute2 {

    private List<List<Integer>> result;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(nums, new ArrayList<>(), used);
        return result;
    }

    private void dfs(int[] nums, List<Integer> result, boolean[] used) {
        if (result.size() == nums.length) {
            this.result.add(new ArrayList<>(result));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 如果有相等 只保留前面的（不允许前面没有别选择时就选择后面）
            if (used[i] || i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            result.add(nums[i]);
            dfs(nums, result, used);
            used[i] = false;
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permute2 permute = new Permute2();
        int[] is = new int[] {1, 1, 2};
        List<List<Integer>> result = permute.permuteUnique(is);
        System.out.println(result);
    }
//[[1, 2, 2], [2, 2, 1]]
//[[1, 2, 2], [1, 2, 2], [2, 1, 2], [2, 2, 1]]
}
