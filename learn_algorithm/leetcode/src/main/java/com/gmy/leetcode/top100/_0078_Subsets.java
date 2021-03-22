package com.gmy.leetcode.top100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * https://leetcode.cn/problems/subsets/description/
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * todo review
 *
 */
public class _0078_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, deque, res, true);
        return res;
    }

    private void dfs(int[] nums, int index, Deque<Integer> path, List<List<Integer>> res, boolean add) {
        if (add) {
            res.add(new ArrayList<>(path));
        }
        if (index >= nums.length) {
            return;
        }
        path.add(nums[index]);
        dfs(nums, index + 1, path, res, true);
        path.removeLast();
        dfs(nums, index + 1, path, res, false);
    }


    public static void main(String[] args) {
        _0078_Subsets subsets = new _0078_Subsets();
        List<List<Integer>> result = subsets.subsets(new int[]{1, 2, 3});
        System.out.println(result);
    }
}
