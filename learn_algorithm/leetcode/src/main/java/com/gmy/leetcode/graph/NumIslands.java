package com.gmy.leetcode.graph;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * https://leetcode.cn/problems/number-of-islands/description/
 */
public class NumIslands {

    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            char[] row = grid[i];
            for (int j = 0; j < row.length; j++) {
                if (grid[i][j] == '1') {
                    infect(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private void infect(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m) {
            return;
        }
        if (j < 0 || j >= n) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '.';
            infect(grid, i + 1, j);
            infect(grid, i, j + 1);
            infect(grid, i - 1, j);
            infect(grid, i, j - 1);
        }
    }

    public static void main(String[] args) {
        NumIslands numIslands = new NumIslands();
        int result = numIslands.numIslands(new char[][]{{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}});
        System.out.println(result);
    }

}
