package com.gmy.leetcode.week.contest.treenineeight;

/**
 * 如果数组的每一对相邻元素都是两个奇偶性不同的数字，则该数组被认为是一个 特殊数组 。
 * Aging 有一个整数数组 nums。如果 nums 是一个 特殊数组 ，返回 true，否则返回 false。
 */
public class IsArraySpecial {

    public boolean isArraySpecial(int[] nums) {
        int last = nums[0] % 2;
        for (int i = 1; i < nums.length; i++) {
            // 上一个是偶数 这个还是偶数 返回false
            if (last == nums[i] % 2) {
                return false;
            }
            last = nums[i] % 2;
        }
        return true;
    }

}
