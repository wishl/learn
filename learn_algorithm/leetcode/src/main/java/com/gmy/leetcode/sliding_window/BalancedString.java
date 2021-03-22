package com.gmy.leetcode.sliding_window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 有一个只含有'Q', 'W', 'E','R'四种字符，且长度为 n的字符串。
 * 假如在该字符串中，这四个字符都恰好出现n/4次，那么它就是一个「平衡字符串」。
 *
 * 给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
 * 你可以用和「待替换子串」长度相同的任何 其他字符串来完成替换。
 * 请返回待替换子串的最小可能长度。
 * 如果原字符串自身就是一个平衡字符串，则返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/replace-the-substring-for-balanced-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 示例 1：
 *
 * 输入：s = "QWER"
 * 输出：0
 * 解释：s 已经是平衡的了。
 * 示例 2：
 *
 * 输入：s = "QQWE"
 * 输出：1
 * 解释：我们需要把一个 'Q' 替换成 'R'，这样得到的 "RQWE" (或 "QRWE") 是平衡的。
 * 示例 3：
 *
 * 输入：s = "QQQW"
 * 输出：2
 * 解释：我们可以把前面的 "QQ" 替换成 "ER"。
 * 示例 4：
 *
 * 输入：s = "QQQQ"
 * 输出：3
 * 解释：我们可以替换后 3 个 'Q'，使 s = "QWER"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/replace-the-substring-for-balanced-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BalancedString {

    public int balancedString1(String s) {
        int count = s.length() / 4, result = Integer.MAX_VALUE, changeCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> toChange = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > count) {
                toChange.put(c, toChange.getOrDefault(c, 0) + 1);
                changeCount++;
            }
        }
        if (changeCount == 0) {
            return 0;
        }
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (toChange.containsKey(c) && toChange.get(c) > 0) {
                toChange.put(c, toChange.get(c) - 1);
                changeCount--;
            } else if (toChange.containsKey(c)) {
                toChange.put(c, toChange.get(c) - 1);
            }
            while (changeCount == 0 && toChange.size() > 0) {
                result = Math.min(result, right - left + 1);
                char leftChar = s.charAt(left);
                if (toChange.containsKey(leftChar) && toChange.get(leftChar) >= 0) {
                    toChange.put(leftChar, toChange.get(leftChar) + 1);
                    changeCount++;
                } else if (toChange.containsKey(leftChar)) {
                    toChange.put(leftChar, toChange.get(leftChar) + 1);
                }
                left++;
            }
            right++;
        }
        return result;
    }

    public int balancedString(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt[idx(c)]++;
        }

        int partial = s.length() / 4;
        int res = s.length();

        if (check(cnt, partial)) {
            return 0;
        }
        for (int l = 0, r = 0; l < s.length(); l++) {
            while (r < s.length() && !check(cnt, partial)) {
                cnt[idx(s.charAt(r))]--;
                r++;
            }
            if (!check(cnt, partial)) {
                break;
            }
            res = Math.min(res, r - l);
            cnt[idx(s.charAt(l))]++;
        }
        return res;
    }

    public int idx(char c) {
        return c - 'A';
    }

    public boolean check(int[] cnt, int partial) {
        if (cnt[idx('Q')] > partial || cnt[idx('W')] > partial || cnt[idx('E')] > partial || cnt[idx('R')] > partial) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BalancedString balancedString = new BalancedString();
//        RQQQW
        int result = balancedString.balancedString("WQWRQQQW");
        System.out.println(result);
    }
}
