package com.gmy.leetcode.hot100.array;

import java.util.Arrays;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicatesStack {

    /**
     * 快慢指针解法
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int left = 2;
        for (int right = 2; right < nums.length; right++) {
            // 不相等则留下来
            if (nums[right] != nums[left - 2]) {
                nums[left++] = nums[right];
            }
        }
        return left;
    }

    public static void main(String[] args) {
        RemoveDuplicatesStack removeDuplicatesStack = new RemoveDuplicatesStack();
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicatesStack.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
