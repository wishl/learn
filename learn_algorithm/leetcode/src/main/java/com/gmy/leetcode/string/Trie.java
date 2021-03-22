package com.gmy.leetcode.string;

/**
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，
 * 用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Trie {

//    private Trie[] child;
//    private boolean isEnd;
//
//    public Trie() {
//        this.child = new Trie[26];
//        this.isEnd = false;
//    }
//
//    public void insert(String word) {
//        Trie node = this;
//        for (int i = 0; i < word.length(); i++) {
//            char c = word.charAt(i);
//            int index = c - 'a';
//            if (node.child[index] == null) {
//                node.child[index] = new Trie();
//            }
//            node = node.child[index];
//        }
//        node.isEnd = true;
//    }
//
//    public boolean search(String word) {
//        Trie trie = searchPrefix(word);
//        return trie != null && trie.isEnd;
//    }
//
//    public boolean startsWith(String prefix) {
//        Trie trie = searchPrefix(prefix);
//        return trie != null;
//    }
//
//    private Trie searchPrefix(String prefix) {
//        Trie node = this;
//        for (int i = 0; i < prefix.length(); i++) {
//            char c = prefix.charAt(i);
//            int index = c - 'a';
//            if (node.child[index] == null) {
//                return null;
//            }
//            node = node.child[index];
//        }
//        return node;
//    }

    private Trie[] child;
    private boolean isEnd;

    public Trie() {
        this.child = new Trie[26];
        this.isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.child[index] == null) {
                node.child[index] = new Trie();
            }
            node = node.child[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchTire(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie node = searchTire(prefix);
        return node != null;
    }

    private Trie searchTire(String word) {
        Trie node = this;
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
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }


}
