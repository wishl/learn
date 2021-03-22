package com.gmy.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 */
public class Subset {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        List<Integer> inner = new ArrayList<>();
        dfs(nums, 0, res, inner);
        return res;
    }

    private static void dfs(int[] num, int start, List<List<Integer>> res, List<Integer> inner) {
        for (int i = start; i < num.length; i++) {
            inner.add(num[i]);
            res.add(new ArrayList<>(inner));
            dfs(num, i + 1, res, inner);
            inner.remove(inner.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> subsets = subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }

}
