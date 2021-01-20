package com.gmy.leetcode.union;

/**
 * https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/shou-ba-shou-she-ji-shu-ju-jie-gou/unionfind-suan-fa-xiang-jie
 */
public class UnionFind {

    private int[] parent;
    private int count;
    private int[] deep;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            deep[i] = 0;
        }
        count = n;
    }

    public int find(int index) {
        while (parent[index] != index) {
            index = parent[index];
        }
        return index;
    }

    /**
     * 链接两个点，获取两个点的跟节点，在把根节点连接
     * 此方法存在不平衡的情况
     * @param index1
     * @param index2
     * @return
     */
    public boolean union(int index1, int index2) {
        int root1 = find(index1);
        int root2 = find(index2);
        if (root1 == root2) {
            return false;
        }
        // 把两个根节点连在一起
        parent[root1] = root2;
        count--;
        return true;
    }

    /**
     * 解决不平衡的方式：添加一个层级的存储，在连接的时候判断，把小树放在大树底下
     * @param index1
     * @param index2
     * @return
     */
    public boolean unionBalance(int index1, int index2) {
        int root1 = find(index1);
        int root2 = find(index2);
        if (root1 == root2) {
            return false;
        }
        // 如果root1
        if (deep[root1] > deep[root2]) {
            parent[root2] = root1;
            deep[root2] += deep[root1];
        } else {
            parent[root1] = root2;
            deep[root1] += deep[root2];
        }
        count--;
        return true;
    }

    /**
     * 压缩路径
     * @param index
     * @return
     */
    public int findCompress(int index) {
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }

}
