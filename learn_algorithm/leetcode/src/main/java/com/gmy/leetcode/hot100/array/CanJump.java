package com.gmy.leetcode.hot100.array;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 *
 * https://leetcode.cn/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class CanJump {

    public boolean canJump(int[] nums) {
        // 能跳到的最大位置
        int maxlength = nums[0];
        for (int i = 0; i <= maxlength && i < nums.length; i++) {
            maxlength = Math.max(maxlength, i + nums[i]);
        }
        return maxlength >= nums.length - 1;
    }

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        boolean b = canJump.canJump(new int[]{1,2,3});
        System.out.println(b);
    }

}
