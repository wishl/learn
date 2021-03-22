package com.gmy.leetcode.week.dobuleweek.onetwoseven;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums 和一个 正 整数 k 。
 * 一个子序列的 能量 定义为子序列中 任意 两个元素的差值绝对值的 最小值 。
 * 请你返回 nums 中长度 等于 k 的 所有 子序列的 能量和 。
 * 由于答案可能会很大，将答案对 109 + 7 取余 后返回。
 *
 * https://leetcode.cn/problems/find-the-sum-of-subsequence-powers/description/
 *
 * 输入：nums = [1,2,3,4], k = 3
 * 输出：4
 * 解释：
 * nums 中总共有 4 个长度为 3 的子序列：[1,2,3] ，[1,3,4] ，[1,2,4] 和 [2,3,4] 。能量和为 |2 - 3| + |3 - 4| + |2 - 1| + |3 - 4| = 4 。
 */
public class SumOfPowers {

    /**
     *
     *
     * @param nums
     * @param k
     * @return
     */
    public int sumOfPowers(int[] nums, int k) {
        Arrays.sort(nums);

        return k;
    }

}
