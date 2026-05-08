package com.gmy.leetcode.lingcha.window.max_count;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个字符串 word1 和 word2 。
 * 如果一个字符串 x 重新排列后，word2 是重排字符串的 前缀 ，那么我们称字符串 x 是 合法的 。
 * 请你返回 word1 中 合法 子字符串 的数目。
 * 注意 ，这个问题中的内存限制比其他题目要 小 ，所以你 必须 实现一个线性复杂度的解法。
 *
 * https://leetcode.cn/problems/count-substrings-that-can-be-rearranged-to-contain-a-string-ii/
 */
public class ValidSubstringCount {


    public long validSubstringCount(String word1, String word2) {
        int left = 0, tCount = word2.length();
        long result = 0;
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < word2.length(); i++) {
            countMap.merge(word2.charAt(i), 1, Integer::sum);
        }
        char[] charArray = word1.toCharArray();
        for (int right = 0; right < word1.length(); right++) {
            if (countMap.containsKey(charArray[right])) {
                Integer count = countMap.put(charArray[right], countMap.get(charArray[right]) - 1);
                if (count > 0) {
                    tCount--;
                }
            }
            while (tCount == 0) {
                result += charArray.length - right;
                if (countMap.containsKey(charArray[left])) {
                    Integer put = countMap.put(charArray[left], countMap.get(charArray[left]) + 1);
                    if (put + 1 > 0) {
                        tCount++;
                    }
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ValidSubstringCount validSubstringCount = new ValidSubstringCount();
        long result = validSubstringCount.validSubstringCount("bcca", "abc");
        System.out.println(result);

    }
    
}
