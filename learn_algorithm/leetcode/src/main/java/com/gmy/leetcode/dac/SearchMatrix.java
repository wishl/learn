package com.gmy.leetcode.dac;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchMatrix {

    public boolean searchMatrix1(int[][] matrix, int target) {
        int x = 0, y = matrix[0].length - 1;
        for (; x < matrix.length && y >= 0 ; ) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {// 当前点大于target说明整列大于target
                y--;
            } else {// 当前点小于target时，说明整行小于target
                x++;
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int length = matrix[0].length - 1;
        boolean row = getRow(matrix, target, 0, matrix.length - 1, length);
        return row;
    }

    private boolean getRow(int[][] matrix, int target, int left, int right, int length) {
        if (left > right) {
            return false;
        }
        int mid = (left + right) / 2;
        if (matrix[mid][0] > target) {
            return getRow(matrix, target, left, mid - 1, length);
        } else if (matrix[mid][0] <= target) { // 如果当前行的第0个小于 target 并且当前行的 没有找到target时, 搜索前后的数组
            if (matrix[mid][0] == target || matrix[mid][length] == target) {
                return true;
            }
            Integer index = find(matrix[mid], target, 0, length);
            if (index != null) {
                return true;
            } else {
                boolean L = getRow(matrix, target, left, mid - 1, length);
                boolean R = getRow(matrix, target, mid + 1, right, length);
                return L || R;
            }
        } else {
            return false;
        }
    }

    private Integer find(int[] nums, int target, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return find(nums, target, left, mid - 1);
        } else {
            return find(nums, target, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        SearchMatrix searchMatrix = new SearchMatrix();
        boolean b = searchMatrix.searchMatrix1(matrix, 5);
        System.out.println(b);
    }
}
