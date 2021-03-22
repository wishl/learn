package com.gmy.leetcode.doublepoint;

import java.util.Arrays;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicatesReview {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 1, j = i;
        int duplicateCount = 1;
        while (j < nums.length) {
            nums[i] = nums[j];
            if (nums[i] == nums[i - 1]) {
                duplicateCount++;
            } else {
                duplicateCount = 1;
            }
            if (duplicateCount <= 2) {
                i++;
            }
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        RemoveDuplicatesReview removeDuplicatesReview = new RemoveDuplicatesReview();
        int[] nums = new int[] {0,0,1,1,1,1,2,3,3};
        int result = removeDuplicatesReview.removeDuplicates(nums);
        int[] resultNums = new int[result];
        System.arraycopy(nums, 0, resultNums, 0, result);
        System.out.println(Arrays.toString(resultNums));
    }
}
