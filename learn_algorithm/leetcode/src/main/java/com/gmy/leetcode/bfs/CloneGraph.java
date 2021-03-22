package com.gmy.leetcode.bfs;

import com.gmy.leetcode.graph.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 *
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 */
public class CloneGraph {

    private Map<Node, Node> complete = new HashMap<>();

    public Node cloneGraph(Node node) {
        Deque<Node> deque = new ArrayDeque<>();
        if (node == null) {
            return null;
        }
        complete.put(node, copy(node));
        deque.offer(node);
        while (!deque.isEmpty()) {
            Node poll = deque.poll();
            Node copy = copy(poll);
            for (Node neighbor : poll.neighbors) {
                Node neighborCopy = copy(neighbor);
                copy.neighbors.add(neighborCopy);
                if (!complete.containsKey(neighbor)) {
                    deque.offer(neighbor);
                }
                complete.put(neighbor, neighborCopy);
            }

        }
        return complete.get(node);
    }

    private Node copy(Node node) {
        if (complete.get(node) != null) {
            return complete.get(node);
        }
        Node copy = new Node(node.val);
        return copy;
    }

    private static void safeAdd(Node head, Node... nextNode) {
        head.neighbors = Arrays.asList(nextNode);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        safeAdd(node1, node2, node4);
        safeAdd(node2, node1, node3);
        safeAdd(node3, node2, node4);
        safeAdd(node4, node1, node3);
        CloneGraph cloneGraph = new CloneGraph();
        Node node = cloneGraph.cloneGraph(node1);
        System.out.println(node);
    }

}
