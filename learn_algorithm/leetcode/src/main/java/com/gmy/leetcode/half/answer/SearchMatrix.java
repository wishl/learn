package com.gmy.leetcode.half.answer;

/**
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 *
 * https://leetcode.cn/problems/search-a-2d-matrix/description/
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int[] nums = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            nums[i] = matrix[i][0];
        }
        // 小于target的最大值
        int row = binarySearch(nums, target);
        if (row < 0 || row > matrix.length) {
            return false;
        }
        int result = binarySearch(matrix[row], target);
        return result >= 0 && result < matrix[0].length && matrix[row][result] == target;
    }

    /**
     * 小于等于target的最大值
     * @param nums
     * @param target
     * @return
     */
    private int binarySearch(int[] nums, int target) {
        // left左边小于等于target 右边严格大于target
        // [left, right]
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        SearchMatrix searchMatrix = new SearchMatrix();
        boolean result = searchMatrix.searchMatrix(new int[][]{{1, 1}}, 1);
        System.out.println(result);
    }


}
