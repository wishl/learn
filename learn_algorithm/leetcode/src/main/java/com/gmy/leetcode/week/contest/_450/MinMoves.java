package com.gmy.leetcode.week.contest._450;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个大小为 m x n 的二维字符网格 matrix，用字符串数组表示，其中 matrix[i][j] 表示第 i 行和第 j 列处的单元格。每个单元格可以是以下几种字符之一：
 * '.' 表示一个空单元格。
 * '#' 表示一个障碍物。
 * 一个大写字母（'A' 到 'Z'）表示一个传送门。
 * 你从左上角单元格 (0, 0) 出发，目标是到达右下角单元格 (m - 1, n - 1)。你可以从当前位置移动到相邻的单元格（上、下、左、右），移动后的单元格必须在网格边界内且不是障碍物。
 * 如果你踏入一个包含传送门字母的单元格，并且你之前没有使用过该传送门字母，你可以立即传送到网格中另一个具有相同字母的单元格。这次传送不计入移动次数，但每个字母对应的传送门在旅程中 最多 只能使用一次。
 *
 * 返回到达右下角单元格所需的 最少 移动次数。如果无法到达目的地，则返回 -1。
 *
 * A..
 * .A.
 * ...
 */
public class MinMoves {

    private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    private int xMax;
    private int yMax;

    public int minMoves(String[] matrix) {
        // 传送门
        Map<Character, List<Node>> map = new HashMap<>();
        Character[][] characters = new Character[matrix.length][matrix[0].length()];
        xMax = matrix.length;
        yMax = matrix[0].length();
        for (int i = 0; i < matrix.length; i++) {
            String string = matrix[i];
            for (int j = 0; j < string.length(); j++) {
                char c = string.charAt(j);
                characters[i][j] = c;
                if (c >= 'A' && c <= 'Z') {
                    map.computeIfAbsent(c, k -> new ArrayList<>()).add(new Node(i, j));
                }
            }
        }
        return bfs(characters, map);
    }

    /**
     * .#...
     * .#.#.
     * .#.#.
     * ...#.
     * @param matrix
     * @param map
     * @return
     */
    private int bfs(Character[][] matrix, Map<Character, List<Node>> map) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node(-1, 0));
        for (int i = 0; !nodes.isEmpty(); i++) {
            List<Node> tmp = nodes;
            nodes = new ArrayList<>();
            for (Node node : tmp) {
                if (node.getX() == xMax - 1 && node.getY() == yMax - 1) {
                    return i - 1;
                }
                for (int[] dir : DIRS) {
                    int x = node.getX() + dir[0];
                    int y = node.getY() + dir[1];
                    if (x < 0 || y < 0 || x >= xMax || y >= yMax || matrix[x][y] == '#' || node.contains(x, y)) {
                        continue;
                    }
                    // 没走过传送门尝试走一遍
                    Character c = matrix[x][y];
                    if (c >= 'A' && c <= 'Z' && !node.getCs().contains(c)) {
                        // 如果是传送门，则尝试走一次
                        List<Node> nodes1 = map.get(c);
                        // 传送门的另一个出口
                        List<Node> otherNodes = nodes1.stream()
                                .filter(n -> n.getX() != x || n.getY() != y)
                                .collect(Collectors.toList());
                        for (Node otherNode : otherNodes) {
                            Node newNode = new Node(otherNode.getX(), otherNode.getY(), node);
                            newNode.getCs().add(c);
                            // 直接跳过来 不算步数
                            nodes.add(newNode);
                            // 如果正好调到结束则直接返回结果
                            if (newNode.getX() == xMax - 1 && newNode.getY() == yMax - 1) {
                                return i;
                            }
                        }
                    }
                    Node newNode = new Node(x, y, node);
                    newNode.add(x, y);
                    nodes.add(newNode);
                }
            }
        }
        return -1;
    }

    static class Node {

        private Set<String> set;
        private int x;
        private int y;
        private Set<Character> cs = new HashSet<>();

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.set = new HashSet<>();
            this.cs = new HashSet<>();
            this.add(x, y);
        }

        public Node(int x, int y, Node parent) {
            this.x = x;
            this.y = y;
            this.set = parent.getSet();
            this.cs = parent.getCs();
            this.add(x, y);
        }

        public Set<String> getSet() {
            return set;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Set<Character> getCs() {
            return cs;
        }

        public boolean contains(int x, int y) {
            return this.set.contains(x + "_" + y);
        }

        private void add(int x, int y) {
            this.set.add(x + "_" + y);
        }
    }

    public static void main(String[] args) {
        MinMoves minMoves = new MinMoves();
        String[] matrix = new String[]{".A.","BA.","B.A"};
        System.out.println(minMoves.minMoves(matrix));
    }


}
