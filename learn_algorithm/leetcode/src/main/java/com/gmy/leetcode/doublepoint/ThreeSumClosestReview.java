package com.gmy.leetcode.doublepoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个长度为 n 的整数数组nums和 一个目标值target。请你从 nums 中选出三个整数，使它们的和与target最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSumClosestReview {

    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE, diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > target) {
                    int currentDiff = Math.abs(sum - target);
                    diff = Math.min(currentDiff, diff);
                    result = currentDiff == diff ? sum : result;
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < target) {
                    int currentDiff = Math.abs(sum - target);
                    diff = Math.min(currentDiff, diff);
                    result = currentDiff == diff ? sum : result;
                    left++;
                } else {
                    return target;
                }
            }
        }
        return result;
    }

    public int threeSumClosest1(int[] nums, int target) {
        return dfs(nums, target, 0, target, Integer.MAX_VALUE, new boolean[nums.length], 0);
    }

    private int dfs(int[] nums, int target, int index, int sum, int result, boolean[] viewed, int count) {
        if (index == nums.length && count != 3) {
            return result;
        }
        if (count == 3) {
            if (Math.abs(sum - target) <= Math.abs(result - target)) {
                return sum;
            } else {
                return result;
            }
        }
        if (!viewed[index]) {
            viewed[index] = true;
            result = dfs(nums, target, index + 1, nums[index], result, viewed, 1);
        }
        if (index > 0) {
            result = dfs(nums, target, index + 1, sum + nums[index], result, viewed, count + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSumClosestReview threeSumClosestReview = new ThreeSumClosestReview();
        int result = threeSumClosestReview.threeSumClosest(new int[]{0, 1, 2}, 0);
        int result1 = threeSumClosestReview.threeSumClosest1(new int[]{0, 1, 2}, 0);
        System.out.println(result);
        System.out.println(result1);
    }

}
