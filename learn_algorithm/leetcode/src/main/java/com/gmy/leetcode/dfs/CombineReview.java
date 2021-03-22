package com.gmy.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 * https://leetcode.cn/problems/combinations/
 */
public class CombineReview {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs1(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int n, int k, int i, List<Integer> res, List<List<Integer>> result) {
        if (res.size() == k) {
            result.add(new ArrayList<>(res));
            return;
        }
        if (i > n) {
            return;
        }
        res.add(i);
        dfs(n, k, i + 1, res, result);
        res.remove(res.size() - 1);
        if (i + 1 <= n) {
            dfs(n, k, i + 1, res, result);
        }
    }

    private void dfs1(int n, int k, int i, List<Integer> res, List<List<Integer>> result) {
        if (res.size() == k) {
            result.add(new ArrayList<>(res));
            return;
        }
        for (int j = i; j <= n; j++) {
            res.add(j);
            dfs(n, k, j + 1, res, result);
            res.remove(res.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombineReview combineReview = new CombineReview();
        List<List<Integer>> combine = combineReview.combine(4, 3);
        System.out.println(combine);
    }

}
