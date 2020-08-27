package com.gmy.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * https://leetcode-cn.com/problems/permutations/
 */
public class Permute {

    // 交换法
    public static void backtrack(int n,
                          ArrayList<Integer> output,
                          List<List<Integer>> res,
                          int first) {
        // 所有数都填完了
        if (first == n)
            res.add(new ArrayList<Integer>(output));
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList();

        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int num : nums)
            output.add(num);

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public static List<List<Integer>> permute1(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
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

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, path, res, used);
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = permute1(new int[]{1,1,2});
        System.out.println(permute);
    }
}
