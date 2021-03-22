package com.gmy.leetcode.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * https://leetcode-cn.com/problems/permutations/
 */
public class Permute {

    private List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        this.result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, used, new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, boolean[] used, List<Integer> result) {
        if (result.size() == nums.length) {
            this.result.add(new ArrayList<>(result));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            result.add(nums[i]);
            used[i] = true;
            dfs(nums, used, result);
            result.remove(result.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        int[] is = new int[] {0,1,2};
        List<List<Integer>> result = permute.permute(is);
        System.out.println(result);
    }

}
