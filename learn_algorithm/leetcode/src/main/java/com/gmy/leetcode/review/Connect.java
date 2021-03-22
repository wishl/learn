package com.gmy.leetcode.review;

import com.gmy.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/solutions/446938/tian-chong-mei-ge-jie-dian-de-xia-yi-ge-you-ce-2-4/
 */
public class Connect {

    /**
     * bfs解法
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        // 1. 平铺
        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Node pop = deque.pop();
                if (i < size - 1) {
                    pop.next = deque.peek();
                }
                if (pop.left != null) {
                    deque.offer(pop.left);
                }
                if (pop.right != null) {
                    deque.offer(pop.right);
                }
            }
        }
        return root;
    }

    /**
     * 遍历解法 横着走
     * @param root
     * @return
     */
    public Node connect1(Node root) {
        if (root == null) {
            return root;
        }

        // 从根节点开始
        Node leftmost = root;

        while (leftmost.left != null) {

            // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
            Node head = leftmost;

            while (head != null) {

                // CONNECTION 1
                head.left.next = head.right;

                // CONNECTION 2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                // 指针向后移动
                head = head.next;
            }

            // 去下一层的最左的节点
            leftmost = leftmost.left;
        }

        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        public static Node build(Integer[] is) {
            Queue<Node> queue = new LinkedBlockingDeque<>();
            Node root = new Node(is[0]);
            queue.offer(root);
            for (int i = 0; i < is.length; i++) {
                Node poll = queue.poll();
                for (int j = 2 * i + 1; j < 2 * i + 3 && j < is.length; j++) {
                    Integer num = is[j];
                    if (num == null) {
                        continue;
                    }
                    Node node = new Node(num);
                    queue.offer(node);
                    if (j == 2 * i + 1 ) {
                        poll.left = node;
                    } else {
                        poll.right = node;
                    }
                }

            }
            return root;
        }
    }

    public static void main(String[] args) {
        Node build = Node.build(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        Connect connect = new Connect();
        Node result = connect.connect(build);
        System.out.println(result);
        Node result1 = connect.connect1(build);
        System.out.println(result1);
    }

}
