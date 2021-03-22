package com.gmy.leetcode.string;

/**
 * 前缀树review
 */
public class TireReview {

    private TireReview[] child;
    private boolean isEnd;

    public TireReview() {
        this.child = new TireReview[26];
        this.isEnd = false;
    }

    public void insert(String word) {
        TireReview node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.child[index] == null) {
                node.child[index] = new TireReview();
            }
            node = node.child[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TireReview node = searchTire(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TireReview node = searchTire(prefix);
        return node != null;
    }

    private TireReview searchTire(String word) {
        TireReview node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.child[index] == null) {
                return null;
            }
            node = node.child[index];
        }
        return node;
    }

    public static void main(String[] args) {
        TireReview trie = new TireReview();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
