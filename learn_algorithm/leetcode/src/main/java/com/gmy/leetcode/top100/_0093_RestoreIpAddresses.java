package com.gmy.leetcode.top100;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1"
 * 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，
 * 这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 */
public class _0093_RestoreIpAddresses {

    private boolean check(List<String> list) {
        if (list.size() != 4) {
            return false;
        }
        for (String s : list) {
            if (s.length() == 0 || s.length() > 3 || s.length() > 1 && s.startsWith("0")) {
                return false;
            }
            int ip = Integer.parseInt(s);
            if (ip > 255) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<String> result, List<String> path, String s, int index, int start) {
        if (index == 3) {
            path.add(s.substring(start, s.length()));
            if (check(path)) {
                result.add(path.stream().collect(Collectors.joining(".")));
            }
            path.remove(path.size() - 1);
            return;
        }
        for (int i = start; i < start + 3 && i < s.length(); i++) {
            path.add(s.substring(start, i + 1));
            dfs(result, path, s, index + 1,  i + 1);
            path.remove(path.size() - 1);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() > 12) {
            return result;
        }
        dfs(result, new ArrayList<>(), s, 0, 0);
        return result;
    }

    public static void main(String[] args) {
        _0093_RestoreIpAddresses restoreIpAddresses = new _0093_RestoreIpAddresses();
        List<String> result = restoreIpAddresses.restoreIpAddresses("25525511135");
        System.out.println(result);
    }


}
