package com.gmy.leetcode.sliding_window;

import java.util.Arrays;
import java.util.List;

/**
 * 给你字符串 s 和整数 k 。
 *
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 * 英文中的 元音字母 为（a, e, i, o, u）。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：s = "abciiidef", k = 3
 * 输出：3
 * 解释：子字符串 "iii" 包含 3 个元音字母
 */
public class MaxVowels {

    public int maxVowels(String s, int k) {
        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u');
        int left = 0, right = 0, count = 0, result = 0;
        while (right < k) {
            if (list.contains(s.charAt(right++))) {
                count++;
            }
        }
        result = count;
        while (right < s.length()) {
            System.out.println(left);
            System.out.println(right);
            if (list.contains(s.charAt(left++))) {
                count--;
            }
            if (list.contains(s.charAt(right++))) {
                count++;
            }
            result = Math.max(result, count);
        }
        return result;
    }

    public static void main(String[] args) {
        MaxVowels maxVowels = new MaxVowels();
        int result = maxVowels.maxVowels("leetceee", 3);
//        System.out.println(result);
    }
}
