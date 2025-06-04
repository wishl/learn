package com.gmy.leetcode.week.contest._450;

/**
 * 给你一个整数数组 nums 。
 * 返回满足 nums[i] 的数位和（每一位数字相加求和）等于 i 的 最小 下标 i 。
 * 如果不存在满足要求的下标，返回 -1 。
 */
public class SmallestIndex {

    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (cal(i, nums[i])) {
                return i;
            }
        }
        return -1;
    }

    private boolean cal(int index, int num) {
        int result = 0;
        while (num > 0) {
            result += num % 10;
            num = num / 10;
        }
        return result == index;
    }

    public static void main(String[] args) {
        SmallestIndex smallestIndex = new SmallestIndex();
        int result = smallestIndex.smallestIndex(new int[]{1, 3, 2});
        System.out.println(result);
    }

}
