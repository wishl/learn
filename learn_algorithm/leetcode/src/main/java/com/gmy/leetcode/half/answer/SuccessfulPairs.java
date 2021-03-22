package com.gmy.leetcode.half.answer;

import java.util.Arrays;

/**
 * 给你两个正整数数组 spells 和 potions ，长度分别为 n 和 m ，
 * 其中 spells[i] 表示第 i 个咒语的能量强度，potions[j] 表示第 j 瓶药水的能量强度。
 * 同时给你一个整数 success 。一个咒语和药水的能量强度 相乘 如果 大于等于 success ，那么它们视为一对 成功 的组合。
 * 请你返回一个长度为 n 的整数数组 pairs，其中 pairs[i] 是能跟第 i 个咒语成功组合的 药水 数目。
 *
 * https://leetcode.cn/problems/successful-pairs-of-spells-and-potions/description/
 *
 * 输入：spells = [5,1,3], potions = [1,2,3,4,5], success = 7
 * 输出：[4,0,3]
 * 解释：
 * - 第 0 个咒语：5 * [1,2,3,4,5] = [5,10,15,20,25] 。总共 4 个成功组合。
 * - 第 1 个咒语：1 * [1,2,3,4,5] = [1,2,3,4,5] 。总共 0 个成功组合。
 * - 第 2 个咒语：3 * [1,2,3,4,5] = [3,6,9,12,15] 。总共 3 个成功组合。
 * 所以返回 [4,0,3] 。
 */
public class SuccessfulPairs {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        long[] need = new long[potions.length];
        int n = potions.length;
        for (int i = 0; i < potions.length; i++) {
            // 向上取整 至少得有一个
            need[i] = Math.max(1, (success + potions[i] - 1) / potions[i]);
        }
        Arrays.sort(need);
        int[] result = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int search = search(need, spells[i]);
            result[i] = search;
        }
        return result;
    }

    /**
     * 计算出小于等于potion的最大的数
     * @param need
     * @param potion
     * @return
     */
    private int search(long[] need, int spell) {
        // 左边严格等于小于 右边大于
        int left = 0, right = need.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (need[mid] <= spell) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        SuccessfulPairs successfulPairs = new SuccessfulPairs();
        int[] result = successfulPairs.successfulPairs(new int[]{3, 1, 2}, new int[]{8,5,8}, 16);
        System.out.println(Arrays.toString(result));
    }

}
