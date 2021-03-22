package com.gmy.leetcode.half.answer;

import java.util.Arrays;

/**
 * 给你一个整数 n ，表示有 n 间零售商店。总共有 m 种产品，每种产品的数目用一个下标从 0 开始的整数数组 quantities 表示，
 * 其中 quantities[i] 表示第 i 种商品的数目。
 * 你需要将 所有商品 分配到零售商店，并遵守这些规则：
 * 一间商店 至多 只能有 一种商品 ，但一间商店拥有的商品数目可以为 任意 件。
 * 分配后，每间商店都会被分配一定数目的商品（可能为 0 件）。用 x 表示所有商店中分配商品数目的最大值，
 * 你希望 x 越小越好。也就是说，你想 最小化 分配给任意商店商品数目的 最大值 。
 * 请你返回最小的可能的 x 。
 * https://leetcode.cn/problems/minimized-maximum-of-products-distributed-to-any-store/description/
 *
 * 输入：n = 6, quantities = [11,6]
 * 输出：3
 * 解释： 一种最优方案为：
 * - 11 件种类为 0 的商品被分配到前 4 间商店，分配数目分别为：2，3，3，3 。
 * - 6 件种类为 1 的商品被分配到另外 2 间商店，分配数目分别为：3，3 。
 * 分配给所有商店的最大商品数目为 max(2, 3, 3, 3, 3, 3) = 3 。
 */
public class MinimizedMaximum {

    public int minimizedMaximum(int n, int[] quantities) {
        int max = Arrays.stream(quantities).max().orElse(0);
        // x 最大值 为 max 最小值为 1
        // 维护未知集 [left, right] 结果为 right + 1
        int left = 1, right = max;
        while (left <= right) {
            int mid = (left + right) / 2;
            boolean canBeSplit = canBeSplit(quantities, mid, n);
            // 可以分说明x大了 尝试减小x
            if (canBeSplit) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right + 1;
    }

    /**
     * 只能拿一种 默认所有店铺都拿 count 向上取整
     * @param sum
     * @param count
     * @param n
     * @return
     */
    private boolean canBeSplit(int[] quantities, int count, int n) {
        for (int quantity : quantities) {
            // 当前种类都拿光需要多少商店
            int storeCount = (quantity + count - 1) / count;
            n -= storeCount;
        }
        return n >= 0;
    }

    public static void main(String[] args) {
        MinimizedMaximum minimizedMaximum = new MinimizedMaximum();
        // 2, [5, 7]
        int result = minimizedMaximum.minimizedMaximum(2, new int[]{5, 7});
        System.out.println(result);
    }



}
