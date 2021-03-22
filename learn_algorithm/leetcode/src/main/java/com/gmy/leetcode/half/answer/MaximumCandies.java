package com.gmy.leetcode.half.answer;

import java.util.Arrays;

/**
 * 给你一个 下标从 0 开始 的整数数组 candies 。
 * 数组中的每个元素表示大小为 candies[i] 的一堆糖果。你可以将每堆糖果分成任意数量的 子堆 ，但 无法 再将两堆合并到一起。
 * 另给你一个整数 k 。你需要将这些糖果分配给 k 个小孩，使每个小孩分到 相同 数量的糖果。
 * 每个小孩可以拿走 至多一堆 糖果，有些糖果可能会不被分配。
 *
 * 返回每个小孩可以拿走的 最大糖果数目 。
 *
 * 输入：candies = [5,8,6], k = 3
 * 输出：5
 * 解释：可以将 candies[1] 分成大小分别为 5 和 3 的两堆，然后把 candies[2] 分成大小分别为 5 和 1 的两堆。
 * 现在就有五堆大小分别为 5、5、3、5 和 1 的糖果。可以把 3 堆大小为 5 的糖果分给 3 个小孩。可以证明无法让每个小孩得到超过 5 颗糖果。
 */
public class MaximumCandies {

    public int maximumCandies(int[] candies, long k) {
        // 最小的一堆糖果
        int min = Arrays.stream(candies).max().orElse(0);
        // [left, right] 维护未知集 代表每个小朋友获得的糖果数量 因为想要最大的结果 所以结果为 left - 1
        int left = 1, right = min;
        while (left <= right) {
            int mid = (left + right) / 2;
            boolean canBeSplit = canBeSplit(candies, mid, k);
            // 可以被分 证明 每堆的数量 <= 最大的数量 则需要扩大每堆的数量
            if (canBeSplit) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }

    /**
     * 至少K堆 每堆要分count个
     * @param candies
     * @param count
     * @param k
     * @return
     */
    private boolean canBeSplit(int[] candies, int count, long k) {
        long result = 0;
        for (int candy : candies) {
            result += candy / count;
        }
        return result >= k;
    }

    public static void main(String[] args) {
        MaximumCandies maximumCandies = new MaximumCandies();
        int result = maximumCandies.maximumCandies(new int[]{1,2,3,4,10}, 5);
        System.out.println(result);
    }

}
