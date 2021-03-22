package com.gmy.leetcode.string;

import java.util.stream.IntStream;

public class TireReview2 {

    private TireReview2[] child;
    private boolean isEnd;

    public TireReview2() {
        this.child = new TireReview2[26];
    }

    public void insert(String value) {
        if (value == null) {
            return;
        }
        TireReview2 node = this;
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            int index = c - 'a';
            if (node.child[index] == null) {
                node.child[index] = new TireReview2();
            }
            node = node.child[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        TireReview2 node = searchTrie(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String word) {
        if (word == null) {
            return false;
        }
        TireReview2 node = searchTrie(word);
        return node != null;
    }

    private TireReview2 searchTrie(String prefix) {
        TireReview2 node = this;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.child[index] == null) {
                return null;
            }
            node = node.child[index];
        }
        return node;
    }

    public static void main(String[] args) {
        TireReview2 trie = new TireReview2();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
