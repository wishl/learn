package com.gmy.leetcode.review;

import com.gmy.leetcode.prefix.Trie;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for (String str : strs) {
            trie.insert(str);
        }
        String result = trie.get(strs.length);
        return result;
    }

    static class Trie {

        private Trie[] tires;
        private int count;
        private List<Integer> indexes;

        public Trie() {
            tires = new Trie[26];
            count = 0;
            indexes = new ArrayList<>();
        }

        public void insert(String word) {
            Trie trie = this;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - 'a';
                if (trie.tires[index] == null) {
                    trie.tires[index] = new Trie();
                    trie.indexes.add(index);
                }
                trie.count++;
                trie = trie.tires[index];
            }
        }

        public String get(int total) {
            StringBuilder builder = new StringBuilder();
            Trie trie = this;
            while (trie != null && trie.indexes.size() == 1) {
                if (trie.count == total) {
                    Integer index = trie.indexes.get(0);
                    char c = (char) (index + 'a');
                    builder.append(c);
                    trie = trie.tires[index];
                } else {
                    break;
                }
            }
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String s = longestCommonPrefix.longestCommonPrefix(new String[]{"flower", "flow", "flight", ""});
        System.out.println(s);
    }

}
