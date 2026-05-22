package com.gmy.leetcode.lingcha.two_points;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且 不重复 的三元组。
 * https://leetcode.cn/problems/1fGaJU/description/
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1, target = -nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 跳过重复数字
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left = getNextNotEq(nums, left);
                    right = getBeforeNotEq(nums, right);
                } else if (nums[left] + nums[right] < target) {
                    left = getNextNotEq(nums, left);
                } else {
                    right = getBeforeNotEq(nums, right);
                }
            }
        }
        return res;
    }

    private int getNextNotEq(int[] nums, int index) {
        int num = nums[index];
        while (index < nums.length && nums[index] == num) {
            index++;
        }
        return index;
    }

    private int getBeforeNotEq(int[] nums, int index) {
        int num = nums[index];
        while (index > 0 && nums[index] == num) {
            index--;
        }
        return index;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {1,-1,-1,0};
        System.out.println(threeSum.threeSum(nums));
    }
}
