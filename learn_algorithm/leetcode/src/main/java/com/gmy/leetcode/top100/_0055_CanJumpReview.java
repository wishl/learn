package com.gmy.leetcode.top100;

public class _0055_CanJumpReview {

    public boolean canJump(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > index) {
                return false;
            }
            index = Math.max(index, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        _0055_CanJumpReview canJumpReview = new _0055_CanJumpReview();
        boolean result = canJumpReview.canJump(new int[]{5, 4, 3, 2, 1});
        System.out.println(result);
    }

}
