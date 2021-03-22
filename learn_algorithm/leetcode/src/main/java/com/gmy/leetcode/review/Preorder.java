package com.gmy.leetcode.review;

import java.util.ArrayList;
import java.util.List;

public class Preorder {

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, result);
        return result;
    }

    private void dfs(Node root, List<Integer> result) {
        result.add(root.val);
        if (root.children == null) {
            return;
        }
        for (int i = 0; i < root.children.size(); i++) {
            dfs(root.children.get(i), result);
        }
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {

    }

}
