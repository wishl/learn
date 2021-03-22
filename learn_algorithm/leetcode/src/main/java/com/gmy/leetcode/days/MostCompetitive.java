package com.gmy.leetcode.days;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums 和一个正整数 k ，返回长度为 k 且最具 竞争力 的 nums 子序列。
 * 数组的子序列是从数组中删除一些元素（可能不删除元素）得到的序列。
 * 在子序列 a 和子序列 b 第一个不相同的位置上，如果 a 中的数字小于 b 中对应的数字，那么我们称子序列 a 比子序列 b（相同长度下）更具 竞争力 。
 * 例如，[1,3,4] 比 [1,3,5] 更具竞争力，在第一个不相同的位置，也就是最后一个位置上， 4 小于 5 。
 *
 * https://leetcode.cn/problems/find-the-most-competitive-subsequence/description/?envType=daily-question&envId=2024-05-24
 *
 * 输入：nums = [3,5,2,6], k = 2
 * 输出：[2,6]
 * 解释：在所有可能的子序列集合 {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]} 中，[2,6] 最具竞争力。
 */
public class MostCompetitive {

    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        int[] st = new int[k]; // 用数组模拟栈（栈容量为 k）
        int m = 0; // 栈的大小
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            //
            while (m > 0 && x < st[m - 1] && (n - i) > (k - m)) {
                m--; // 出栈
            }
            if (m < k) {
                st[m++] = x; // 入栈
            }
        }
        return st;
    }

    public static void main(String[] args) {
        MostCompetitive mostCompetitive = new MostCompetitive();
        int[] result = mostCompetitive.mostCompetitive(new int[]{5, 4, 3, 2, 1}, 2);
        System.out.println(Arrays.toString(result));
    }

}
