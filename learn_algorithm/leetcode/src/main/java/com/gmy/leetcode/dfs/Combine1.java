package com.gmy.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * https://leetcode-cn.com/problems/combinations/
 */
public class Combine1 {

    private List<List<Integer>> result;

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        dfs(n, k, new ArrayList<>(), 1);
        return result;
    }

    public void dfs(int n, int k, List<Integer> result, int index) {
        if (result.size() == k) {
            this.result.add(new ArrayList<>(result));
            return;
        }
        for (int i = index; i <= n; i++) {
            result.add(i);
            dfs(n, k, result, i + 1);
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combine1 combine1 = new Combine1();
        List<List<Integer>> combine = combine1.combine(1, 1);
        System.out.println(combine);
    }

}
