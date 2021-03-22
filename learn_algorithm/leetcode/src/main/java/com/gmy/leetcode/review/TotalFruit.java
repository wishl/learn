package com.gmy.leetcode.review;

/**
 * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
 * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
 * 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
 * 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。
 * 每采摘一次，你将会向右移动到下一棵树，并继续采摘。
 * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
 *
 * https://leetcode.cn/problems/fruit-into-baskets/description/
 */
public class TotalFruit {


    /**
     * 缩进窗口的方式
     * @param fruits
     * @return
     */
    public int totalFruit(int[] fruits) {
        int[] cache = new int[fruits.length];
        int start = 0, end = 0, count = 0, max = 0;
        while (end < fruits.length) {
            int endCount = cache[fruits[end++]]++;
            if (endCount == 0) {
                count++;
            }
            while (count > 2) {
                int startCount = cache[fruits[start++]]--;
                if (startCount == 1) {
                    count--;
                }
            }
            if (count == 2) {
                max = Math.max(max, end - start);
            }
        }
        return Math.max(max, end - start);
    }

    /**
     * 维护最大窗口的方式
     * @return
     */
    public int totalFruit1(int[] fruits) {
        // 窗口中的字符
        int[] cache = new int[fruits.length];
        // max = 窗口的最大长度
        int start = 0, end = 0, count = 0, max = 0;
        while (end < fruits.length) {
            int endCount = cache[fruits[end++]]++;
            if (endCount == 0) {
                count++;
            }
            max = count <= 2 ? Math.max(end - start, max) : max;
            if (count > 2) {
                int startCount = cache[fruits[start++]]--;
                if (startCount == 1) {
                    count--;
                }
            }
        }
        return end - start;
    }

    public static void main(String[] args) {
        TotalFruit totalFruit = new TotalFruit();
        int result = totalFruit.totalFruit(new int[]{0, 1, 2, 1});
        int result1 = totalFruit.totalFruit1(new int[]{0, 1, 2, 1});
        System.out.println(result);
        System.out.println(result1);
    }

}
