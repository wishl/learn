package com.gmy.leetcode.week.contest.one;

import java.util.Arrays;

/**
 * 给你两个字符串数组 wordsContainer 和 wordsQuery 。
 * 对于每个 wordsQuery[i] ，你需要从 wordsContainer 中找到一个与 wordsQuery[i] 有 最长公共后缀 的字符串。如果 wordsContainer 中有两个或者更多字符串有最长公共后缀，那么答案为长度 最短 的。如果有超过两个字符串有 相同 最短长度，那么答案为它们在 wordsContainer 中出现 更早 的一个。
 * 请你返回一个整数数组 ans ，其中 ans[i]是 wordsContainer中与 wordsQuery[i] 有 最长公共后缀 字符串的下标。
 */
public class StringIndices {

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int[] result = new int[wordsQuery.length];
        Trie trie = new Trie();
        for (int i = 0; i < wordsContainer.length; i++) {
            String s = wordsContainer[i];
            trie.insert(s, i);
        }
        for (int i = 0; i < wordsQuery.length; i++) {
            int maxSub = trie.getMaxSub(wordsQuery[i]);
            result[i] = maxSub;
        }
        return result;
    }

    static class Trie {

        private Trie[] tries;
        private Integer minLength;
        private Integer minIndex;

        public Trie() {
            tries = new Trie[26];
            minLength = Integer.MAX_VALUE;
        }

        public void insert(String s, int index) {
            char[] charArray = s.toCharArray();
            Trie trie = this;
            // 如果没有公共后缀
            if (s.length() < trie.minLength) {
                trie.minLength = s.length();
                trie.minIndex = index;
            }
            for (int i = charArray.length - 1; i >= 0; i--) {
                char c = charArray[i];
                int cIndex = c - 'a';
                if (trie.tries[cIndex] == null) {
                    trie.tries[cIndex] = new Trie();
                }
                trie = trie.tries[cIndex];
                if (s.length() < trie.minLength) {
                    trie.minLength = s.length();
                    trie.minIndex = index;
                }
            }

        }

        /**
         * 最长公共后缀
         * @return
         */
        public int getMaxSub(String s) {
            char[] charArray = s.toCharArray();
            Trie trie = this;
            for (int i = charArray.length - 1; i >= 0; i--) {
                char c = charArray[i];
                if (trie.tries[c - 'a'] != null) {
                    trie = trie.tries[c - 'a'];
                } else {
                    break;
                }
            }
            return trie.minIndex;
        }
    }

    public static void main(String[] args) {
        StringIndices stringIndices = new StringIndices();
        String[] wordsContainer = new String[] {"abcde","abcde"};
        String[] wordsQuery = new String[] {"abcde","bcde","cde","de","e"};
        int[] result = stringIndices.stringIndices(wordsContainer, wordsQuery);
        System.out.println(Arrays.toString(result));
    }

}
