package com.gmy.leetcode.half.answer;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums 和一个正整数 threshold  ，你需要选择一个正整数作为除数，然后将数组里每个数都除以它，并对除法结果求和。
 * 请你找出能够使上述结果小于等于阈值 threshold 的除数中 最小 的那个。
 * 每个数除以除数后都向上取整，比方说 7/3 = 3 ， 10/2 = 5 。
 *
 * 题目保证一定有解。
 */
public class SmallestDivisor {

    /**
     * 二分答案
     * @param nums
     * @param threshold
     * @return
     */
    public int smallestDivisor(int[] nums, int threshold) {
        // [left, right]
        Arrays.sort(nums);
        int left = 1, right = nums[nums.length - 1];
        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = getSum(nums, mid);
            // 满足条件
            if (sum <= threshold) {
                // 维护未知边界
                // sum < threshold 说明 被除数太大 right移动 减小被除数
                right = mid - 1;
            } else {
                // sum > threshold 说明 被除数太小 left移动 增大被除数
                left = mid + 1;
            }
        }
        return right + 1;
    }

    private int getSum(int[] nums, int i) {
        int result = 0;
        for (int num : nums) {
            result += ((num  + i - 1) / i);
        }
        return result;
    }

    public static void main(String[] args) {
        SmallestDivisor smallestDivisor = new SmallestDivisor();
        int result = smallestDivisor.smallestDivisor(new int[]{2,3,5,7,11}, 11);
        System.out.println(result);
    }

}
