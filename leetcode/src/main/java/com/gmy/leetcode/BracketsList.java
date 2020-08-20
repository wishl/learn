package com.gmy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，
 * 请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * https://leetcode-cn.com/problems/generate-parentheses/solution/gua-hao-sheng-cheng-by-leetcode-solution/
 */
public class BracketsList {

    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        return combinations;
    }

    // 暴力解，分治法
    private void getResult(char[] chars, int position, List<String> ans) {
        if (chars.length == position && valid(chars)) {
            ans.add(new String(chars));
            return;
        }
        chars[position] = '(';
        getResult(chars, position + 1, ans);
        chars[position] = ')';
        getResult(chars, position + 1, ans);
    }

    // 校验是否是完整（）
    private boolean valid(char[] chars) {
        int left = 0;
        for (char aChar : chars) {
            if (aChar == '(') {
                left ++;
            } else {
                left --;
            }
            if (left < 0) {
                return false;
            }
        }
        return left == 0;
    }

    // 回溯法，先把所有的（列出来，之后在匹配）
    private void getResult(StringBuilder sb, int open, int close, List<String> ans, int max) {
        if (sb.length() == 2 * max) {
            ans.add(sb.toString());
            return;
        }
        if (open < max) {
            sb.append("(");
            getResult(sb, open + 1, close, ans, max);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            getResult(sb, open, close + 1, ans, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
