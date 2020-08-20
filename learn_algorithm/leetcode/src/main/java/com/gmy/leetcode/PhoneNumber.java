package com.gmy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class PhoneNumber {

    private Map<String, List<String>> valueCache = new HashMap<>();

    Map<String, String> phone = new HashMap<String, String>() {{
        put("1", "");
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
        put("0", "");
    }};

    List<String> output = new ArrayList<>();

    // 回溯法
    public void backtrack(String result, String param) {
        if (param.length() == 0) {
            output.add(result);
        } else {
            String nowString = param.substring(0, 1);
            String s = phone.get(nowString);
            for (int i = 0; i < s.length(); i++) {
                String substring = s.substring(i, i + 1);
                backtrack(result + substring, param.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits != null && digits.length() > 0) {
            backtrack("", digits);
        }
        return output;
    }

    public static void main(String[] args) {
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.letterCombinations("23");
        System.out.println(phoneNumber.output);
    }

}
