package com.gmy.leetcode.review;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150
 */
public class RemoveDuplicates {

    // 1 1 2 2 3 3
    // 1 1 1 1 2 2 3 3
    public int removeDuplicates(int[] nums) {
        int start = 0;
        int count = 0, last = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != last) {
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


    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int i = removeDuplicates.removeDuplicates(new int[]{1, 1, 1, 1, 2, 2, 3, 3});
        System.out.println(i);
    }
}
