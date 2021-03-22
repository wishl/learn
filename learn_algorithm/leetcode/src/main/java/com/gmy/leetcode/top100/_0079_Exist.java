package com.gmy.leetcode.top100;

import java.util.Arrays;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 */
public class _0079_Exist {

    public boolean exist(char[][] board, String word) {
        char c = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == c) {
                    boolean result = infect(board, i, j, word, 0);
                    if (result) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean infect(char[][] board, int i, int j, String s, int index) {
        boolean result = false;
        if (index < s.length() && i >= 0 && j >= 0 && i < board.length
            && j < board[0].length && board[i][j] == s.charAt(index)) {
            char c = board[i][j];
            board[i][j] = '.';
            result |= infect(board, i, j + 1, s, index + 1);
            result |= infect(board, i, j - 1, s, index + 1);
            result |= infect(board, i + 1, j, s, index + 1);
            result |= infect(board, i - 1, j, s, index + 1);
            board[i][j] = c;
            return result;
        }
        return index == s.length();
    }

    public static void main(String[] args) {
        _0079_Exist exist = new _0079_Exist();
        boolean result = exist.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB");
        System.out.println(result);
    }
}
