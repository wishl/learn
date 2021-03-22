package com.gmy.leetcode.week.dobuleweek.onetwonine;

/**
 * 给你一个二维 3 x 3 的矩阵 grid ，每个格子都是一个字符，要么是 'B' ，要么是 'W' 。字符 'W' 表示白色，字符 'B' 表示黑色。
 * 你的任务是改变 至多一个 格子的颜色，使得矩阵中存在一个 2 x 2 颜色完全相同的正方形。
 * 如果可以得到一个相同颜色的 2 x 2 正方形，那么返回 true ，否则返回 false 。
 *
 * 输入：grid = [["B","W","B"],
 *              ["B","W","W"],
 *              ["B","W","B"]]
 * 输出：true
 * 解释：
 * 修改 grid[0][2] 的颜色，可以满足要求。
 * https://leetcode.cn/problems/make-a-square-with-the-same-color/description/
 */
public class CanMakeSquare {

    public boolean canMakeSquare(char[][] grid) {
        return check(grid, 0, 0) || check(grid, 0, 1) || check(grid, 1, 0) || check(grid, 1, 1);
    }

    private boolean check(char[][] grid, int i, int j) {
        int[] cnt = new int[2];
        cnt[grid[i][j] & 1]++;
        cnt[grid[i][j + 1] & 1]++;
        cnt[grid[i + 1][j] & 1]++;
        cnt[grid[i + 1][j + 1] & 1]++;
        return cnt[0] >= 3 || cnt[1] >= 3;
    }
}
