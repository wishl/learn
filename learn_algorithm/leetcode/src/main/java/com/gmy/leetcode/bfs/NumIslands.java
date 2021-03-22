package com.gmy.leetcode.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 除了传统bfs，dfs获取结果外 还有最优雅的并查集，明天研究~
 */
public class NumIslands {

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int innerLength = visited[0].length;
        int count = 0;
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < innerLength; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i == visited.length || j == visited[0].length || visited[i][j] || grid[i][j] != '1') {
            return;
        }
        visited[i][j] = true;
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i, j + 1);
        dfs(grid, visited, i, j - 1);
    }

    public int numIslands1(char[][] grid) {
        int[] move = new int[]{1, -1};
        int count = 0;
        int innerLength = grid[0].length;
        boolean[][] visited = new boolean[grid.length][innerLength];
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < innerLength; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    deque.offer(new int[]{i, j});
                    visited[i][j] = true;
                    count++;
                }
                while (!deque.isEmpty()) {
                    int[] poll = deque.poll();
                    for (int i1 = 0; i1 < move.length; i1++) {
                        int i2 = poll[0] + move[i1];
                        if (i2 >= 0 && i2 < grid.length && grid[i2][poll[1]] == '1' && !visited[i2][poll[1]]) {
                            visited[i2][poll[1]] = true;
                            deque.offer(new int[] {i2, poll[1]});
                        }
                        int j2 = poll[1] + move[i1];
                        if (j2 >= 0 && j2 < innerLength && grid[poll[0]][j2] == '1' && !visited[poll[0]][j2]) {
                            visited[poll[0]][j2] = true;
                            deque.offer(new int[] {poll[0], j2});
                        }
                    }
                }
            }
        }
        return count;
    }

    class UnionFind {
        int count;
        int[] parent;
        int[] rank;

        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        ++count;
                    }
                    rank[i * n + j] = 0;
                }
            }
        }

        public int find(int i) {
            if (parent[i] != i) parent[i] = find(parent[i]);
            return parent[i];
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = rootx;
                    rank[rootx] += 1;
                }
                --count;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        UnionFind uf = new UnionFind(grid);
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
                    if (r - 1 >= 0 && grid[r-1][c] == '1') {
                        uf.union(r * nc + c, (r-1) * nc + c);
                    }
                    if (r + 1 < nr && grid[r+1][c] == '1') {
                        uf.union(r * nc + c, (r+1) * nc + c);
                    }
                    if (c - 1 >= 0 && grid[r][c-1] == '1') {
                        uf.union(r * nc + c, r * nc + c - 1);
                    }
                    if (c + 1 < nc && grid[r][c+1] == '1') {
                        uf.union(r * nc + c, r * nc + c + 1);
                    }
                }
            }
        }

        return uf.getCount();
    }

    public static void main(String[] args) {
        NumIslands numIslands = new NumIslands();
        char[][] grid = new char[][] {{'1','1','1'}, {'0','1','0'}, {'1','1','1'}};
        int result = numIslands.numIslands2(grid);
        System.out.println(result);
    }

}
