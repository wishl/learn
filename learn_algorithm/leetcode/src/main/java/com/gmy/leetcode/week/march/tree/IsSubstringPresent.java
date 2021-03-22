package com.gmy.leetcode.week.march.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s ，请你判断字符串 s 是否存在一个长度为 2 的子字符串，在其反转后的字符串中也出现。
 *
 * 如果存在这样的子字符串，返回 true；如果不存在，返回 false 。
 *
 */
public class IsSubstringPresent {

    /**
     * 字典树解法，搞个数组持有所有trie对象，然后从后往前计算
     * @param s
     * @return
     */
    public boolean isSubstringPresent(String s) {
        TireHold tireHold = new TireHold(s);
        return tireHold.contains(s);
    }

    static class TireHold {

        private Trie trie;

        private List<Trie>[] tries;

        public TireHold(String word) {
            this.tries = new List[26];
            this.trie = new Trie();
            trie.insert(word, tries);
        }

        public boolean contains(String word) {
            char[] charArray = word.toCharArray();
            for (int i = charArray.length - 2; i >= 0; i--) {
                int index = charArray[i + 1] - 'a';
                char c = charArray[i];
                for (Trie trie : tries[index]) {
                    if (trie.isContains(c)) {
                        return true;
                    }
                }
            }
            return false;
        }

    }

    static class Trie {

        private Trie[] tries;

        public Trie() {
            this.tries = new Trie[26];
        }

        public void insert(String s, List<Trie>[] tires) {
            Trie trie = this;
            for (char c : s.toCharArray()) {
                int index = c - 'a';
                if (trie.tries[index] == null) {
                    trie.tries[index] = new Trie();
                    trie = trie.tries[index];
                }
                if (tires[index] == null) {
                    tires[index] = new ArrayList<>();
                }
                tires[index].add(trie);
            }
        }

        public boolean isContains(char c) {
            return tries[c - 'a'] != null;
        }
    }

    public static void main(String[] args) {
        IsSubstringPresent isSubstringPresent = new IsSubstringPresent();
        boolean result = isSubstringPresent.isSubstringPresent("abcdabcd");
        System.out.println(result);
    }
}
