package com.gmy.leetcode.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 */
public class _0049_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> bitMapCache = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            int[] cs = new int[26];
            for (int i = 0; i < charArray.length; i++) {
                int index = charArray[i] - 'a';
                cs[index]++;
            }
            String bitKey = Arrays.toString(cs);
            List<String> list = bitMapCache.getOrDefault(bitKey, new ArrayList<>());
            list.add(str);
            bitMapCache.put(bitKey, list);
        }
        List<List<String>> result = bitMapCache.entrySet().stream()
            .map(Map.Entry::getValue)
            .collect(Collectors.toList());
        return result;
    }

    static class BitKey {


        private Character character;

        private Integer length;


    }

    public static void main(String[] args) {
        _0049_GroupAnagrams groupAnagrams = new _0049_GroupAnagrams();
        List<List<String>> result = groupAnagrams.groupAnagrams(new String[]{"ddddddddddg","dgggggggggg"});
        System.out.println(result);
    }

}
