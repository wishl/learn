package com.gmy.leetcode.half.answer;

import java.util.Arrays;

/**
 * 给你一个正整数数组 price ，其中 price[i] 表示第 i 类糖果的价格，另给你一个正整数 k 。
 * 商店组合 k 类 不同 糖果打包成礼盒出售。礼盒的 甜蜜度 是礼盒中任意两种糖果 价格 绝对差的最小值。
 * 返回礼盒的 最大 甜蜜度。
 *
 * 示例 1:
 *
 * 输入：price = [13,5,1,8,21,2], k = 3
 * 输出：8            [13,5,21]
 * 解释：选出价格分别为 [13,5,21] 的三类糖果。
 * 礼盒的甜蜜度为 min(|13 - 5|, |13 - 21|, |5 - 21|) = min(8, 8, 16) = 8 。
 * 可以证明能够取得的最大甜蜜度就是 8 。
 */
public class MaximumTastiness {

    /**
     * 甜度越大 能选择的糖果种类越少 所以单调
     * @param price
     * @param k
     * @return
     */
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int max = Arrays.stream(price).max().getAsInt();
        int left = 1, right = max;
        while (left <= right) {
            int mid = (left + right) / 2;
            boolean canChoose = canChoose(price, mid, k);
            // 满足条件 说明甜度小了 尝试增大
            if (canChoose) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }

    private boolean canChoose(int[] price, int d, int k) {
        int cnt = 1, pre = price[0];
        for (int p : price) {
            if (p >= pre + d) {
                cnt++;
                pre = p;
            }
        }
        return cnt >= k;
    }


    public static void main(String[] args) {
        MaximumTastiness maximumTastiness = new MaximumTastiness();
        // 1, 2, 5, 8, 13, 21
        int result = maximumTastiness.maximumTastiness(new int[]{13, 5, 1, 8, 21, 2}, 3);
        System.out.println(result);
    }
}
