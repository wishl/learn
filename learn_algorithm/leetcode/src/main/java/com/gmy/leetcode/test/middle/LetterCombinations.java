package com.gmy.leetcode.test.middle;

import com.gmy.leetcode.tree.BuildAvl;
import com.google.common.collect.Lists;

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
 */
public class LetterCombinations {

    Map<Character, List<String>> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
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
        dfs(result, digits, 0, new StringBuilder());
        return result;
    }

    private void dfs(List<String> result, String digits, int index, StringBuilder builder) {
        if (index >= digits.length()) {
            result.add(builder.toString());
            return;
        }
        char c = digits.charAt(index);
        for (String s : map.get(c)) {
            builder.append(s);
            dfs(result, digits, index + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> result = letterCombinations.letterCombinations("");
        System.out.println(result);
    }
}
