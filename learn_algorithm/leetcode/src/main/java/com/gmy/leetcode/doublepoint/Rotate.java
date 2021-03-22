package com.gmy.leetcode.doublepoint;

import com.gmy.leetcode.dac.KClosest;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 *https://leetcode.cn/problems/rotate-array/
 */
public class Rotate {

    public void rotate(int[] nums, int k) {
        int i = k % nums.length;
        int[] copyNums = new int[nums.length * 2];
        System.arraycopy(nums, 0, copyNums, 0, nums.length);
        System.arraycopy(nums, 0, copyNums, nums.length, nums.length);
        System.arraycopy(copyNums, nums.length - i, nums, 0, nums.length);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5,6,7};
        Rotate rotate = new Rotate();
        rotate.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

}
