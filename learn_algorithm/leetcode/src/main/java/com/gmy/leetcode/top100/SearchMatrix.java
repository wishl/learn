package com.gmy.leetcode.top100;

/**
 * 给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        if(row <= 0)
            return false;
        int col= matrix[0].length;
        int i= 0, j= col-1;
        while (i < row && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if(matrix[i][j] > target) {
                j--;
            } else if(matrix[i][j] < target) {
                i++;
            }
        }
        return false;
    }

    /**
     * 寻找<=target的最大的数
     * @param ints
     * @param target
     * @return
     */
    private int find(int[] ints, int target) {
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
        SearchMatrix searchMatrix = new SearchMatrix();
        int[][] matrix = new int[][] {{-1,3}};
        boolean result = searchMatrix.searchMatrix(matrix, 3);
        System.out.println(result);
    }

}
