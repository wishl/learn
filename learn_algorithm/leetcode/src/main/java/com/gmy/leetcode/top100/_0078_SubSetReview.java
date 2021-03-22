package com.gmy.leetcode.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * https://leetcode.cn/problems/subsets/description/
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 子集型递归
 */
public class _0078_SubSetReview {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, 0, new ArrayList<>(), true, nums);
        return result;
    }

    private void dfs(List<List<Integer>> result, int index, List<Integer> path, boolean needAdd, int[] nums) {
        if (needAdd) {
            result.add(new ArrayList<>(path));
        }
        if (index == nums.length) {
            return;
        }
        path.add(nums[index]);
        dfs(result, index + 1, path, true, nums);
        path.remove(path.size() - 1);
        dfs(result, index + 1, path, false, nums);
    }

}
