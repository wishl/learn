package com.gmy.leetcode.week.contest._451;

/**
 * 给你三个整数 n、m 和 k。
 * 有两根长度分别为 n 和 m 单位的木材，需要通过三辆卡车运输。每辆卡车最多只能装载一根长度 不超过 k 单位的木材。
 * 你可以将木材切成更小的段，其中将长度为 x 的木材切割成长度为 len1 和 len2 的段的成本为 cost = len1 * len2，并且满足 len1 + len2 = x。
 * 返回将木材分配到卡车上的 最小总成本 。如果木材不需要切割，总成本为 0。
 *
 * 示例 1：
 * 输入： n = 6, m = 5, k = 5
 * 输出： 5
 * 解释：
 * 将长度为 6 的木材切割成长度为 1 和 5 的两段，成本为 1 * 5 == 5。现在三段长度分别为 1、5 和 5 的木材可以分别装载到每辆卡车。
 */
public class MinCuttingCost {

    public long minCuttingCost(int n, int m, int k) {
        long cost1 = split(n, k);
        long cost2 = split(m, k);
        return cost1 + cost2;
    }

    private long split(int length, int k) {
        if (length <= k) {
            return 0;
        }
        long result = 0;
        while (length > k) {
            result += (long) k * (length - k);
            length -= k;
        }
        return result;
    }

    public static void main(String[] args) {
        MinCuttingCost minCuttingCost = new MinCuttingCost();
        long result = minCuttingCost.minCuttingCost(6, 5, 5);
        System.out.println(result);
    }

}
