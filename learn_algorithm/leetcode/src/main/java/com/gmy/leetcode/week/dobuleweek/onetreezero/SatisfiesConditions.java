package com.gmy.leetcode.week.dobuleweek.onetreezero;

/**
 * 给你一个大小为 m x n 的二维矩阵 grid 。你需要判断每一个格子 grid[i][j] 是否满足：
 * 如果它下面的格子存在，那么它需要等于它下面的格子，也就是 grid[i][j] == grid[i + 1][j] 。
 * 如果它右边的格子存在，那么它需要不等于它右边的格子，也就是 grid[i][j] != grid[i][j + 1] 。
 * 如果 所有 格子都满足以上条件，那么返回 true ，否则返回 false 。
 *
 *
 */
public class SatisfiesConditions {

    public boolean satisfiesConditions(int[][] grid) {
        int[] cache = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            if (i < grid[0].length - 1 && grid[0][i] == grid[0][i + 1]) {
               return false;
            }
            cache[i] = grid[0][i];
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] != cache[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] ints = new int[][] {{1,0,2},{1,0,2}};
        SatisfiesConditions satisfiesConditions = new SatisfiesConditions();
        boolean result = satisfiesConditions.satisfiesConditions(ints);
        System.out.println(result);
    }

}
