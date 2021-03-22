package com.gmy.leetcode.prefix;

import com.gmy.leetcode.string.TireReview;

/**
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 *
 * 请你实现 Trie 类：
 *
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/QC3q1f
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Trie {

    private boolean end;
    private Trie[] tries;

    /** Initialize your data structure here. */
    public Trie() {
        this.tries = new Trie[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie trie = this;
        int length = word.length();
        for (int i = 0; i < length; i++) {
            int index = word.charAt(i) - 'a';
            if (trie.tries[index] == null) {
                trie.tries[index] = new Trie();
            }
            if (i == length - 1) {
                trie.tries[index].end = true;
            }
            trie = trie.tries[index];
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie trie = find(word);
        return trie != null && trie.end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private Trie find(String word) {
        Trie trie = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (trie.tries[index] == null) {
                return null;
            }
            trie = trie.tries[index];
        }
        return trie;
    }


    public static void main(String[] args) {
        Trie tire = new Trie();
        tire.insert("apple");
        System.out.println(tire.search("apple"));
        System.out.println(tire.search("app"));
        System.out.println(tire.startsWith("app"));
        tire.insert("app");
        System.out.println(tire.search("app"));
    }

}
