package com.gmy.leetcode.week.dobuleweek.onetwonine;

import java.util.Arrays;

/**
 * 给你一个二维 boolean 矩阵 grid 。
 * 请你返回使用 grid 中的 3 个元素可以构建的 直角三角形 数目，且满足 3 个元素值 都 为 1 。
 * 注意：
 * 如果 grid 中 3 个元素满足：一个元素与另一个元素在 同一行，同时与第三个元素在 同一列 ，
 * 那么这 3 个元素称为一个 直角三角形 。这 3 个元素互相之间不需要相邻。
 *
 * 输入：grid = [[0,1,0],
 *              [0,1,1],
 *              [0,1,0]]
 *
 * 输出：2
 *
 * 解释：
 *
 * 有 2 个直角三角形。
 */
public class NumberOfRightTriangles {

    public long numberOfRightTriangles(int[][] grid) {
        int n = grid[0].length;
        int[] colSum = new int[n];
        Arrays.fill(colSum, -1); // 提前减一
        for (int j = 0; j < n; j++) {
            for (int[] row : grid) {
                colSum[j] += row[j];
            }
        }

        long ans = 0;
        for (int[] row : grid) {
            int rowSum = -1; // 提前减一
            for (int x : row) {
                rowSum += x;
            }
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 1) {
                    ans += rowSum * colSum[j];
                }
            }
        }
        return ans;
    }

}
