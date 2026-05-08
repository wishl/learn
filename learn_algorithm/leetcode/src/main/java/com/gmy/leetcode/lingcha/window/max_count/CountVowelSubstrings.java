package com.gmy.leetcode.lingcha.window.max_count;

import java.util.Arrays;
import java.util.List;

/**
 * 子字符串 是字符串中的一个连续（非空）的字符序列。
 * 元音子字符串 是 仅 由元音（'a'、'e'、'i'、'o' 和 'u'）组成的一个子字符串，且必须包含 全部五种 元音。
 * 给你一个字符串 word ，统计并返回 word 中 元音子字符串的数目 。
 *
 * https://leetcode.cn/problems/count-vowel-substrings-of-a-string/description/
 * todo 再来一遍
 */
public class CountVowelSubstrings {

    public int countVowelSubstrings(String word) {
        int left = 0, result = 0;
        int[] counts = new int[5];
        char[] charArray = word.toCharArray();
        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u');
        for (int right = 0; right < word.length(); right++) {
            if (list.contains(charArray[right])) {
                counts[list.indexOf(charArray[right])]++;
            } else {
                while (counts[0] >= 1 && counts[1] >= 1 && counts[2] >= 1 && counts[3] >= 1 && counts[4] >= 1) {
                    result ++;
                    if (list.contains(charArray[left])) {
                        counts[list.indexOf(charArray[left])]--;
                    }
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountVowelSubstrings countVowelSubstrings = new CountVowelSubstrings();
        int result = countVowelSubstrings.countVowelSubstrings("aeiouu");
        System.out.println(result);
    }

}
