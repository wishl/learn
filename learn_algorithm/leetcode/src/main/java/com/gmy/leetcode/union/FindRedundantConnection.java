package com.gmy.leetcode.union;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 树可以看成是一个连通且 无环的无向图。
 *
 * 给定往一棵n 个节点 (节点值1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n中间，且这条附加的边不属于树中已存在的边。图的信息记录于长度为 n 的二维数组 edges，edges[i] = [ai, bi]表示图中在 ai 和 bi 之间存在一条边。
 *
 * 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组edges中最后出现的边。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/redundant-connection
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 创建个并查集，根据edges中的顺序连接 & 压缩，判断已经链接过定点的就是最后一个
 *
 */
public class FindRedundantConnection {

    /**
     * 并查集解法
     * @param edges
     * @return
     */
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        for (int i = 1; i <= edges.length; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            boolean already = union(edge[0], edge[1], parent);
            if (already) {
                return edge;
            }
        }
        return null;
    }

    private boolean union(int x, int y, int[] parents) {
        int parentX = find(x, parents);
        int parentY = find(y, parents);
        if (parentX == parentY) {
            return true;
        } else {
            parents[parentY] = parentX;
            return false;
        }
    }

    private int find(int x, int[] parent) {
        if (x != parent[x]) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }

    public static void main(String[] args) {
        FindRedundantConnection findRedundantConnection = new FindRedundantConnection();
        int[] result = findRedundantConnection.findRedundantConnection(new int[][]{{2,1}, {3,1}, {4,2}, {1,4}});
        System.out.println(Arrays.toString(result));
    }
}
