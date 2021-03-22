package com.gmy.leetcode.top100;

/**
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 *
 *
 */
public class _0074_SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int[] rowFirst = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            rowFirst[i] = matrix[i][0];
        }
        int index = binarySearch(rowFirst, target);
        if (index < 0) {
            return false;
        }
        int resultIndex = binarySearch(matrix[index], target);
        return resultIndex < matrix[0].length && matrix[index][resultIndex] == target;
    }

    private int binarySearch(int[] ints, int target) {
        int left = 0, right = ints.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (ints[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        _0074_SearchMatrix searchMatrix = new _0074_SearchMatrix();
        boolean result = searchMatrix.searchMatrix(new int[][]{{1}}, 10);
        System.out.println(result);
    }

}
