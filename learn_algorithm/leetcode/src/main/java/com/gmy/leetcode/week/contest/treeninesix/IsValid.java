package com.gmy.leetcode.week.contest.treeninesix;

import java.util.HashSet;
import java.util.Set;

/**
 * 有效单词 需要满足以下几个条件：
 * 至少 包含 3 个字符。
 * 由数字 0-9 和英文大小写字母组成。（不必包含所有这类字符。）
 * 至少 包含一个 元音字母 。
 * 至少 包含一个 辅音字母 。
 * 给你一个字符串 word 。如果 word 是一个有效单词，则返回 true ，否则返回 false 。
 * 注意：
 * 'a'、'e'、'i'、'o'、'u' 及其大写形式都属于 元音字母 。
 * 英文中的 辅音字母 是指那些除元音字母之外的字母。
 *
 * https://leetcode.cn/problems/valid-word/description/
 *
 * 输入：word = "234Adas"
 * 输出：true
 * 解释：
 * 这个单词满足所有条件。
 */
public class IsValid {



    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }
        char[] charArray = word.toLowerCase().toCharArray();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        boolean yuanyin = false, fuyin = false;
        for (char c : charArray) {
            if (c >= 'a' && c <= 'z') {
                boolean contains = set.contains(c);
                if (contains) {
                    yuanyin = true;
                } else {
                    fuyin = true;
                }
            } else if (c < '0' || c > '9') {
                return false;
            }
        }
        return yuanyin && fuyin;
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        boolean result = isValid.isValid("y0Ap");
        System.out.println(result);
    }

}
