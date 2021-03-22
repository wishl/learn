package com.gmy.leetcode.union;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 在一个 N x N 的坐标方格grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。
 * 现在开始下雨了。当时间为t时，此时雨水导致水池中任意位置的水位为t。
 * 你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两个平台。
 * 假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。
 * 你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台(N-1, N-1)？ 水面高度不会重复
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swim-in-rising-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 三种解法：双向dfs/bfs & 并查集模拟 & 迪杰斯特拉算法 今儿都学一遍
 */
public class SwimInWater {

    private int N;
    private int[] parent;
    private int[][] around = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


    /**
     * 并查集因为是以水位高度为索引，所以如果出现水位高度一致的情况处理起来比较麻烦，可以使用Dijkstra算法
     * 计算最小距离，并返回其中权重最大的点
     * Dijkstra 算法详解：https://www.zhihu.com/search?type=content&q=%E8%BF%AA%E6%9D%B0%E6%96%AF%E7%89%B9%E6%8B%89
     * @param grid
     * @return
     */
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> grid[o[0]][o[1]]));
        minHeap.offer(new int[]{0, 0});

        boolean[][] visited = new boolean[n][n];
        // distTo[i][j] 表示：到顶点 [i, j] 须要等待的最少的时间
        int[][] distTo = new int[n][n];
        for (int[] row : distTo) {
            Arrays.fill(row, n * n);
        }
        distTo[0][0] = grid[0][0];

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!minHeap.isEmpty()) {
            // 找最短的边
            int[] front = minHeap.poll();
            int currentX = front[0];
            int currentY = front[1];
            if (visited[currentX][currentY]) {
                continue;
            }

            // 确定最短路径顶点
            visited[currentX][currentY] = true;
            if (currentX == n - 1 && currentY == n - 1) {
                return distTo[n - 1][n - 1];
            }

            // 更新
            for (int[] direction : directions) {
                int newX = currentX + direction[0];
                int newY = currentY + direction[1];
                if (checkIndex(newX, newY) && !visited[newX][newY] &&
                        Math.max(distTo[currentX][currentY], grid[newX][newY]) < distTo[newX][newY]) {
                    distTo[newX][newY] = Math.max(distTo[currentX][currentY], grid[newX][newY]);
                    minHeap.offer(new int[]{newX, newY});
                }
            }
        }
        return -1;
    }

    /**
     * 并查集方法
     * 模拟水位增长，并把灌满的相邻格子相连，然后判断是否连通，如果是 则返回结果
     * @param grid
     * @return
     */
    public int swimInWater1(int[][] grid) {
        N = grid.length;
        parent = new int[N * N];
        // indexMap 下标 为水位高度，值为 编码的index
        int[] indexMap = new int[parent.length];
        // parent 下标为水位线，值为grid的index,因为不会重复，所有并查集可以完成计算
        for (int i = 0; i < N; i++) {
            int[] inner = grid[i];
            for (int j = 0; j < inner.length; j++) {
                int index = getIndex(i, j);
                parent[index] = index;
                indexMap[grid[i][j]] = index;
            }
        }
        for (int i = 0; i < parent.length; i++) {
            // i == 当前水位线，calIndex == 压缩过的index
            // x == 压缩前的横坐标 y == 压缩后的纵坐标
            int calIndex = indexMap[i];
            int x = calIndex / N;
            int y = calIndex % N;
            for (int[] ints : around) {
                int newX = x + ints[0];
                int newY = y + ints[1];
                int newCalIndex = getIndex(newX, newY);
                // 如果相邻的灌满了 则链接
                if (checkIndex(newX, newY) && grid[newX][newY] <= i) {
                    union(calIndex, newCalIndex);
                }
                // 如果只有 一个元素 只能等当前元素满了之后
                if (isConnect(getIndex(0, 0), getIndex(N - 1, N - 1))) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 压缩二维数组到一维
     */
    private int getIndex(int x, int y) {
        return x * N + y;
    }

    private boolean checkIndex(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < N) {
            return true;
        }
        return false;
    }

    private void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        // 把 Y 放到 X 下
        if (parentX != parentY) {
            parent[parentY] = parentX;
        }
    }

    /**
     * 判断是否链接 成功
     * @return
     */
    private boolean isConnect(int x, int y) {
        return find(x) == find(y);
    }

    /**
     * 查找parent节点 & 压缩
     * @param x
     * @return
     */
    private int find(int x) {
        if (x == -2) {
            System.out.println(111);
        }
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }


    public static void main(String[] args) {
        SwimInWater swimInWater = new SwimInWater();
        int[][] param = new int[][] {{0}};
        int result = swimInWater.swimInWater(param);
        System.out.println(result);
    }

}
