package com.gmy.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Number {

    private static Set<Character> set = new HashSet<>();

    public static boolean isNumber(String s) {
        set.add('E');
        set.add('.');
        return getResult(s, ' ');
    }

    private static boolean getResult(String s, char last) {
        if (s == null || s.length() == 0) {
            return false;
        }
        if (last != '.' && (s.startsWith("+") || s.startsWith("-"))) {
            s = s.substring(1);
        }
        s = s.toUpperCase();
        char[] chars = s.toCharArray();
        int i = 0;
        for (char c : chars) {
            if (c >= '0' && c <= '9') {
                i++;
                continue;
            }else if (set.contains(c)) {
                set.remove(c);
                return getResult(s.substring(i + 1), c);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean number = isNumber("12e+5.4");
        System.out.println(number);
    }

}
