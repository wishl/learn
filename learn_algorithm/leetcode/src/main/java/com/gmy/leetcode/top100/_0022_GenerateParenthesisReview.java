package com.gmy.leetcode.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 */
public class _0022_GenerateParenthesisReview {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, new StringBuilder(), n, 0, 0);
        return result;
    }

    /**
     * 枚举左括号
     * @param result
     * @param path
     */
    private void dfs(List<String> result, StringBuilder path, int n, int left, int right) {
        if (path.length() == 2 * n) {
            result.add(path.toString());
            return;
        }
        if (left < n) {
            path.append("(");
            dfs(result, path, n, left + 1, right);
            path.deleteCharAt(path.length() - 1);
        }
        if (right < left) {
            path.append(")");
            dfs(result, path, n, left, right + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        _0022_GenerateParenthesisReview generateParenthesisReview = new _0022_GenerateParenthesisReview();
        List<String> result = generateParenthesisReview.generateParenthesis(3);
        System.out.println(result);
    }

}
