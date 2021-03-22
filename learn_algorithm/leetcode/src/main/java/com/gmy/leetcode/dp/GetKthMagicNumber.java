package com.gmy.leetcode.dp;

import java.util.Deque;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/get-kth-magic-number-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetKthMagicNumber {

    /**
     * 使用堆排序进行排序 并顺序获取结论
     * @param k
     * @return
     */
    public int getKthMagicNumber(int k) {
        int[] nums = {3, 5, 7};
        Queue<Long> deque = new PriorityQueue<>();
        deque.offer(1L);
        int result = 1;
        Set<Long> set = new HashSet<>();
        for (int i = 1; i <= k; i++) {
            long current = deque.poll();
            result = (int) current;
            for (int j = 0; j < nums.length; j++) {
                long next = current * nums[j];
                if (set.add(next)) {
                    deque.offer(next);
                }
            }
        }
        return result;
    }

    /**
     * 使用dp获取
     * @return
     */
    public int getKthMagicNumberDp(int k) {
        int[] dp = new int[k + 1];
        dp[1] = 1;
        int p3 = 1, p5= 1, p7 = 1;
        int result = 1;
        for (int i = 2; i <= k; i++) {
            int num3 = dp[p3] * 3, num5 = dp[p5] * 5, num7 = dp[p7] * 7;
            result = Math.min(Math.min(num3, num5), num7);
            dp[i] = result;
            if (result == num3) {
                p3++;
            }
            if (result == num5) {
                p5++;
            }
            if (result == num7) {
                p7++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GetKthMagicNumber getKthMagicNumber = new GetKthMagicNumber();
        int kthMagicNumber = getKthMagicNumber.getKthMagicNumber(643);
        int kthMagicNumberDp = getKthMagicNumber.getKthMagicNumberDp(643);
        System.out.println(kthMagicNumber);
        System.out.println(kthMagicNumberDp);
    }

}
