package com.gmy.leetcode.top100;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class _0020_IsValid {

    public boolean isValid(String s) {
        Set<Character> right = new HashSet<>();
        right.add(')');
        right.add('}');
        right.add(']');
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Deque<Character> deque = new LinkedList<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (!right.contains(c)) {
                deque.add(c);
            } else {
                if (deque.isEmpty()) {
                    return false;
                }
                Character pop = deque.pollLast();
                if (!pop.equals(map.get(c))) {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        _0020_IsValid isValid = new _0020_IsValid();
        boolean result = isValid.isValid("]");
        System.out.println(result);
    }

}
