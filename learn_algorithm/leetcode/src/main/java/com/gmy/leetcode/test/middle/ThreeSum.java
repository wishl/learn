package com.gmy.leetcode.test.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * https://leetcode.cn/problems/3sum/description/
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList();
        int length = nums.length;
        for (int i = 0; i < nums.length; i = getNextDiff(nums, i)) {
            int left = i + 1, right = length - 1, sum = 0 - nums[i];
            while (left < right) {
                // 大于 right--
                if (nums[left] + nums[right] > sum) {
                    right = getPreDiff(nums, right);
                } else if (nums[left] + nums[right] <= sum) {
                    if (nums[left] + nums[right] == sum) {
                        list.add(Stream.of(nums[i], nums[left], nums[right]).collect(Collectors.toList()));
                    }
                    left = getNextDiff(nums, left);
                }
            }
        }
        return list;
    }

    /**
     * 向后获取第一个不同的index
     * @param nums
     * @param index
     * @return
     */
    private int getNextDiff(int[] nums, int index) {
        int num = nums[index];
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] != num) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 向后获取第一个不同的index
     * @param nums
     * @param index
     * @return
     */
    private int getPreDiff(int[] nums, int index) {
        int num = nums[index];
        for (int i = index - 1; i >= 0; i--) {
            if (nums[i] != num) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> result = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(result);
    }
}
