package com.gmy.leetcode.top100;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class _0283_MoveZeroes {

    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            nums[left] = nums[right];
            if (nums[left] != 0) {
                left++;
            }
            right++;
        }
        while (left < right) {
            nums[left++] = 0;
        }
    }

    public static void main(String[] args) {
        _0283_MoveZeroes moveZeroes = new _0283_MoveZeroes();
        int[] ints = {0, 0, 0, 0};
        moveZeroes.moveZeroes(ints);
        System.out.println(Arrays.toString(ints));
    }

}
