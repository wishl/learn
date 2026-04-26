package com.gmy.leetcode.week.contest._490;

/**
 * 给你一个整数数组 nums，其中 nums[i] 表示在第 i 场比赛中获得的分数。
 * 恰好 有两位玩家。初始时，第一位玩家为 主动玩家，第二位玩家为 被动玩家。
 * 按顺序 将下述规则应用于每场比赛 i：
 * 如果 nums[i] 是奇数，主动玩家和被动玩家互换角色。
 * 在每第 6 场比赛（即比赛索引为 5, 11, 17, ... 的比赛中），主动玩家和被动玩家互换角色。
 * 主动玩家参与第 i 场比赛，并获得 nums[i] 分。
 * 返回 分数差，即第一位玩家的 总分 减去第二位玩家的 总分 。
 */
public class ScoreDifference {

    public int scoreDifference(int[] nums) {
        int p1 = 0, p2 = 0;
        long i = 0L;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] % 2 == 1) {
                // 交换
                i++;
            }
            // 第六场比赛交换
            if ((j + 1) % 6 == 0) {
                i++;
            }
            // 加分数
            if (i % 2 == 0) {
                p1 += nums[j];
            } else {
                p2 += nums[j];
            }
        }
        return p1 - p2;
    }

    public static void main(String[] args) {
        ScoreDifference scoreDifference = new ScoreDifference();
        int result = scoreDifference.scoreDifference(new int[]{1});
        System.out.println(result);
    }

}
