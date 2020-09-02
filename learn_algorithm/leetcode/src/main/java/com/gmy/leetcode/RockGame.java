package com.gmy.leetcode;

/**
 *
 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。
 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
 https://leetcode-cn.com/problems/stone-game/
 */
public class RockGame {

    // 动态规划解法
    public static boolean dp(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];
        for (int i = 0; i < piles.length; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = piles.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < piles.length ; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][piles.length - 1] > 0;
    }

    // 因为有偶数堆，所以先手永远可以选择到最佳解法，
    // 又因为不含平局，所以先手必胜
    public static boolean stoneGame(int[] piles) {
        return true;
    }

    public static void main(String[] args) {
        stoneGame(new int[] {1, 2, 3, 4});
    }

}
