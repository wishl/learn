package com.gmy.leetcode.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * https://leetcode-cn.com/problems/subsets/
 */
public class Subsets {

    private List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, new ArrayDeque<>(), 0, used, true);
        return result;
    }

    private void dfs(int[] nums, Deque<Integer> result, int index, boolean[] used, boolean add) {
        if (add) {
            this.result.add(new ArrayList<>(result));
        }
        if (index < nums.length && !used[index]) {
            // 选择当前
            result.addLast(nums[index]);
            dfs(nums, result, index + 1, used, true);
            result.removeLast();
        }
        if (index < nums.length - 1 && !used[index + 1]) {
            // 选择下一个
            dfs(nums, result, index + 1, used, false);
        }
    }

    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets1(int[] nums) {
        dfs1(0, nums);
        return ans;
    }

    public void dfs1(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs1(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs1(cur + 1, nums);
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] is = new int[] {1,2,3};
        List<List<Integer>> subsets1 = subsets.subsets1(is);
        System.out.println(subsets1);
    }
}
