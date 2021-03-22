package com.gmy.leetcode.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
 *
 * https://leetcode.cn/problems/combination-sum-ii/
 */
public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, 0, 0, res, new ArrayList<>());
        return res;
    }

    private void dfs(int[] candidates, int target, int index, int sum, List<List<Integer>> res, List<Integer> result) {
        if (sum == target) {
            res.add(new ArrayList<>(result));
            return;
        }
        if (index >= candidates.length || sum > target) {
            return;
        }
        result.add(candidates[index]);
        dfs(candidates, target, index + 1, sum + candidates[index], res, result);
        result.remove(result.size() - 1);
        while (index + 1 < candidates.length && candidates[index + 1] == candidates[index]) {
            index++;
        }
        dfs(candidates, target, index + 1, sum, res, result);
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        List<List<Integer>> result = combinationSum2.combinationSum2(new int[]{1,1,1,1}, 2);
        System.out.println(result);
    }


}
