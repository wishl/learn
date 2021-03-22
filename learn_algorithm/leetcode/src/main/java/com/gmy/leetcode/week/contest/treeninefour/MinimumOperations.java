package com.gmy.leetcode.week.contest.treeninefour;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个大小为 m x n 的二维矩形 grid 。
 * 每次 操作 中，你可以将 任一 格子的值修改为 任意 非负整数。完成所有操作后，你需要确保每个格子 grid[i][j] 的值满足：
 *
 * 如果下面相邻格子存在的话，它们的值相等，也就是 grid[i][j] == grid[i + 1][j]（如果存在）。
 * 如果右边相邻格子存在的话，它们的值不相等，也就是 grid[i][j] != grid[i][j + 1]（如果存在）。
 * 请你返回需要的 最少 操作数目。
 */
public class MinimumOperations {

    public int minimumOperations(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[][] cache = new int[grid.length][9];
        // 枚举出所有改变次数
        for (int i = 0; i < grid[0].length; i++) {
            Map<Integer, Integer> countMap = new HashMap<>();
            // 本列有多少个数
            for (int j = 0; j < grid.length; j++) {
                countMap.merge(grid[i][j], 1, (oldValue, newValue) -> oldValue + newValue);
            }
            for (int j = 0; j < 10; j++) {
                cache[i][j] = grid.length - countMap.getOrDefault(j, 0);
            }
        }
        // 计算出最小改变次数
        for (int[] ints : cache) {

        }
        return 0;
    }



    public static void main(String[] args) {
        // [[5,3,1],[5,9,4],[2,3,3]]
        // 5 3 1
        // 5 9 4
        // 2 3 3
        MinimumOperations minimumOperations = new MinimumOperations();
        int result = minimumOperations.minimumOperations(new int[][]{{5,3,1}, {5, 4, 9}, {2,3,3}});
        System.out.println(result);
    }
}
