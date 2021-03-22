package com.gmy.leetcode.review.window;

import java.util.HashMap;
import java.util.Map;

/**
 * 在 X轴 上有一些奖品。给你一个整数数组 prizePositions ，
 * 它按照 非递减 顺序排列，其中 prizePositions[i] 是第 i 件奖品的位置。数轴上一个位置可能会有多件奖品。再给你一个整数 k 。
 * 你可以选择两个端点为整数的线段。每个线段的长度都必须是 k 。
 * 你可以获得位置在任一线段上的所有奖品（包括线段的两个端点）。注意，两个线段可能会有相交。
 *
 * 比方说 k = 2 ，你可以选择线段 [1, 3] 和 [2, 4] ，
 * 你可以获得满足 1 <= prizePositions[i] <= 3 或者 2 <= prizePositions[i] <= 4 的所有奖品 i 。
 * 请你返回在选择两个最优线段的前提下，可以获得的 最多 奖品数目。
 */
public class MaximizeWin {

    /**
     * 保证 prizePositions[right] - prizePositions[left] + 1 < K 即可
     * 并且奖品数 一定是 right - left + 1 prizePositions中的窗口长度
     * 如何保证最多
     * 1. 首先计算数据时 使用pre数组保证两个线段不重复 这样计算出的结果准确
     * 2. 然后本次计算结果是 right - left + 1 + pre[left]
     * 3. pre数组的赋值 是 pre[right + 1] 这样调用 pre[left] 时才不会重复
     * @param prizePositions
     * @param k
     * @return
     */
    public int maximizeWin(int[] prizePositions, int k) {
        int start = 0, n = prizePositions.length, result = 0;
        int[] pre = new int[prizePositions.length + 1];
        for (int end = 0; end < n; end++) {
            // 如果窗口长度大于k 则缩小窗口
            while (prizePositions[end] - prizePositions[start] > k) {
                start++;
            }
            result = Math.max(end - start + 1 + pre[start], result);
            // 不交集情况下的最大值
            pre[end + 1] = Math.max(pre[end], end - start + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        MaximizeWin maximizeWin = new MaximizeWin();
        int result = maximizeWin.maximizeWin(new int[]{1,1,2,2,3,3,5}, 2);
        System.out.println(result);
    }

}
