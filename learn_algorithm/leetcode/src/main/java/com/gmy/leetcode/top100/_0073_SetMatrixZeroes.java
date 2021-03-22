package com.gmy.leetcode.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 */
public class _0073_SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        List<int[]> rowAndColumn = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rowAndColumn.add(new int[] {i, j});
                }
            }
        }
        for (int k = 0; k < rowAndColumn.size(); k++) {
            int[] rc = rowAndColumn.get(k);
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[rc[0]][i] = 0;
            }
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][rc[1]] = 0;
            }
        }
    }

    public static void main(String[] args) {
        _0073_SetMatrixZeroes setMatrixZeroes = new _0073_SetMatrixZeroes();
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setMatrixZeroes.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

}
