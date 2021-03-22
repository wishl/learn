package com.gmy.leetcode.dfs;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Exist {

    private int[][] directions = {{0 , 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = dfs(visited, board, word, i, j, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(boolean[][] checked, char[][] nums, String s, int i, int j, int index) {
        if (nums[i][j] != s.charAt(index)) {
            return false;
        } else if (index == s.length() - 1) {
            return true;
        }
        checked[i][j] = true;
        for (int k = 0; k < directions.length; k++) {
            int newi = i + directions[k][0]; int newj = j + directions[k][1];
            if (newi >= 0 && newi < nums.length && newj >= 0 && newj < nums[0].length && !checked[newi][newj]) {
                boolean result = dfs(checked, nums, s, newi, newj, index + 1);
                if (result) {
                    return true;
                }
            }
        }
        checked[i][j] = false;
        return false;
    }

}
