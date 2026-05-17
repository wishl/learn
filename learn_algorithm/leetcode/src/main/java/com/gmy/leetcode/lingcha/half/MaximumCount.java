package com.gmy.leetcode.lingcha.half;

/**
 * 给你一个按 非递减顺序 排列的数组 nums ，返回正整数数目和负整数数目中的最大值。
 * 换句话讲，如果 nums 中正整数的数目是 pos ，而负整数的数目是 neg ，返回 pos 和 neg二者中的最大值。
 * 注意：0 既不是正整数也不是负整数。
 *
 * https://leetcode.cn/problems/maximum-count-of-positive-integer-and-negative-integer/description/
 */
public class MaximumCount {

    public int maximumCount(int[] nums) {
        // 先计算大于等于1的最小index就是证书的范围
        // 小于0可以转换成 大于等于 0 的数的左边那个
        int pos = find(nums, 1);
        // 没有正数或者都是正数 则返回长度
        if (pos == nums.length - 1 || pos == 0) {
            return nums.length;
        }
        int neg = find(nums, 0) - 1;
        // 计算最大值
        return Math.max(neg + 1, nums.length - pos);
    }

    /**
     * 计算大于等于target的最小index
     * @param nums
     * @param target
     * @return
     */
    private int find(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        MaximumCount maximumCount = new MaximumCount();
        int result = maximumCount.maximumCount(new int[]{5,20,66,1314});
        System.out.println(result);
    }
}
