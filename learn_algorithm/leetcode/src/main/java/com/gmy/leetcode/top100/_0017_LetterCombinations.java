package com.gmy.leetcode.top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class _0017_LetterCombinations {

    Map<Character, List<String>> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        map.put('2', Stream.of("a", "b", "c").collect(Collectors.toList()));
        map.put('3', Stream.of("d", "e", "f").collect(Collectors.toList()));
        map.put('4', Stream.of("g", "h", "i").collect(Collectors.toList()));
        map.put('5', Stream.of("j", "k", "l").collect(Collectors.toList()));
        map.put('6', Stream.of("m", "n", "o").collect(Collectors.toList()));
        map.put('7', Stream.of("p", "q", "r", "s").collect(Collectors.toList()));
        map.put('8', Stream.of("t", "u", "v").collect(Collectors.toList()));
        map.put('9', Stream.of("w", "x", "y", "z").collect(Collectors.toList()));
        dfs(digits, 0, result, new StringBuilder());
        return result;
    }

    private void dfs(String digits, int index, List<String> result, StringBuilder builder) {
        if (builder.length() == digits.length()) {
            result.add(builder.toString());
            return;
        }
        List<String> strings = map.get(digits.charAt(index));
        for (String s : strings) {
            builder.append(s);
            dfs(digits, index + 1, result, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void main(String[] args) {
        _0017_LetterCombinations letterCombinations = new _0017_LetterCombinations();
        List<String> result = letterCombinations.letterCombinations("");
        System.out.println(result);
    }
}
