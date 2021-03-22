package com.gmy.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 *
 * abab
 * [a, b, a, b], [aba, b]
 *
 * 有优化空间，回文字可以动态规划（参考官方解题）
 */
public class Partition {

    private List<List<String>> result;

    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        dfs(new ArrayList<>(), 0, 0, s);
        return this.result;
    }


    private void dfs(List<String> result, int left, int right, String s) {
        if (right == s.length() || left < 0) {
            if (check(result, s)) {
                this.result.add(new ArrayList<>(result));
            }
            return;
        }
        // 选择当前
        result.add(s.substring(left, right + 1));
        dfs(result, right + 1, right + 1, s);
        result.remove(result.size() - 1);
        // 选择下一个
        dfs(result, left, right + 1, s);
    }

    private boolean check(List<String> result, String param) {
        StringBuilder build = new StringBuilder();
        for (String s : result) {
            build.append(s);
            int left = 0, right = s.length() - 1;
            while (left <= right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return build.toString().equals(param);
    }

    public static void main(String[] args) {
        Partition partition = new Partition();
        List<List<String>> aab = partition.partition("abab");
        System.out.println(aab);
    }


}
