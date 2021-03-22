package com.gmy.leetcode.union;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。
 * 一次交换可选择任意两人，让他们站起来交换座位。
 * 人和座位用0到2N-1的整数表示，情侣们按顺序编号，第一对是(0, 1)，第二对是(2, 3)，以此类推，最后一对是(2N-2, 2N-1)。
 * 这些情侣的初始座位row[i]是由最初始坐在第 i 个座位上的人决定的。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/couples-holding-hands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 官方解题：https://leetcode-cn.com/problems/couples-holding-hands/solution/qing-lu-qian-shou-by-leetcode-gl1c/
 */
public class MinSwapsCouples {

    public int minSwapsCouples(int[] row) {
        int[] parent = new int[row.length];
        Map<Integer, Integer> coupleIndex = new HashMap<>();
        for (int i = 0; i < row.length; i++) {
            parent[i] = i;
            coupleIndex.put(row[i], i);
        }
        for (int i = 0; i < row.length; i++) {
            // 坐在这儿的人需要 跟本来要牵手的人连接 & 坐在自己边儿上的人连接
            // 如果坐row[i] 是奇数 则需要跟 row[i] - 1 连接 否则 需要跟 row[i] + 1 链接
            // 优化：因为 row[i]
            if (row[i] % 2 == 1) {
                union(parent, i, coupleIndex.get(row[i] - 1));
            } else {
                union(parent, i, coupleIndex.get(row[i] + 1));
            }
            if (i % 2 == 0) {
                union(parent, i, i + 1);
            }
        }
        int part = 0;
        System.out.println(Arrays.toString(parent));
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) {
                part++;
            }
        }
        return row.length / 2 - part;
    }

    private void union(int[] parent, int x, int y) {
        int parentX = find(parent, x);
        int parentY = find(parent, y);
        if (parentX != parentY) {
            parent[parentY] = parentX;
        }
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    public static void main(String[] args) {
        int[] ints = new int[] {5,6,4,0,2,1,9,3,8,7,11,10};
        MinSwapsCouples minSwapsCouples = new MinSwapsCouples();
        System.out.println(minSwapsCouples.minSwapsCouples(ints));
    }

    /**
     * 优化：因为 0， 1 是情侣 所以 row[i] / 2 == row[i + 1] / 2
     * 只需要链接需要更换的座位就可以了
     */
    public int minSwapsCouples1(int[] row) {
        int len = row.length;
        int N = len / 2;
        UnionFind unionFind = new UnionFind(N);
        for (int i = 0; i < len; i += 2) {
            unionFind.union(row[i] / 2, row[i + 1] / 2);
        }
        return N - unionFind.getCount();
    }

    private class UnionFind {

        private int[] parent;

        private int count;

        public int getCount() {
            return count;
        }

        public UnionFind(int n) {
            this.count = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            parent[rootX] = rootY;
            count--;
        }
    }

}
