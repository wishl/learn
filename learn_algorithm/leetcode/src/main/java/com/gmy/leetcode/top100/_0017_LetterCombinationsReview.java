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
 */
public class _0017_LetterCombinationsReview {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        Map<Character, List<String>> map = new HashMap<>();
        map.put('2', Stream.of("a", "b", "c").collect(Collectors.toList()));
        map.put('3', Stream.of("d", "e", "f").collect(Collectors.toList()));
        map.put('4', Stream.of("g", "h", "i").collect(Collectors.toList()));
        map.put('5', Stream.of("j", "k", "l").collect(Collectors.toList()));
        map.put('6', Stream.of("m", "n", "o").collect(Collectors.toList()));
        map.put('7', Stream.of("p", "q", "r", "s").collect(Collectors.toList()));
        map.put('8', Stream.of("t", "u", "v").collect(Collectors.toList()));
        map.put('9', Stream.of("w", "x", "y", "z").collect(Collectors.toList()));
        dfs(result, 0, digits, map, new StringBuilder());
        return result;
    }

    private void dfs(List<String> result, int index, String s, Map<Character, List<String>> map, StringBuilder path) {
        if (path.length() == s.length()) {
            result.add(path.toString());
            return;
        }
        char c = s.charAt(index);
        List<String> strings = map.get(c);
        for (int i = 0; i < strings.size(); i++) {
            String s1 = strings.get(i);
            path.append(s1);
            dfs(result, index + 1, s, map, path);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        _0017_LetterCombinationsReview review = new _0017_LetterCombinationsReview();
        List<String> result = review.letterCombinations("");
        System.out.println(result);
    }

}
