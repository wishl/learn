package com.gmy.leetcode.week.contest.one;

/**
 * 给你一个正整数 k 。最初，你有一个数组 nums = [1] 。
 * 你可以对数组执行以下 任意 操作 任意 次数（可能为零）：
 * 选择数组中的任何一个元素，然后将它的值 增加 1 。
 * 复制数组中的任何一个元素，然后将它附加到数组的末尾。
 * 返回使得最终数组元素之 和 大于或等于 k 所需的 最少 操作次数。
 *
 * https://leetcode.cn/problems/apply-operations-to-make-sum-of-array-greater-than-or-equal-to-k/description/
 */
public class MinOperations {

    /**
     * 枚举拷贝次数
     * @param k
     * @return
     */
    public int minOperations(int k) {
        int min = k - 1, count = 1, copy = k;
        while (copy > 1) {
            ++count;
            copy = (int) Math.ceil((double) k / count);
            min = Math.min(min, copy - 1 + count - 1);
        }
        return min;
    }

    public static void main(String[] args) {
        // todo 提高速度
        MinOperations minOperations = new MinOperations();
        int result = minOperations.minOperations(16);
        System.out.println(result);
    }
}
