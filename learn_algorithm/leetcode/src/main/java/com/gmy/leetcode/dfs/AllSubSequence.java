package com.gmy.leetcode.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 全排列
 * https://leetcode-cn.com/problems/permutations/
 */
public class AllSubSequence {

    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // 使用 Deque 是 Java 官方 Stack 类的建议
        Deque<Integer> path = new ArrayDeque<>(len);
        boolean[] used = new boolean[nums.length];
        dfs(nums, len, 0, path, res, used);
        return res;
    }

    private static void dfs(int[] nums, int len, int depth, Deque<Integer> path, List<List<Integer>> res, boolean used[]) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; ++i) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, path, res, used);
            // 回溯部分的代码，和 dfs 之前的代码是对称的
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        permute(new int[] {1, 2, 3});
    }

}
