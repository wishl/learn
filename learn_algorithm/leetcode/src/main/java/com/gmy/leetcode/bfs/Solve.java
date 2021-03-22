package com.gmy.leetcode.bfs;

/**
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solve {

    public void solve(char[][] board) {
        int innerLength = board[0].length;
        int outterLength = board.length;
        for (int i = 0; i < innerLength; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[outterLength - 1][i] == 'O') {
                dfs(board, outterLength - 1, i);
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][innerLength - 1] == 'O') {
                dfs(board, i, innerLength - 1);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < innerLength; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] == 'A') {
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = 'A';
            dfs(board, i + 1, j);
            dfs(board, i - 1, j);
            dfs(board, i, j + 1);
            dfs(board, i, j - 1);
        }
    }

    public static void main(String[] args) {
       char[][] board = new char[][]{{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
       Solve solve = new Solve();
       solve.solve(board);
       System.out.println(ArrayToString(board));
    }

    public static String ArrayToString(char[][] arr) {

        if (arr == null)
            return "null";

        int iMax = arr.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append("[");
        for (int i = 0; i <= iMax; i++) {
            if (arr[i].length == 0) {
                b.append("[]");
                continue;
            }else if (arr[i] == null) {
                b.append("[null]");
                continue;
            }
            b.append("[");
            for (int j = 0; j < arr[i].length; j++) {
                b.append("" + arr[i][j]);
                if (j == arr[i].length - 1) {
                    b.append("]");
                    continue;
                }
                b.append(",");
            }
        }
        b.append("]");
        return b.toString();
    }

}
