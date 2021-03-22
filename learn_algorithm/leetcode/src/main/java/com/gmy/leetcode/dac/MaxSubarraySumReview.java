package com.gmy.leetcode.dac;

/**
 * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 * https://leetcode-cn.com/problems/contiguous-sequence-lcci/solution/lian-xu-shu-lie-by-leetcode-solution-be4z/
 */
public class MaxSubarraySumReview {

    /**
     * kadane 方法
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            current = Math.max(num, current + num);
            maxSum = Math.max(maxSum, current);
        }
        return maxSum;
    }

    /**
     * 分治方法
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        return calMax(nums, 0, nums.length - 1);
    }

    private int calMax(int[] nums, int left, int right) {
        if (left >= right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        int leftMax = calMax(nums, left, mid);
        int rightMax = calMax(nums, mid + 1, right);
        int currentMax = 0;
        System.out.println("left=" + left + " mid=" + mid + " right=" + right);
        for (int i = left; i <= right; i++) {
            currentMax += nums[i];
        }
        return Math.max(Math.max(leftMax, rightMax), currentMax);
    }

    public static void main(String[] args) {
        int[] result = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        MaxSubarraySumReview review = new MaxSubarraySumReview();
//        int i = review.maxSubArray(result);
        int i1 = review.maxSubArray1(result);
//        System.out.println(i);
        System.out.println(i1);
    }

}
