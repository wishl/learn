package com.gmy.leetcode.graph;

import com.sun.org.apache.xpath.internal.operations.Or;

/**
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 *
 * https://leetcode.cn/problems/rotting-oranges/description/
 */
public class OrangesRotting {

    public int orangesRotting(int[][] grid) {
        int freshCount = 0, result = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            for (int j = 0; j < row.length; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        int lastCount = -1;
        while (freshCount > 0) {
            if (freshCount == lastCount) {
                return  -1;
            }
            result++;
            for (int i = 0; i < grid.length; i++) {
                int[] row = grid[i];
                for (int j = 0; j < row.length; j++) {
                    if (grid[i][j] == 2) {
                        infect(grid, i, j);
                    }
                }
            }
            lastCount = freshCount;
            freshCount -= refresh(grid);
        }
        return result;
    }

    private int refresh(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            for (int j = 0; j < row.length; j++) {
                if (grid[i][j] == -2) {
                    grid[i][j] = 2;
                    count++;
                }
            }
        }
        return count;
    }

    private void infect(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m) {
            return;
        }
        if (j < 0 || j >= n) {
            return;
        }
        if (grid[i][j] == 2) {
            mark(grid, i + 1, j);
            mark(grid, i - 1, j);
            mark(grid, i, j + 1);
            mark(grid, i, j - 1);
        }
        if (grid[i][j] == 1) {
            grid[i][j] = -2;
        }
    }

    private void mark(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m) {
            return;
        }
        if (j < 0 || j >= n) {
            return;
        }
        if (grid[i][j] == 1) {
            grid[i][j] = -2;
        }
    }

    public static void main(String[] args) {
        OrangesRotting orangesRotting = new OrangesRotting();
        int result = orangesRotting.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}});
        System.out.println(result);
    }
}
