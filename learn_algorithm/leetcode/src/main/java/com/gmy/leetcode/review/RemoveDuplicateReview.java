package com.gmy.leetcode.review;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150
 */
public class RemoveDuplicateReview {

    // 1 1 2 2 3 3
    // 1 1 1 1 2 2 3 3

    /**
     * 类似于双指针，当相同的数量小于等于2时 把
     * index = i 的 数字赋值给 index = start
     * 参考 快拍
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int last = Integer.MIN_VALUE, count = 0, start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (last != nums[i]) {
                count = 1;
                last = nums[i];
            } else {
                count++;
            }
            if (count <= 2) {
                nums[start++] = nums[i];
            }
        }
        return start;
    }
}
