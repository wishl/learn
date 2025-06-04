package com.gmy.leetcode.week.contest._451;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个由小写英文字母组成的字符串 s。
 * 你 必须 在字符串 s 中至少存在两个 连续 字符时，反复执行以下操作：
 * 移除字符串中 最左边 的一对按照字母表 连续 的相邻字符（无论是按顺序还是逆序，例如 'a' 和 'b'，或 'b' 和 'a'）。
 * 将剩余字符向左移动以填补空隙。
 * 当无法再执行任何操作时，返回最终的字符串。
 *
 * 注意：字母表是循环的，因此 'a' 和 'z' 也视为连续。
 *
 * 输入: s = "dabc"
 * 输出: "c"
 * 解释:
 * 从字符串中移除 "ab"，剩下 "c"。
 * 无法进行进一步操作。因此，所有可能移除操作后的最终字符串为 "c"。
 *
 * 示例 2：
 *
 * 输入: s = "adcb"
 * 输出: ""
 * 解释:
 * 从字符串中移除 "dc"，剩下 "ab"。
 * 从字符串中移除 "ab"，剩下 ""。
 * 无法进行进一步操作。因此，所有可能移除操作后的最终字符串为 ""。
 */
public class ResultingString {

    public String resultingString(String s) {
        if (s.length() < 2) {
            return s;
        }
        List<Character> list = new ArrayList<>();
        list.add(s.charAt(0));
        char[] charArray = s.toCharArray();
        for (int i = 1; i < charArray.length; i++) {
            char value = charArray[i];
            if (!list.isEmpty() && check(list.get(list.size() - 1), value)) {
                list.remove(list.size() - 1);
            } else {
                list.add(value);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (Character c : list) {
            sb.append(c);
        }
        return sb.toString();
    }

    private boolean check(Character leftC, Character rightC) {
        return Math.abs(leftC - rightC) == 1
                || (leftC == 'z' && rightC == 'a')
                || (rightC == 'z' && leftC == 'a');
    }

    public static void main(String[] args) {
        ResultingString resultingString = new ResultingString();
        String s = resultingString.resultingString("adcb");
        System.out.println(s);
    }

}
