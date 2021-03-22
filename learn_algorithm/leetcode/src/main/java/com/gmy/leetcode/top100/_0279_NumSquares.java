package com.gmy.leetcode.top100;

import java.util.Arrays;

/**
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * 示例 1：
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 *
 * 示例 2：
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 *
 * todo review
 */
public class _0279_NumSquares {

    private static final int[][] memo = new int[101][10001];

    static {
        for (int[] row : memo) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }
    }

    private static int dfs(int i, int j) {
        if (i == 0) {
            return j == 0 ? 0 : Integer.MAX_VALUE;
        }
        if (memo[i][j] != -1) { // 之前计算过
            return memo[i][j];
        }
        if (j < i * i) {
            return memo[i][j] = dfs(i - 1, j); // 只能不选
        }
        return memo[i][j] = Math.min(dfs(i - 1, j), dfs(i, j - i * i) + 1); // 不选 vs 选
    }

    public int numSquares(int n) {
        return dfs((int) Math.sqrt(n), n);
    }

}
