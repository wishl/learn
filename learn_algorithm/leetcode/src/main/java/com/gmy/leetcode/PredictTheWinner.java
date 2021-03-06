package com.gmy.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个表示分数的非负整数数组。
 * 玩家 1 从数组任意一端拿取一个分数，
 * 随后玩家 2 继续从剩余数组任意一端拿取分数，然后玩家 1 拿，…… 。
 * 每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。
 * 直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/predict-the-winner
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PredictTheWinner {

    private static Map<Integer, Integer> map = new HashMap<>();
    private static int aMax;

    public static boolean predictTheWinner(int[] nums) {
        return getResult(0, nums.length - 1, nums, 1) >= 0;
    }

    // 暴力解
    private static int getResult(int left, int right, int[] nums, int turn) {
        if(right == left) {
            return nums[left] * turn;
        }
        int start = nums[left] * turn + getResult(left + 1, right, nums, -turn);
        int end = nums[right] * turn + getResult(left, right - 1, nums, -turn);
        return Math.max(start * turn, end * turn) * turn;
    }

    // 动态规划，分成子问题，存储最优解，然后计算转移方程
    // 对于本题来说，存储的最优解是两个数的最大差值，子问题就是子数组的最大差值
    // 对于i,j，i是最左边的元素，j是最右边的元素，其转化公式为：
    // dp[i][j] = Max(nums[i] - dp[i + 1][j],nums[j] - dp[i][j - 1])
    // 当i == j 时，只能选择一个数所以是dp[i][j] == nums[i] == nums[j]
    // 当i < j 时，因为j一定是i的右边所以为0
    // 最后判断 dp[0][nums.length - 1] >= 0
    // 因为要计算最中问题所以要看dp[0][nums.length - 1]
    private static boolean dp(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length ; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }

    public static void main(String[] args) {
//        boolean b = predictTheWinner(new int[]{1, 89, 3});
        boolean b = dp(new int[]{1, 5, 2, 4, 6});
        System.out.println(b);
    }

}
