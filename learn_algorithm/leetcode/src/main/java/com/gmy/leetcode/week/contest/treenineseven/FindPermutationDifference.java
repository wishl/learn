package com.gmy.leetcode.week.contest.treenineseven;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个字符串 s 和 t，每个字符串中的字符都不重复，且 t 是 s 的一个排列。
 * 排列差 定义为 s 和 t 中每个字符在两个字符串中位置的绝对差值之和。
 * 返回 s 和 t 之间的 排列差 。
 *
 *
 */
public class FindPermutationDifference {

    public int findPermutationDifference(String s, String t) {
        int result = 0;
        Map<Character, Integer> tMap = new HashMap<>();
        char[] charArray = t.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            tMap.put(charArray[i], i);
        }
        char[] sCharArray = s.toCharArray();
        for (int i = 0; i < sCharArray.length; i++) {
            result += Math.abs(tMap.get(sCharArray[i]) - i);
        }
        return result;
    }

}
