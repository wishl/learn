package com.gmy.leetcode.graph;

import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 迪杰斯特拉算法
 * 详解：https://www.zhihu.com/search?type=content&q=%E8%BF%AA%E6%9D%B0%E6%96%AF%E7%89%B9%E6%8B%89
 */
public class Dijkstra {

    private int[][] around = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    /**
     * 从start节点到end节点的最短路径
     * @param start
     * @param end
     * @return
     */
    public int dijkstra(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        int[][] s = new int[n][n];
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> grid[o[0]][o[1]]));
        s[0][0] = grid[0][0];
        queue.offer(grid[0]);
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];
            for (int[] ints : around) {
                int newX = currentX + ints[0];
                int newY = currentY + ints[1];
//                if () {
//
//                }
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(1);
        queue.offer(1);
        System.out.println(queue.size());
    }

}
