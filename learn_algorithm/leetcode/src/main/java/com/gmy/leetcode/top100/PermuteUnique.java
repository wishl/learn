package com.gmy.leetcode.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * todo review
 */
public class PermuteUnique {

    public static List<String> permuteUnique(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        // 将字符串转换为字符数组，并排序
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean[] used = new boolean[chars.length];
        backtrack(chars, used, new StringBuilder(), result);

        // 排序结果（虽然由于输入已排序且回溯过程中已去重，这一步可能不是必须的，但保持一致性）
        Collections.sort(result);

        return result;
    }

    private static void backtrack(char[] chars, boolean[] used, StringBuilder sb, List<String> result) {
        if (sb.length() == chars.length) {
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            // 跳过已经使用过的字符和与上一个字符相同且未被使用的字符（去重）
            if (used[i] || (i > 0 && chars[i] == chars[i - 1] && !used[i - 1])) {
                continue;
            }
            sb.append(chars[i]);
            used[i] = true;
            backtrack(chars, used, sb, result);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        String str = "abb";
        List<String> permutations = permuteUnique(str);
        for (String s : permutations) {
            System.out.println(s);
        }
    }

}
