package com.gmy.leetcode.dac;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class MaxSubArray {

    private int max = 0;

    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public int maxSubArray1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            max += nums[i];
        }
        cal(nums, 0, nums.length - 1, max);
        return this.max;
    }

    private void cal(int[] nums, int left, int right, int max) {
        if (max > this.max) {
            this.max = max;
        }
        if (left < right) {
            cal(nums, left + 1, right, max - nums[left]);
            cal(nums, left, right - 1, max - nums[right]);
        }
    }

    // 线段树做
    class Status {

        // 左子树总和
        private int lSum;
        // 右子树总和
        private int rSum;
        // 总和
        private int iSum;
        // 最大子序列和
        private int mSum;

        public Status(int lSum, int rSum, int iSum, int mSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.iSum = iSum;
            this.mSum = mSum;
        }
    }

    public int maxSubArray2(int[] nums) {
        Status search = search(nums, 0, nums.length - 1);
        return search.mSum;
    }

    private Status search(int[] nums, int left, int right) {
        if (left == right) {
            return new Status(nums[left], nums[left], nums[left], nums[left]);
        }
        int mid = (left + right) / 2;
        Status lStatus = search(nums, left, mid);
        Status rStatus = search(nums, mid + 1, right);
        return pushUp(lStatus, rStatus);
    }

    private Status pushUp(Status left, Status right) {
        int iSum = left.iSum + right.iSum;
        int lSum = Math.max(left.lSum, (left.iSum + right.lSum));
        int rSum = Math.max(right.rSum, (right.iSum + left.rSum));
        int mSum = Math.max(Math.max(left.mSum, right.mSum), left.rSum + right.lSum);
        Status status = new Status(lSum, rSum, iSum, mSum);
        return status;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, -100, 9, 8, 7};
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(arr));
        System.out.println(maxSubArray.maxSubArray2(arr));
    }

}
