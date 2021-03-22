package com.gmy.leetcode.review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindRepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        int start = 0, end = 10;
        Map<String, Integer> cache = new HashMap<>();
        while (end <= s.length()) {
            String substring = s.substring(start, end);
            cache.put(substring, cache.getOrDefault(substring, 0) + 1);
            start++;
            end++;
            if (cache.get(substring) == 2) {
                ans.add(substring);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindRepeatedDnaSequences findRepeatedDnaSequences = new FindRepeatedDnaSequences();
        List<String> result = findRepeatedDnaSequences.findRepeatedDnaSequences("AAAAAAAAAAA");
        System.out.println(result);
    }
}
