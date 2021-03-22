package com.gmy.leetcode.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class _0046_Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), nums, new int[nums.length]);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> inner, int[] nums, int[] visited) {
        if (inner.size() == nums.length) {
            result.add(new ArrayList<>(inner));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 0) {
                inner.add(nums[i]);
                visited[i] = 1;
                dfs(result, inner, nums, visited);
                visited[i] = 0;
                inner.remove(inner.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        _0046_Permute permute = new _0046_Permute();
        List<List<Integer>> result = permute.permute(new int[]{1, 2, 3});
        System.out.println(result);
    }

}
