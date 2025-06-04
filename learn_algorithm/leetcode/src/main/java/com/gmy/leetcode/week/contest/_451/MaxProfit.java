package com.gmy.leetcode.week.contest._451;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * 给你一个整数 n，表示公司中员工的数量。每位员工都分配了一个从 1 到 n 的唯一 ID ，其中员工 1 是 CEO。
 * 另给你两个下标从 1 开始的整数数组 present 和 future，两个数组的长度均为 n，具体定义如下：
 *
 * present[i] 表示第 i 位员工今天可以购买股票的 当前价格 。
 * future[i] 表示第 i 位员工明天可以卖出股票的 预期价格 。
 * 公司的层级关系由二维整数数组 hierarchy 表示，其中 hierarchy[i] = [ui, vi] 表示员工 ui 是员工 vi 的直属上司。
 * 此外，再给你一个整数 budget，表示可用于投资的总预算。
 * 公司有一项折扣政策：如果某位员工的直属上司购买了自己的股票，那么该员工可以以 半价 购买自己的股票（即 floor(present[v] / 2)）。
 *
 * 请返回在不超过给定预算的情况下可以获得的 最大利润 。
 */
public class MaxProfit {

    /**
     * 上司买，上司不买，自己不买
     * 剩余的钱，盈利的钱
     * bfs
     * @return
     */
    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : hierarchy) {
            g[e[0] - 1].add(e[1] - 1);
        }

        int[][] f0 = dfs(0, g, present, future, budget);
        return f0[budget][0];
    }

    private int[][] dfs(int x, List<Integer>[] g, int[] present, int[] future, int budget) {
        // 计算从 x 的所有儿子子树 y 中，能得到的最大利润之和
        int[][] subF = new int[budget + 1][2];
        for (int y : g[x]) {
            int[][] fy = dfs(y, g, present, future, budget);
            for (int j = budget; j >= 0; j--) {
                // 枚举子树 y 的预算为 jy
                // 当作一个体积为 jy，价值为 fy[jy][k] 的物品
                for (int jy = 0; jy <= j; jy++) {
                    for (int k = 0; k < 2; k++) {
                        subF[j][k] = Math.max(subF[j][k], subF[j - jy][k] + fy[jy][k]);
                    }
                }
            }
        }

        int[][] f = new int[budget + 1][2];
        for (int j = 0; j <= budget; j++) {
            for (int k = 0; k < 2; k++) {
                int cost = present[x] / (k + 1);
                if (j >= cost) {
                    // 不买 x，转移来源是 subF[j][0]
                    // 买 x，转移来源为 subF[j-cost][1]，因为对于子树来说，父节点一定买
                    f[j][k] = Math.max(subF[j][0], subF[j - cost][1] + future[x] - cost);
                } else { // 只能不买 x
                    f[j][k] = subF[j][0];
                }
            }
        }
        return f;
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int result = maxProfit.maxProfit(2, new int[]{1,2}, new int[]{4,3}, new int[][]{{1,2}}, 3);
        System.out.println(result);
    }
}
