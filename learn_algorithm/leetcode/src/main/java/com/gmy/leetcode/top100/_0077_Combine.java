package com.gmy.leetcode.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class _0077_Combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), 1, k, n);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> path, int n, int k, int max) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (max - n + 1 < k - path.size()) {
            return;
        }
        for (int i = n; i <= max; i++) {
            path.add(i);
            dfs(result, path, i + 1, k, max);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        _0077_Combine combine = new _0077_Combine();
        List<List<Integer>> result = combine.combine(4, 2);
        System.out.println(result);
    }

}
