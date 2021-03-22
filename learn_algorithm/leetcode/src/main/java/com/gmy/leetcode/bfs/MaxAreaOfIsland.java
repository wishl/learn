package com.gmy.leetcode.bfs;

import java.util.Arrays;

/**
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 *
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 *
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxAreaOfIsland {

    /**
     * dfs方式
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int count = 0;
        if (grid == null || grid.length == 0) {
            return count;
        }
        int outLength = grid.length;
        int innerLength = grid[0].length;
        boolean[] visited = new boolean[outLength * innerLength];
        Arrays.fill(visited, false);
        for (int i = 0; i < outLength; i++) {
            for (int j = 0; j < innerLength; j++) {
                if (grid[i][j] == 1 && !visited[(outLength - 1) * i + j]) {
                    System.out.println(i + "," + j);
                    count = Math.max(count, dfs(grid, i, j, outLength, innerLength, 0, visited));
                }
            }
        }
        return count;
    }

    private int dfs(int[][] grid, int x, int y, int outLength, int innerLength, int count, boolean[] visited) {
        if (x < 0 || y < 0 || x == outLength || y == innerLength || grid[x][y] != 1 || visited[(innerLength) * x + y]) {
            return count;
        }
        count++;
        visited[(innerLength) * x + y] = true;
        count = dfs(grid, x - 1, y, outLength, innerLength, count, visited);
        count = dfs(grid, x + 1, y, outLength, innerLength, count, visited);
        count = dfs(grid, x, y + 1, outLength, innerLength, count, visited);
        count = dfs(grid, x, y - 1, outLength, innerLength, count, visited);
        return count;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        int i = maxAreaOfIsland.maxAreaOfIsland(new int[][]{{1}, {1}});
        System.out.println(i);
    }

}
