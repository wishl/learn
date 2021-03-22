package com.gmy.leetcode.union;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 *
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 *
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 *
 * 返回矩阵中 省份 的数量。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-provinces
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindCircleNum {

    private int count;

    public int findCircleNum2(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        this.count = 0;
        dfs(visited, isConnected, 0, 0);
        return this.count;
    }

    private void dfs(boolean[] visited, int[][] isConnect, int i, int j) {
        if (i == isConnect.length || j == isConnect.length) {
            return;
        }
        if (!visited[j] && isConnect[i][j] == 1) {
            visited[j] = true;
            count++;
        }
        dfs(visited, isConnect, i, j + 1);
        dfs(visited, isConnect, i + 1, j);
    }

    /**
     * bfs判断
     * @param isConnected
     * @return
     */
    public int findCircleNum1(int[][] isConnected) {
        int provinces = isConnected.length;
        boolean[] visited = new boolean[provinces];
        int circles = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < provinces; i++) {
            if (!visited[i]) {
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int j = queue.poll();
                    visited[j] = true;
                    for (int k = 0; k < provinces; k++) {
                        if (isConnected[j][k] == 1 && !visited[k]) {
                            queue.offer(k);
                        }
                    }
                }
                circles++;
            }
        }
        return circles;
    }

    /**
     * 并查集
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        int innerLength = isConnected[0].length;
        UnionFind unionFind = new UnionFind(innerLength);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < innerLength; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.getCount();
    }

    class UnionFind {

        int[] parent;
        int count;
        int[] rank;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            if (parentX != parentY) {
                // 小的并入大的里
                if (rank[parentX] > rank[parentY]) {
                    parent[parentY] = parentX;
                } else if (rank[parentX] < rank[parentY]) {
                    parent[parentX] = parentY;
                } else {
                    parent[parentX] = parentY;
                    rank[parentX]++;
                }
                // 合并之后count--
                count--;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public int getCount() {
            return this.count;
        }

    }

    public static void main(String[] args) {
        int[][] isConnect = new int[][] {{1,1,0}, {1,1,0}, {0,0,1}};
        FindCircleNum findCircleNum = new FindCircleNum();
        int result = findCircleNum.findCircleNum1(isConnect);
        System.out.println(result);
    }

}
