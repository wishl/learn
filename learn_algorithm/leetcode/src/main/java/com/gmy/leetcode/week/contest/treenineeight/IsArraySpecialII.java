package com.gmy.leetcode.week.contest.treenineeight;

import java.util.Arrays;

/**
 * 如果数组的每一对相邻元素都是两个奇偶性不同的数字，则该数组被认为是一个 特殊数组 。
 * 周洋哥有一个整数数组 nums 和一个二维整数矩阵 queries，对于 queries[i] = [fromi, toi]，
 * 请你帮助周洋哥检查子数组 nums[fromi..toi] 是不是一个 特殊数组 。
 * 返回布尔数组 answer，如果 nums[fromi..toi] 是特殊数组，则 answer[i] 为 true ，否则，answer[i] 为 false 。
 */
public class IsArraySpecialII {

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] result = new boolean[queries.length];
        boolean[][] dp = new boolean[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length ; j++) {
                if (j == i) {
                    dp[i][j] = true;
                } else {
                    // 从第i个 到 第j个
                    dp[i][j] = dp[i][j - 1] && (nums[j] % 2) != (nums[j - 1] % 2);
                }
            }
        }
        for (int i = 0; i < queries.length; i++) {
            result[i] = dp[queries[i][0]][queries[i][1]];
        }
        return result;
    }

    public static void main(String[] args) {
        IsArraySpecialII isArraySpecialII = new IsArraySpecialII();
        boolean[] result = isArraySpecialII.isArraySpecial(new int[]{3,7,8}, new int[][]{{0, 2}});
        System.out.println(Arrays.toString(result));
        //queries = [[0,2],[2,3]]});
    }

}
