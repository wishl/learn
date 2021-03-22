package com.gmy.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCombinationsReview {

    public List<String> letterCombinations(String digits) {
        Map<Character, List<String>> charMap = new HashMap<>();
        List<String> result = new ArrayList<>();
        if (digits == null || digits.equals("")) {
            return result;
        }
        charMap.put('2', Arrays.asList("a", "b", "c"));
        charMap.put('3', Arrays.asList("d", "e", "f"));
        charMap.put('4', Arrays.asList("g", "h", "i"));
        charMap.put('5', Arrays.asList("j", "k", "l"));
        charMap.put('6', Arrays.asList("m", "n", "o"));
        charMap.put('7', Arrays.asList("p", "q", "r", "s"));
        charMap.put('8', Arrays.asList("t", "u", "v"));
        charMap.put('9', Arrays.asList("w", "x", "y", "z"));
        dfs(digits, 0, charMap, result, "");
        return result;
    }

    private void dfs(String digits, int index, Map<Character, List<String>> charMap, List<String> result, String res) {
        if (index == digits.length()) {
            result.add(res);
            return;
        }
        char c = digits.charAt(index);
        List<String> list = charMap.get(c);
        for (String s : list) {
            dfs(digits, index + 1, charMap, result, res + s);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsReview letterCombinationsReview = new LetterCombinationsReview();
        List<String> result = letterCombinationsReview.letterCombinations("");
        System.out.println(result);
    }
}
