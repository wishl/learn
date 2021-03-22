package com.gmy.leetcode.review;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubstring {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int left = 0, right = 0, wordLength = words[0].length(), windowLength = wordLength * words.length;
        Map<String, Integer> countMap = new HashMap<>();
        int count = words.length;
        for (String word : words) {
            countMap.merge(word, 1, (oldValue, newValue) -> oldValue + newValue);
        }
        // 一次性增加wordLength
        for (int i = right; i - left <= windowLength && i < s.length(); i++) {
            if ((i - right + 1) % wordLength == 0) {
                String substring = s.substring(right, i + 1);
                if (countMap.getOrDefault(substring, 0) > 0) {
                    count--;
                    countMap.put(substring, countMap.get(substring) - 1);
                }
                right = i;
            }
        }
        while (right < s.length()) {

            if (count == 0) {
                result.add(left);
            }
            // 一次性减少wordLength

        }
        return result;
    }

    public static void main(String[] args) {
        FindSubstring findSubstring = new FindSubstring();
        List<Integer> result = findSubstring.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
        System.out.println(result);
    }

}
