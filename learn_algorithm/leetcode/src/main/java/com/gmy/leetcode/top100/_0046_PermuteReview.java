package com.gmy.leetcode.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class _0046_PermuteReview {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), nums, new int[nums.length]);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> path, int[] nums, int[] cache) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (cache[i] == 0) {
                cache[i] = 1;
                path.add(nums[i]);
                dfs(result, path, nums, cache);
                path.remove(path.size() - 1);
                cache[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        _0046_PermuteReview permuteReview = new _0046_PermuteReview();
        List<List<Integer>> result = permuteReview.permute(new int[]{1, 2, 3});
        System.out.println(result);
    }

}
