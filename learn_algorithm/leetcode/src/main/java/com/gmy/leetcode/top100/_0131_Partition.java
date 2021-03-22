package com.gmy.leetcode.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串。返回 s 所有可能的分割方案。
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：[["a"]]
 * todo review
 */
public class _0131_Partition {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), s, 0, 0);
        return result;
    }

    private void dfs(List<List<String>> result, List<String> path, String s, int start, int end) {
        if (end == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 不选
//        if (end < s.length() - 1) {
//            dfs(result, path, s, start, end + 1);
//        }
        // 不选 i 和 i+1 之间的逗号（i=n-1 时一定要选）
        // 不选 i 和 i+1 之间的逗号（i=n-1 时一定要选）
        if (end < s.length() - 1)
            dfs(result, path, s, start, end + 1);

        // 选 i 和 i+1 之间的逗号（把 s[i] 作为子串的最后一个字符）
        if (isPalindrome(start, end, s)) {
            path.add(s.substring(start, end + 1));
            dfs(result, path, s, end + 1, end + 1);
            path.remove(path.size() - 1); // 恢复现场
        }
    }

    private void dfs1(List<List<String>> result, List<String> path, String s, int start, int end) {
        if (end == s.length()) {
            result.add(new ArrayList<>(path)); // 复制 path
            return;
        }

        // 不选 i 和 i+1 之间的逗号（i=n-1 时一定要选）
        if (end < s.length() - 1)
            dfs1(result, path, s, start, end + 1);

        // 选 i 和 i+1 之间的逗号（把 s[i] 作为子串的最后一个字符）
        if (isPalindrome(start, end, s)) {
            path.add(s.substring(start, end + 1));
            dfs1(result, path, s, end + 1, end + 1);
            path.remove(path.size() - 1); // 恢复现场
        }
    }

    private boolean isPalindrome(int left, int right, String s) {
        while (left < right)
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        return true;
    }

    public static void main(String[] args) {
        _0131_Partition partition = new _0131_Partition();
        List<List<String>> result = partition.partition("aab");
        System.out.println(result);
    }

}
