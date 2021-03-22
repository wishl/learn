package com.gmy.leetcode.bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class MaxDeepN {

    public int maxDepth(Node root) {
        int result = 0;
        if (root == null) {
            return result;
        }
        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            result++;
            for (int i = 0; i < size; i++) {
                List<Node> children = deque.pop().children;
                if (children == null) {
                    continue;
                }
                deque.addAll(children);
            }
        }
        return result;
    }

    class Node {
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

}
