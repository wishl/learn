package com.gmy.leetcode.reback;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.DelayQueue;

/**
 * https://leetcode-cn.com/problems/combinations/
 */
public class Combine {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>(k);
        dfs(1, n, k, res, path);
        return res;
    }

    private static void dfs(int start, int n, int k, List<List<Integer>> res, Deque<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            path.addLast(i);
            dfs(i + 1, n, k, res, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
        System.out.println(combine);
    }

}
