package com.gmy.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。
 * 你不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RestoreIpAddresses {

    private List<String> result;

    public List<String> restoreIpAddresses(String s) {
        this.result = new ArrayList<>();
        dfs(s, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(String s, List<String> result, int index) {
        if (result.size() == 4) {
            if (index == s.length()) {
                this.result.add(buildIp(result));
            }
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String substring = s.substring(index, i + 1);
            if ((substring.charAt(0) == '0' && substring.length() == 1 || substring.charAt(0) != '0')
                    && Integer.parseInt(substring) <= 255) {
                result.add(substring);
                dfs(s, result, i + 1);
                result.remove(result.size() - 1);
            } else {
                return;
            }
        }
    }

    private String buildIp(List<String> param) {
        return param.get(0) + "." + param.get(1) + "." + param.get(2) + "." + param.get(3);
    }

    public static void main(String[] args) {
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        List<String> strings = restoreIpAddresses.restoreIpAddresses("101023");
        System.out.println(strings);
    }

//    [1.0.10.23, 1.0.102.3, 10.1.0.23, 10.10.2.3, 101.0.2.3]
//    [1.0.10.23, 1.0.102.3, 10.1.0.23, 10.10.2.3, 101.0.2.3]

}
