package com.gmy.leetcode.hot100.array;

import java.util.Arrays;

/**
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 * 考虑 nums 的唯一元素的数量为 k。去重后，返回唯一元素的数量 k。
 * nums 的前 k 个元素应包含 排序后 的唯一数字。下标 k - 1 之后的剩余元素可以忽略。
 */
public class RemoveDuplicates {

    /**
     * 快慢指针 不是重复项的时候保留
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int left = 1;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[left - 1]) { // nums[i] 不是重复项
                nums[left++] = nums[right]; // 保留 nums[i]
            }
        }
        return left;
    }

    public int removeDuplicates1(int[] nums) {
        int left = 1;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[right - 1]) { // nums[i] 不是重复项
                nums[left++] = nums[right]; // 保留 nums[i]
            }
        }
        return left;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = {1, 1, 1, 3};
        int i = removeDuplicates.removeDuplicates(nums);
        int i1 = removeDuplicates.removeDuplicates1(new int[]{1, 1, 1, 3});
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }
}
