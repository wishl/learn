package com.gmy.leetcode.week.contest._452;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * 给你一个 m x n 的整数矩阵 grid 和一个整数 k。
 * 对于矩阵 grid 中的每个连续的 k x k 子矩阵，计算其中任意两个 不同值 之间的 最小绝对差 。
 * 返回一个大小为 (m - k + 1) x (n - k + 1) 的二维数组 ans，其中 ans[i][j] 表示以 grid 中坐标 (i, j) 为左上角的子矩阵的最小绝对差。
 * 注意：如果子矩阵中的所有元素都相同，则答案为 0。
 * 子矩阵 (x1, y1, x2, y2) 是一个由选择矩阵中所有满足 x1 <= x <= x2 且 y1 <= y <= y2 的单元格 matrix[x][y] 组成的矩阵。
 */
public class MinAbsDiff {

    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m - k + 1][n - k + 1];
        int[] a = new int[k * k];
        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                int idx = 0;
                for (int x = 0; x < k; x++) {
                    for (int y = 0; y < k; y++) {
                        a[idx++] = grid[i + x][j + y];
                    }
                }
                Arrays.sort(a);

                int res = Integer.MAX_VALUE;
                for (int p = 1; p < a.length; p++) {
                    if (a[p] > a[p - 1]) {
                        res = Math.min(res, a[p] - a[p - 1]);
                    }
                }
                if (res < Integer.MAX_VALUE) {
                    ans[i][j] = res;
                }
            }
        }
        return ans;
    }
}
