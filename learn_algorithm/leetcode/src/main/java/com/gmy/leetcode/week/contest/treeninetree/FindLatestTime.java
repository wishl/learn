package com.gmy.leetcode.week.contest.treeninetree;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s，表示一个 12 小时制的时间格式，其中一些数字（可能没有）被 "?" 替换。
 * 12 小时制时间格式为 "HH:MM" ，其中 HH 的取值范围为 00 至 11，MM 的取值范围为 00 至 59。最早的时间为 00:00，最晚的时间为 11:59。
 * 你需要将 s 中的 所有 "?" 字符替换为数字，使得结果字符串代表的时间是一个 有效 的 12 小时制时间，并且是可能的 最晚 时间。
 *
 * 返回结果字符串。
 */
public class FindLatestTime {

    public String findLatestTime(String s) {
        if (!s.contains("?")) {
            return s;
        }
        Map<Integer, Character> indexMap = new HashMap<>();
        indexMap.put(0, '1');
        indexMap.put(3, '5');
        indexMap.put(4, '9');
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '?' && i != 1) {
                Character max = indexMap.get(i);
                charArray[i] = max;
            } else if (charArray[i] == '?' && i == 1 && charArray[0] == '0') {
                charArray[i] = '9';
            } else if (charArray[i] == '?' && i == 1 && charArray[0] != '0' && (charArray[3] != '0' || charArray[4] != '0')) {
                charArray[i] = '1';
            } else if (charArray[i] == '?' && i == 1 && charArray[0] != '0' && charArray[3] == '0' && charArray[4] == '0') {
                charArray[i] = '2';
            }
        }
        s = new String(charArray);
        return s;
    }

    public static void main(String[] args) {
        FindLatestTime findLatestTime = new FindLatestTime();
        String latestTime = findLatestTime.findLatestTime("0?:5?");
        System.out.println(latestTime);
    }

}
