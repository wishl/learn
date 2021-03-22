package com.gmy.leetcode.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * https://leetcode.cn/problems/3sum/description/
 */
public class _0015_ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i = getNext(nums, i)) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] > 0) {
                    right = getBefore(nums, right);
                } else if (nums[left] + nums[right] + nums[i] < 0) {
                    left = getNext(nums, left);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    left = getNext(nums, left);
                }
            }
        }
        return result;
    }


    private int getNext(int[] nums, int i) {
        int old = nums[i];
        for (; i < nums.length; i++) {
            if (old != nums[i]) {
                return i;
            }
        }
        return i;
    }

    private int getBefore(int[] nums, int i) {
        int old = nums[i];
        for (; i >= 0; i--) {
            if (old != nums[i]) {
                return i;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        _0015_ThreeSum threeSum = new _0015_ThreeSum();
        List<List<Integer>> result = threeSum.threeSum(new int[]{0, 1, 1, 1});
        System.out.println(result);
    }
}
