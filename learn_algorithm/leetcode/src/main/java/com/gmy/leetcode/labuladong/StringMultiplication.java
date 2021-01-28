package com.gmy.leetcode.labuladong;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 */
public class StringMultiplication {

    public static String multiply(String num1, String num2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = num2.length() - 1; i >= 0; i--) {
            char c2 = num2.charAt(i);
            for (int j = num1.length() - 1; j >= 0 ; j--) {
                char c1 = num1.charAt(j);
                int i1 = (c1 - '0') * (c2 - '0');
                Integer c = map.get(j + i);
                if (c == null) {
                    map.put(j + i, i1);
                } else {
                    map.put(j + i, i1 + c);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        int add = 0;
        // 去除0的前缀
        int i = num1.length() + num2.length() - 2;
        int end = 0;
        while (end < i && map.get(end) == 0)
            end++;
        for (; i >= end ; i--) {
            Integer integer = map.get(i) + add;
            add = integer / 10;
            result.insert(0, integer % 10);
        }
        if (add != 0) {
            result.insert(0, add);
        }
        return result.toString().length() == 0 ? "0" : result.toString();
    }

    public static void main(String[] args) {
        String result = multiply("52", "60");
        System.out.println(result);
    }

}
