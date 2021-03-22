package com.gmy.leetcode.dac;


public class MaxSubArrayReview {

    public int maxSubArray(int[] nums) {
        int maxRes = nums[0], pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(nums[i], pre + nums[i]);
            maxRes = Math.max(pre, maxRes);
        }
        return maxRes;
    }


    private class Status {

        // 区间和
        int iSum;
        // 左端点为起点的最大和
        int lSum;
        // 右端点为起的的最大和
        int rSum;
        // 区间内最大子序列和
        int mSum;

        public Status(int iSum, int lSum, int rSum, int mSum) {
            this.iSum = iSum;
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
        }

        public Status() {
        }
    }

    public Status search(int[] nums, int left, int right) {
        if (left == right) {
            return new Status(nums[left], nums[left], nums[left], nums[left]);
        }
        int mid = (left + right) / 2;
        Status leftStatus = search(nums, left, mid);
        Status rightStatus = search(nums, mid + 1, right);
        return pushUp(leftStatus, rightStatus);
    }

    public Status pushUp(Status left, Status right) {
        Status up = new Status();
        up.iSum = left.iSum + right.iSum;
        // 父节点rSum 两种情况 一种 右子节点的的Rsum 或者 右子节点的iSum + 左子节点的rSum
        up.rSum = Math.max(right.rSum, left.rSum + right.iSum);
        up.lSum = Math.max(left.lSum, right.lSum + left.iSum);
        // 父节点的mSum 三种情况 1.左子节点的mSum 2.右子节点的mSum 3.左子节点的rSum + 右子节点的lSum
        up.mSum = Math.max(Math.max(left.mSum, right.mSum), left.rSum + right.lSum);
        return up;
    }

    public int maxSubArray1(int[] nums) {
        Status search = search(nums, 0, nums.length - 1);
        return search.mSum;
    }

    public static void main(String[] args) {
        MaxSubArrayReview maxSubArray = new MaxSubArrayReview();
        int i = maxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        int i1 = maxSubArray.maxSubArray1(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
        System.out.println(i1);
    }

}
