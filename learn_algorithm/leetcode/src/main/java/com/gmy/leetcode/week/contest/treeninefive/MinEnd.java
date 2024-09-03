package com.gmy.leetcode.week.contest.treeninefive;

/**
 * 给你两个整数 n 和 x 。你需要构造一个长度为 n 的 正整数 数组 nums ，
 * 对于所有 0 <= i < n - 1 ，满足 nums[i + 1] 大于 nums[i] ，并且数组 nums 中所有元素的按位 AND 运算结果为 x 。
 * 返回 nums[n - 1] 可能的 最小 值。
 *
 * https://leetcode.cn/problems/minimum-array-end/description/
 *
 * 输入：n = 3, x = 4
 * 1 3 4
 *
 * 0100
 *
 * 0101
 * 0110
 * 0111
 *
 * 4 + 2 + 1 = 7
 *
 * 输出：6
 *
 * 解释：
 *
 * 数组 nums 可以是 [4,5,6] ，最后一个元素为 6 。
 */
public class MinEnd {

    public long minEnd(int n, int x) {
        n--; // 先把 n 减一，这样下面讨论的 n 就是原来的 n-1
        long ans = x;
        int i = 0, j = 0;
        while ((n >> j) > 0) {
            // x 的第 i 个比特值是 0，即「空位」
            if ((ans >> i & 1) == 0) {
                // 空位填入 n 的第 j 个比特值
                ans |= (long) (n >> j & 1) << i;
                j++;
            }
            i++;
        }
        return ans;
    }

    // 0111 1000

    // 0100 0001 0100 4
    // 0101 0010 0100 5
    // 0110 0011 0100 6
    // 0111 1000 0100 7
    // 1100 1001 0100 12

    public static void main(String[] args) {
        MinEnd minEnd = new MinEnd();
        long result = minEnd.minEnd(6715154, 7193485);
        System.out.println(result);
    }

}
