package com.gmy.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，
 * 找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSumReview {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target, 0, 0, result, new ArrayList<>());
        return result;
    }

    private void dfs(int[] candidates, int target, int index, int sum, List<List<Integer>> result, List<Integer> res) {
        if (sum == target) {
            result.add(new ArrayList<>(res));
            return;
        }
        if (index == candidates.length) {
            return;
        }
        if (sum < target) {
            res.add(candidates[index]);
            dfs(candidates, target, index, sum + candidates[index], result, res);
            res.remove(res.size() - 1);
        }
        dfs(candidates, target, index + 1, sum, result, res);
    }

    public static void main(String[] args) {
        CombinationSumReview combinationSumReview = new CombinationSumReview();
        List<List<Integer>> result = combinationSumReview.combinationSum(new int[]{2,3,5}, 8);
        System.out.println(result);
    }

}
