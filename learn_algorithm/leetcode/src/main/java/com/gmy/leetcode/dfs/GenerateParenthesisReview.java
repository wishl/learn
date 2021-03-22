package com.gmy.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * https://leetcode.cn/problems/generate-parentheses/
 */
public class GenerateParenthesisReview {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(n, 0, 0, result, new StringBuilder());
        return result;
    }

    private void dfs(int count, int open, int close, List<String> result, StringBuilder builder) {
        if (count * 2 == builder.length()) {
            result.add(builder.toString());
            return;
        }
        if (open < count) {
            builder.append("(");
            dfs(count, open + 1, close, result, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (close < open) {
            builder.append(")");
            dfs(count, open, close + 1, result, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesisReview generateParenthesisReview = new GenerateParenthesisReview();
        List<String> result = generateParenthesisReview.generateParenthesis(3);
        System.out.println(result);
    }

    // ()()()
}
