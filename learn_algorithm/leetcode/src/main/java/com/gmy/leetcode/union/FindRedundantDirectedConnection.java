package com.gmy.leetcode.union;

import java.util.Arrays;

/**
 * 在本问题中，有根树指满足以下条件的 有向 图。该树只有一个根节点，所有其他节点都是该根节点的后继。该树除了根节点之外的每一个节点都有且只有一个父节点，而根节点没有父节点。
 * 输入一个有向图，该图由一个有着 n 个节点（节点值不重复，从 1 到 n）的树及一条附加的有向边构成。附加的边包含在 1 到 n 中的两个不同顶点间，这条附加的边不属于树中已存在的边。
 * 结果图是一个以边组成的二维数组 edges 。 每个元素是一对 [ui, vi]，用以表示 有向 图中连接顶点 ui 和顶点 vi 的边，其中 ui 是 vi 的一个父节点。
 * 返回一条能删除的边，使得剩下的图是有 n 个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/redundant-connection-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 先判断是否有节点 拥有两个parent 再判断是否有节点是否有环，如果一条边满足其中一个条件则结果是这条边，
 * 如果都满足 则 返回该子节点的另一条边（因为根节点再图中不能被指向）
 *
 * 不仅不能压缩，parent 也只能指向上一层
 */
public class FindRedundantDirectedConnection {

    private Integer conflictIndex;
    private Integer circleIndex;

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int length = edges.length;
        int[] parent = new int[length + 1];
        for (int i = 1; i <= edges.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < length; i++) {
            int[] edge = edges[i];
            union(edge[0], edge[1], parent, i);
        }
        if (conflictIndex != null && circleIndex != null) {
            int y = edges[conflictIndex][1];
            int x = parent[y];
            return new int[] {x, y};
        } else if (conflictIndex != null) {
            return edges[conflictIndex];
        } else if (circleIndex != null) {
            return edges[circleIndex];
        }
        return null;
    }

    private void union(int x, int y, int[] parent, int index) {
        int parentX = find(x, parent);
        int parentY = find(y, parent);
        if (parentY != y) {
            conflictIndex = index;
            return;
        }
        if (parentX != parentY) {
            parent[y] = x;
        } else {
            circleIndex = index;
        }
    }

    private int find(int x, int[] parent) {
        if (x != parent[x]) {
            return find(parent[x], parent);
        }
        return parent[x];
    }


    public static void main(String[] args) {
        FindRedundantDirectedConnection findRedundantDirectedConnection = new FindRedundantDirectedConnection();
        int[][] ints = new int[][] {{3,4},{4,1},{1,2},{2,3},{5,1}};
        int[] result = findRedundantDirectedConnection.findRedundantDirectedConnection(ints);
        System.out.println(Arrays.toString(result));
    }
}
