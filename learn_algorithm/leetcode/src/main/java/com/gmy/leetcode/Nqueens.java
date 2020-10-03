package com.gmy.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Nqueens {

    public static List<List<String>> solveNQueens(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = "";
            for (int j = 0; j < n; j++) {
                s += ".";
            }
            result.add(s);
        }
        return null;
    }

    private static void getResult(List<String> param, Set<Integer> column,
                                  Set<Integer> row, int n, int time, List<List<String>> result) {
//        if (n == time) {
//            result.add(param);
//            return;
//        }
//        for (int i = 0; i < n; i++) {
//            if(row) {
//
//            }
//            param.get(i);
//        }
    }

}
