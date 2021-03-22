package com.gmy.leetcode;

import java.util.Arrays;

/**
 * 给你一个 n x n 的 方形 整数数组matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 *
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。
 * 在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。
 * 具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-falling-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * 输出：13
 * 解释：如图所示，为和最小的两条下降路径
 */
public class MinFallingPathSum {

    /**
     * 题目需要求出矩阵的和最小下降路径，可以求出末行每个元素的和最小下降路径，
     * 然后找到其中和最小的那一条路径即可。而根据题意，每个坐标仅可以通过它的上一排紧邻的三个坐标到达
     * （左上，正上，右上），根据贪心思想，每个坐标的和最小下降路径长度即为它的上一排紧邻的三个坐标的和最小下降路径长度的最小值，
     * 再加上当前坐标的和。用dp表示和最小下降路径长度的话，
     * 即为dp[i][j]=matrix[i][j]+min(dp[i−1][j−1],dp[i−1][j],dp[i−1][j+1])，
     * 第一列和最后一列有边界情况，需要特殊处理。而第一行每个元素的和最小下降路径长度为它们本身的值。
     * 最后返回最后一行的和最小下降路径长度的最小值即可。
     * @param matrix
     * @return
     */
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        dp[0] = matrix[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int nm = dp[i - 1][j];
                if (j > 0) {
                    nm = Math.min(dp[i - 1][j - 1], nm);
                }
                if (j < n - 1) {
                    nm = Math.min(dp[i - 1][j + 1], nm);
                }
                dp[i][j] = nm + matrix[i][j];
            }
        }
        return Arrays.stream(dp[n - 1]).min().getAsInt();
    }

    public int minFallingPathSum1(int[][] matrix) {
        return dfs(matrix, 0, 0, matrix.length - 1, 0, Integer.MAX_VALUE);
    }

    private int dfs(int[][] matrix, int row, int leftCol, int rightCol, int sum, int result) {
        if (row == matrix.length) {
            return Math.min(result, sum);
        }
        for (int i = leftCol; i <= rightCol; i++) {
            int nextLeft = Math.max(0, i - 1);
            int nextRight = Math.min(matrix.length - 1, i + 1);
            sum += matrix[row][i];
            result = dfs(matrix, row + 1, nextLeft, nextRight, sum, result);
            sum -= matrix[row][i];
        }
        return result;
    }


    public static void main(String[] args) {
        MinFallingPathSum minFallingPathSum = new MinFallingPathSum();
        int[][] matrix = new int[][] {{2,1,3}, {6,5,4}, {7,8,9}};
        int result = minFallingPathSum.minFallingPathSum(matrix);
        int result1 = minFallingPathSum.minFallingPathSum1(matrix);
        System.out.println(result);
        System.out.println(result1);
    }
}
