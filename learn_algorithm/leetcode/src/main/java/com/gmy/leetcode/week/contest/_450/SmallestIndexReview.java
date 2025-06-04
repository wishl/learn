package com.gmy.leetcode.week.contest._450;

import java.util.*;

public class SmallestIndexReview {

    private static final int[][] DIRS = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int minMoves(String[] matrix) {
        int m = matrix.length, n = matrix[0].length();
        if (matrix[m - 1].charAt(n - 1) == '#') {
            return -1;
        }

        List<int[]>[] pos = new ArrayList[26];
        Arrays.setAll(pos, i -> new ArrayList<>());
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = matrix[i].charAt(j);
                if (Character.isUpperCase(c)) {
                    pos[c - 'A'].add(new int[]{i, j});
                }
            }
        }

        int[][] dis = new int[m][n];
        for (int[] row : dis) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dis[0][0] = 0;

        Deque<int[]> q = new ArrayDeque<>();
        q.addFirst(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] p = q.pollFirst();
            int x = p[0], y = p[1];
            int d = dis[x][y];

            if (x == m - 1 && y == n - 1) {
                return d;
            }

            char c = matrix[x].charAt(y);
            if (c != '.') {
                // 使用所有传送门
                for (int[] portal : pos[c - 'A']) {
                    int px = portal[0], py = portal[1];
                    if (d < dis[px][py]) {
                        dis[px][py] = d;
                        q.addFirst(new int[]{px, py});
                    }
                }
                pos[c - 'A'].clear(); // 避免重复使用传送门
            }

            // 下面代码和普通 BFS 是一样的
            for (int[] dir : DIRS) {
                int nx = x + dir[0], ny = y + dir[1];
                if (0 <= nx && nx < m && 0 <= ny && ny < n && matrix[nx].charAt(ny) != '#' && d + 1 < dis[nx][ny]) {
                    dis[nx][ny] = d + 1;
                    q.addLast(new int[]{nx, ny});
                }
            }
        }

        return -1;
    }

}
