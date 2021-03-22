package com.gmy.leetcode.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组 candidates和一个目标整数target ，
 * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
public class CombinationSumReview {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, 0, res, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] candidates, int target, int index, List<List<Integer>> res, List<Integer> result, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(result));
            return;
        }
        if (sum > target) {
            return;
        }
        result.add(candidates[index]);
        dfs(candidates, target, index, res, result, sum + candidates[index]);
        result.remove(result.size() - 1);
        if (index + 1 < candidates.length) {
            dfs(candidates, target, index + 1, res, result, sum);
        }
    }

    public static void main(String[] args) {
        CombinationSumReview combinationSumReview = new CombinationSumReview();
        List<List<Integer>> result = combinationSumReview.combinationSum(new int[]{2,3,5}, 8);
        System.out.println(result);
    }

}
