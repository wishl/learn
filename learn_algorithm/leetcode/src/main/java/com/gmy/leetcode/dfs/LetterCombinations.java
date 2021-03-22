package com.gmy.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的组合
 * leetcode：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 还可以用bfs
 */
public class LetterCombinations {

    private Map<Character, List<String>> CHAR_MAP = new HashMap<Character, List<String>>() {{
        put('2', Arrays.asList("a", "b", "c"));
        put('3', Arrays.asList("d", "e", "f"));
        put('4', Arrays.asList("g", "h", "i"));
        put('5', Arrays.asList("j", "k", "l"));
        put('6', Arrays.asList("m", "n", "o"));
        put('7', Arrays.asList("p", "q", "r", "s"));
        put('8', Arrays.asList("t", "u", "v"));
        put('9', Arrays.asList("w", "x", "y", "z"));
    }};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        dfs(digits, 0, result, new StringBuilder());
        return result;
    }

    private void dfs(String digits, Integer index, List<String> result, StringBuilder builder) {
        if (index == digits.length()) {
            result.add(builder.toString());
            return;
        }
        List<String> strings = CHAR_MAP.get(digits.charAt(index));
        for (String string : strings) {
            builder.append(string);
            dfs(digits, index + 1, result, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> strings = letterCombinations.letterCombinations("23");
        System.out.println(strings);
    }

//    [ad, ae, af, bd, be, bf, cd, ce, cf]


}
