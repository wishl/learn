package com.gmy.leetcode.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * https://leetcode.cn/problems/generate-parentheses/description/
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * todo review
 */
public class _0022_GenerateParenthesis {

    public List<String> generateParenthesis(int n){
        char[] line = new char[n*2];
        process(line, 0, 0, 0, n);
        return res;
    }

    List<String> res = new ArrayList<>();

    private void process(char[] line, int index, int leftCount, int rightCount, int n) {
        if (index == n * 2) {
            res.add(new String(line));
            return;
        }
        if (leftCount == rightCount) {
            line[index] = '(';
            process(line, index + 1, leftCount + 1, rightCount, n);
            return;
        }
        if (leftCount< n) {
            line[index] = '(';
            process(line , index + 1, leftCount + 1, rightCount, n);
        }
        if (rightCount < n) {
            line[index] = ')';
            process(line, index + 1, leftCount, rightCount + 1, n);
        }
    }

    public static void main(String[] args) {
        _0022_GenerateParenthesis generateParenthesis = new _0022_GenerateParenthesis();
        List<String> result = generateParenthesis.generateParenthesis(3);
        System.out.println(result);
    }

}
